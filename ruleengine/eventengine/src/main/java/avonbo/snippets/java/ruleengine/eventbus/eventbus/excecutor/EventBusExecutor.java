package avonbo.snippets.java.ruleengine.eventbus.eventbus.excecutor;

import java.util.concurrent.Executor;

public class EventBusExecutor implements Executor {

    @Override
    public void execute(Runnable command) {
        command.run();

    }

}
