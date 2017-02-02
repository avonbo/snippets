package avonbo.snippets.java.ruleengine.eventbus.eventbus;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.naming.NamingException;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import avonbo.snippets.java.ruleengine.eventbus.domain.Event;
import avonbo.snippets.java.ruleengine.eventbus.domain.EventImpl;
import avonbo.snippets.java.ruleengine.eventbus.eventbus.factory.DisruptorFactory;
import avonbo.snippets.java.ruleengine.eventbus.eventbus.handler.AbstractHandler;

public class DisruptorEventBus implements BusinessEventBus {

    private final DisruptorFactory disruptorFactory;

    private Disruptor<EventImpl> disruptor;

    private final List<AbstractHandler> consumerList = new ArrayList<AbstractHandler>();
    private final Lock lock = new ReentrantLock();

    public DisruptorEventBus() throws NamingException {
        this.disruptorFactory = new DisruptorFactory();
    }

    private Disruptor<EventImpl> getDisruptor() {

        this.lock.lock();
        try {
            if (this.disruptor == null) {
                this.disruptor = this.disruptorFactory.createLocalBusinessEventDiruptor();
            }
            return this.disruptor;

        } finally {
            this.lock.unlock();
        }

    }

    @Override
    public void post(Event event) {

        final RingBuffer<EventImpl> ringBuffer = this.getDisruptor().getRingBuffer();

        final long sequence = ringBuffer.next();
        final Event newevent = ringBuffer.get(sequence);

        final UUID id = UUID.randomUUID();

        newevent.setName(id.toString());

        ringBuffer.publish(sequence);

    }

    @Override
    public void registerHandler(AbstractHandler consumer) {
        this.consumerList.add(consumer);
        this.startDisruptor();
    }

    private void startDisruptor() {

        final Disruptor<EventImpl> newDisruptor = this.disruptorFactory.createLocalBusinessEventDiruptor();
        for (final AbstractHandler eventConsumer : this.consumerList) {
            newDisruptor.handleEventsWith(eventConsumer);
        }
        newDisruptor.start();

        try {
            this.lock.lockInterruptibly();
            try {

                final Disruptor<EventImpl> oldDisruptor = this.disruptor;
                this.disruptor = newDisruptor;
                if (oldDisruptor != null) {
                    oldDisruptor.shutdown();
                }
            } finally {
                this.lock.unlock();
            }

        } catch (final InterruptedException e) {
        }

    }

}
