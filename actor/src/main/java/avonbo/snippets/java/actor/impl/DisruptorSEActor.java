package avonbo.snippets.java.actor.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import avonbo.snippets.java.actor.Actor;
import avonbo.snippets.java.actor.Behavior;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

public final class DisruptorSEActor<T> implements Actor<T> {

    private static int BUFFERSIZE = 1024;

    private final List<Behavior<T>> behaviors;
    private final RingBuffer<ActorMessage<T>> ringBuffer;

    public DisruptorSEActor(Behavior<T> behavior) {
        this(behavior, BUFFERSIZE);
    }

    public DisruptorSEActor(Behavior<T> behavior, int buffersize) {
        this.behaviors = new ArrayList<Behavior<T>>(1);
        this.behaviors.add(behavior);

        final Executor executor = this.loeadExcecutor();

        // The factory for the messages
        final EventFactory<ActorMessage<T>> factory = new ActorMessageEventFactory<T>();

        // Construct the Disruptor
        final Disruptor<ActorMessage<T>> disruptor =
                new Disruptor<ActorMessage<T>>(factory, buffersize, executor);

        // Connect the handler
        disruptor.handleEventsWith(new ActorMessageEventHandler(behavior));

        // Start the Disruptor, starts all threads running
        disruptor.start();

        // Get the ring buffer from the Disruptor to be used for publishing.
        this.ringBuffer = disruptor.getRingBuffer();

    }

    public DisruptorSEActor(List<Behavior<T>> behaviors) {
        this(behaviors, BUFFERSIZE);
    }

    public DisruptorSEActor(List<Behavior<T>> behaviors, int buffersize) {
        this.behaviors = behaviors;

        final Executor executor = this.loeadExcecutor();

        // The factory for the messages
        final EventFactory<ActorMessage<T>> factory = new ActorMessageEventFactory<T>();

        // Construct the Disruptor
        final Disruptor<ActorMessage<T>> disruptor =
                new Disruptor<ActorMessage<T>>(factory, buffersize, executor);

        // Connect the handler
        for (final Behavior<T> behavior : behaviors) {
            disruptor.handleEventsWith(new ActorMessageEventHandler(behavior));
        }

        // Start the Disruptor, starts all threads running
        disruptor.start();

        // Get the ring buffer from the Disruptor to be used for publishing.
        this.ringBuffer = disruptor.getRingBuffer();

    }

    public List<Behavior<T>> getBehaviors() {
        return this.behaviors;
    }

    private Executor loeadExcecutor() {
        final Executor executor = Executors.newCachedThreadPool();
        return executor;
    }

    /*
     * (non-Javadoc)
     * 
     * @see avonbo.snippets.java.actor.Actor#publish(T)
     */
    @Override
    public void publish(final T body) {
        final long sequence = this.ringBuffer.next();
        final ActorMessage<T> msg = this.ringBuffer.get(sequence);
        msg.setBody(body);
        this.ringBuffer.publish(sequence);
    }

}
