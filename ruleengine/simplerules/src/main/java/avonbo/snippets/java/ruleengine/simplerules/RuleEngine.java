package avonbo.snippets.java.ruleengine.simplerules;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.mvel2.MVEL;

public class RuleEngine {

    private final Set<Rule> rules = new TreeSet<Rule>();

    public void addRule(Rule rule) {
        this.rules.add(rule);
    }

    public ExecutionResultSet execute(Object input) {

        final List<String> firedRules = new ArrayList<String>();
        final List<Object> outputs = new ArrayList<Object>();

        for (final Rule r : this.rules) {
            final Object output = MVEL.executeExpression(r.getCompliledExpression(), input);
            if (output != null) {
                outputs.add(output);
            }
            firedRules.add(r.getFullyQualifiedName());
            System.out.println(output);
        }

        return null;
    }
}
