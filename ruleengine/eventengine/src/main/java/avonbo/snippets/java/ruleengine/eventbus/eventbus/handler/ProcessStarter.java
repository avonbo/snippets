package avonbo.snippets.java.ruleengine.eventbus.eventbus.handler;

import avonbo.snippets.java.ruleengine.eventbus.domain.EventImpl;
import avonbo.snippets.java.ruleengine.eventbus.service.ProcessingService;

public class ProcessStarter extends AbstractHandler {

    private ProcessingService run;

    @Override
    void execute(EventImpl messageEvent) {
        this.run.setArguments(messageEvent);
        this.run.execute();

    }

    public String getProcessToStart() {
        return this.run.getClass().getName();
    }

    public void setProcessToStart(ProcessingService processToStart) {
        this.run = processToStart;
    }

}
