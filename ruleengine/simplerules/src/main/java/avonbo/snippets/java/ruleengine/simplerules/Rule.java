package avonbo.snippets.java.ruleengine.simplerules;

import java.io.Serializable;

import org.mvel2.MVEL;

public class Rule implements Comparable<Rule> {

	private final String action;
	private final String namespace;
	private final String name;
	private final String expression;
	private final Serializable compliledAction;
	private final int priority;

	public Rule(final String name, final int priority, final String expression, final String action) {
		this(name, null, priority, expression, action);
	}

	public Rule(final String name, final String namespace, final int priority, final String expression,
			final String action) {

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
		compliledAction = MVEL.compileExpression(action);
	}

	public int compareTo(Rule otherRule) {
		int comparator = 0;
		if (priority != otherRule.priority) {
			comparator = priority > otherRule.priority ? -1 : 1;
		} else {
			comparator = this.getFullyQualifiedName().compareTo(otherRule.getFullyQualifiedName());
		}

		return comparator;
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
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (namespace == null) {
			if (other.namespace != null) {
				return false;
			}
		} else if (!namespace.equals(other.namespace)) {
			return false;
		}
		return true;
	}

	public String getAction() {
		return action;
	}

	public Serializable getCompliledAction() {
		return compliledAction;
	}

	public String getExpression() {
		return expression;
	}

	public String getFullyQualifiedName() {
		if (namespace != null && !"".equals(namespace)) {
			return namespace + "." + name;
		}
		return name;
	}

	public String getName() {
		return name;
	}

	public String getNamespace() {
		return namespace;
	}

	public int getPriority() {
		return priority;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (name == null ? 0 : name.hashCode());
		result = prime * result + (namespace == null ? 0 : namespace.hashCode());
		return result;
	}

	@Override
	public String toString() {
		String qualifiedName = null;
		if (namespace != null) {
			qualifiedName = namespace + "." + name;
		} else {
			qualifiedName = name;
		}

		return "Rule [" + qualifiedName + "] when " + expression + " then " + action;
	}

}
