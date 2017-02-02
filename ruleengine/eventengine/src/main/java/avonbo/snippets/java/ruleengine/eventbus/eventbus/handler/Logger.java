package avonbo.snippets.java.ruleengine.eventbus.eventbus.handler;

import java.util.logging.Level;

import avonbo.snippets.java.ruleengine.eventbus.domain.EventImpl;

public class Logger extends AbstractHandler {

    private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getAnonymousLogger();

    @Override
    void execute(EventImpl messageEvent) {
        LOGGER.log(Level.INFO, "get event {}", messageEvent.getName());

    }

}
