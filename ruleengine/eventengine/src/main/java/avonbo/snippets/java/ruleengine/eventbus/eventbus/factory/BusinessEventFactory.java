package avonbo.snippets.java.ruleengine.eventbus.eventbus.factory;

import avonbo.snippets.java.ruleengine.eventbus.domain.Message;

import com.lmax.disruptor.EventFactory;

public class BusinessEventFactory implements EventFactory<Message> {

	@Override
	public Message newInstance() {
		return new Message();
	}

}
