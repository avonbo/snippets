package avonbo.snippets.java.ruleengine.simplerules;

public class ExecutionResultSet<IN> {

    private boolean open;
    private final IN input;

    protected ExecutionResultSet(IN in) {
        this.input = in;
    }

}
