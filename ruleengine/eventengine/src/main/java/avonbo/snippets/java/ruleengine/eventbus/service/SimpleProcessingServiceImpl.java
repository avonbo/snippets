package avonbo.snippets.java.ruleengine.eventbus.service;

import avonbo.snippets.java.ruleengine.eventbus.domain.EventImpl;

public class SimpleProcessingServiceImpl implements ProcessingService {

    Runnable command;

    public SimpleProcessingServiceImpl(Runnable command) {

    }

    @Override
    public void execute() {
        this.command.run();
    }

    @Override
    public void setArguments(EventImpl messageEvent) {
        // not used

    }

}
