package avonbo.snippets.java.ruleengine.simplerules;

import java.io.Serializable;

import org.mvel2.MVEL;

public class Rule implements Comparable<Rule> {

    private final String action;
    private final String namespace;
    private final String name;
    private final String expression;
    private final Serializable compliledExpression;
    private final int priority;

    public Rule(final String name, final String expression, final String action, final int priority,
            final String namespace) {

        if (name == null) {
            throw new AssertionError("name must not be null");
        }
        if (expression == null) {
            throw new AssertionError("expression must not be null");
        }

        this.namespace = namespace;
        this.name = name;
        this.priority = priority;
        this.expression = expression;
        this.action = action;
        this.compliledExpression = MVEL.compileExpression(expression);
    }

    public String getFullyQualifiedName() {
        if (this.namespace != null && !"".equals(this.namespace)) {
            return this.namespace + "." + this.name;
        }
        return this.name;
    }

    @Override
    public int compareTo(Rule otherRule) {
        int comparator = 0;
        if (this.priority != otherRule.priority) {
            comparator = this.priority > otherRule.priority ? 1 : -1;
        } else {
            comparator = this.getFullyQualifiedName().compareTo(otherRule.getFullyQualifiedName());
        }

        return comparator;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
        result = prime * result + ((this.namespace == null) ? 0 : this.namespace.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final Rule other = (Rule) obj;
        if (this.name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!this.name.equals(other.name)) {
            return false;
        }
        if (this.namespace == null) {
            if (other.namespace != null) {
                return false;
            }
        } else if (!this.namespace.equals(other.namespace)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Rule [" + this.namespace + "." + this.name + "] when " + this.expression + " then "
                + this.action;
    }

    public String getAction() {
        return this.action;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public String getName() {
        return this.name;
    }

    public String getExpression() {
        return this.expression;
    }

    public int getPriority() {
        return this.priority;
    }

    public Serializable getCompliledExpression() {
        return compliledExpression;
    }

}
