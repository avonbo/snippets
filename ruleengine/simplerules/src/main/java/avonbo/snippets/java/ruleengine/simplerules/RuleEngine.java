package avonbo.snippets.java.ruleengine.simplerules;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.mvel2.MVEL;

public class RuleEngine {

	private final Set<Rule> rules = new TreeSet<Rule>();

	public void addRule(Rule rule) {
		rules.add(rule);
	}

	public ExecutionResultSet execute(Object input) {

		final List<RuleExcecution> firedRules = new ArrayList<RuleExcecution>();

		for (final Rule r : rules) {
			final Boolean expressionFired = MVEL.evalToBoolean(r.getExpression(), input);
			if (expressionFired != null && expressionFired) {
				Object output = null;
				if (r.getAction() != null) {
					output = MVEL.executeExpression(r.getCompliledAction());
				}

				final RuleExcecution rEx = new RuleExcecution(input, r, output);
				firedRules.add(rEx);
			}

		}

		final ExecutionResultSet result = new ExecutionResultSet(firedRules);
		return result;
	}

}
