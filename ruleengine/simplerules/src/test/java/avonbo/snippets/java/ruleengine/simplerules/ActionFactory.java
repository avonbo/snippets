package avonbo.snippets.java.ruleengine.simplerules;

public class ActionFactory {

    public static Action getRockAction() {
        return new Action("Rock");
    }

    public static Action getRaperAction() {
        return new Action("Paper");
    }

    public static Action getScissorsAction() {
        return new Action("Scissors");
    }

}
