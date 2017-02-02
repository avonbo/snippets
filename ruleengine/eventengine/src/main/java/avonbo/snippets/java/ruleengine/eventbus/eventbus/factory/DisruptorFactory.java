package avonbo.snippets.java.ruleengine.eventbus.eventbus.factory;

import java.util.concurrent.Executor;

import com.lmax.disruptor.dsl.Disruptor;

import avonbo.snippets.java.ruleengine.eventbus.domain.EventImpl;
import avonbo.snippets.java.ruleengine.eventbus.eventbus.excecutor.EventBusExecutor;

public class DisruptorFactory {

    public Disruptor<EventImpl> createLocalBusinessEventDiruptor() {
        // The factory for the event
        final BusinessEventFactory factory = new BusinessEventFactory();

        // Specify the size of the ring buffer, must be power of 2.
        final int bufferSize = 1024;

        final Executor executor = new EventBusExecutor();

        // Construct the Disruptor
        final Disruptor<EventImpl> disruptor = new Disruptor<EventImpl>(factory, bufferSize, executor);

        return disruptor;
    }
}
