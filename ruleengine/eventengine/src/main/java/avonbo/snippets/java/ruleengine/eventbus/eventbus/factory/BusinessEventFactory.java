package avonbo.snippets.java.ruleengine.eventbus.eventbus.factory;

import com.lmax.disruptor.EventFactory;

import avonbo.snippets.java.ruleengine.eventbus.domain.EventImpl;

public class BusinessEventFactory implements EventFactory<EventImpl> {

    @Override
    public EventImpl newInstance() {
        return new EventImpl();
    }

}
