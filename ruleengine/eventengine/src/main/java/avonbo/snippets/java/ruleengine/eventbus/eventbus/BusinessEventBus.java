package avonbo.snippets.java.ruleengine.eventbus.eventbus;

import avonbo.snippets.java.ruleengine.eventbus.domain.Event;
import avonbo.snippets.java.ruleengine.eventbus.eventbus.handler.AbstractHandler;

public interface BusinessEventBus {

    public void post(Event event);

    public void registerHandler(AbstractHandler consumer);

}