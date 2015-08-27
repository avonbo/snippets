package avonbo.snippets.java.ruleengine.simplerules;

import java.util.ArrayList;
import java.util.List;

public class ExecutionResultSet {

	private final List<RuleExcecution> firedRules;

	protected ExecutionResultSet(List<RuleExcecution> firedRules) {
		this.firedRules = firedRules;
	}

	public List<String> getFiredFullqualifiedRuleNames() {
		final List<String> firedRuleNames = new ArrayList<String>();
		for (final RuleExcecution r : firedRules) {
			firedRuleNames.add(r.getFullyQualifiedName());
		}
		return firedRuleNames;
	}

	public List<String> getFiredRuleNames() {
		final List<String> firedRuleNames = new ArrayList<String>();
		for (final RuleExcecution r : firedRules) {
			firedRuleNames.add(r.getName());
		}
		return firedRuleNames;
	}

	public List<Object> getOutputs() {
		final ArrayList<Object> outs = new ArrayList<Object>();
		for (final RuleExcecution r : firedRules) {
			outs.add(r.getOutput());
		}
		return outs;
	}

}

class RuleExcecution {

	private final Rule firedRule;
	private final Object input;
	private final Object output;

	protected RuleExcecution(Object input, Rule firedRule, Object output) {
		this.input = input;
		this.firedRule = firedRule;
		this.output = output;
	}

	public Rule getFiredrRule() {
		return firedRule;
	}

	public String getFullyQualifiedName() {
		return firedRule.getFullyQualifiedName();
	}

	public Object getInput() {
		return input;
	}

	public String getName() {
		return firedRule.getName();
	}

	public Object getOutput() {
		return output;
	}
}