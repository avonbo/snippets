package avonbo.snippets.java.ruleengine.eventbus.service;

import java.util.Map;

import avonbo.snippets.java.ruleengine.eventbus.eventbus.handler.AbstractHandler;

public interface EventBus {

    public void post(String type, String name);

    public void post(String type, String name, Map<String, Object> properties);

    public void registerProcessConsumer(AbstractHandler handlerToAdd);
}
