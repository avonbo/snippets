package avonbo.snippets.java.ruleengine.simplerules;

public class Action {

	private final String actionName;

	public Action(String name) {
		actionName = name;
	}

	public String excecute() {
		return actionName;
	}

	@Override
	public String toString() {
		return actionName + " Action";
	}

}
