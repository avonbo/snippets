package avonbo.snippets.java.ruleengine.eventbus.eventbus;

import avonbo.snippets.java.ruleengine.eventbus.domain.SourceEvent;
import avonbo.snippets.java.ruleengine.eventbus.eventbus.consumer.ProcessStarter;

public interface BusinessEventBus {

	public void post(SourceEvent event);

	public void registerEventConsumer(ProcessStarter consumer);

}