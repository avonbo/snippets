package avonbo.snippets.java.ruleengine.eventbus.service;

import java.util.Map;

import avonbo.snippets.java.ruleengine.eventbus.domain.Event;
import avonbo.snippets.java.ruleengine.eventbus.domain.EventImpl;
import avonbo.snippets.java.ruleengine.eventbus.eventbus.BusinessEventBus;
import avonbo.snippets.java.ruleengine.eventbus.eventbus.handler.AbstractHandler;

public class EventBusImpl implements EventBus {

    private BusinessEventBus eventBus;

    @Override
    public void post(String type, String name) {
        final Event e = new EventImpl();
        e.setName(name);

        this.eventBus.post(e);
    }

    @Override
    public void post(String type, String name, Map<String, Object> properties) {
        final Event e = new EventImpl();
        e.setName(name);
        for (final String key : properties.keySet()) {
            e.setVariable(key, properties.get(key));
        }
        this.eventBus.post(e);

    }

    @Override
    public void registerProcessConsumer(AbstractHandler handlerToAdd) {
        this.eventBus.registerHandler(handlerToAdd);
    }

}
