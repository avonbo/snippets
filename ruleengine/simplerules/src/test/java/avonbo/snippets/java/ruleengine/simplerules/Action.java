package avonbo.snippets.java.ruleengine.simplerules;

public class Action {

    private final String actionName;

    public Action(String name) {
        this.actionName = name;
    }

    public String excecute() {
        return this.actionName;
    }

    @Override
    public String toString() {
        return this.actionName + " Action";
    }

}
