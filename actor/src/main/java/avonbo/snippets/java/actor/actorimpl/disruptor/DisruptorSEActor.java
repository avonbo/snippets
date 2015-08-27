package avonbo.snippets.java.actor.actorimpl.disruptor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import avonbo.snippets.java.actor.Actor;
import avonbo.snippets.java.actor.Behavior;
import avonbo.snippets.java.actor.actorimpl.ActorMessage;

/**
 * Implements an actor with the disruptor framwork for java se.
 *
 * @author Alexander von Boguszewski
 *
 * @param <T>
 */
public final class DisruptorSEActor<T> implements Actor<T> {

	/**
	 * Default size of disruptor ringbuffer
	 */
	private static int BUFFERSIZE = 1024;

	/**
	 * all behaviors performed after call publish
	 */
	private final List<Behavior<T>> behaviors;

	/**
	 * the disruptor ringbuffer used for communicaton
	 */
	private final RingBuffer<ActorMessage<T>> ringBuffer;

	/**
	 * Initialize the actor/message sheduling engine for single behavior
	 * only one action will performed after receiving a message
	 * @param behaviors
	 */
	public DisruptorSEActor(Behavior<T> behavior) {
		this(behavior, BUFFERSIZE);
	}

	/**
	 * Initialize the actor/message sheduling engine for single behavior
	 * only one action will performed after receiving a message
	 * @param behaviors
	 * @param buffersize, depends on size of the message
	 */
	@SuppressWarnings("unchecked")
	public DisruptorSEActor(Behavior<T> behavior, int buffersize) {
		this.behaviors = new ArrayList<Behavior<T>>(1);
		this.behaviors.add(behavior);

		final Executor executor = this.loeadExcecutor();

		// The factory for the messages
		final EventFactory<ActorMessage<T>> factory =
				new DisruptorMessageEventFactory<T>();

		// Construct the Disruptor
		final Disruptor<ActorMessage<T>> disruptor =
				new Disruptor<ActorMessage<T>>(factory, buffersize, executor);

		// Connect the handler
		disruptor.handleEventsWith(new DisruptorMessageEventHandler(behavior));

		// Start the Disruptor, starts all threads running
		disruptor.start();

		// Get the ring buffer from the Disruptor to be used for publishing.
		this.ringBuffer = disruptor.getRingBuffer();

	}

	/**
	 * Initialize the actor/message sheduling engine for multiple behaviors
	 * A message will be send to all behaviors.
	 * @param behaviors
	 */
	public DisruptorSEActor(List<Behavior<T>> behaviors) {
		this(behaviors, BUFFERSIZE);
	}

	/**
	 * Initialize the actor/message sheduling engine for multiple behaviors
	 *  A message will be send to all behaviors.
	 * @param behaviors
	 * @param buffersize depends on the size of the messages
	 */
	public DisruptorSEActor(List<Behavior<T>> behaviors, int buffersize) {
		this.behaviors = behaviors;

		final Executor executor = this.loeadExcecutor();

		// The factory for the messages
		final EventFactory<ActorMessage<T>> factory =
				new DisruptorMessageEventFactory<T>();

		// Construct the Disruptor
		final Disruptor<ActorMessage<T>> disruptor =
				new Disruptor<ActorMessage<T>>(factory, buffersize, executor);

		// Connect the handler
		for (final Behavior<T> behavior : behaviors) {
			disruptor.handleEventsWith(new DisruptorMessageEventHandler(behavior));
		}

		// Start the Disruptor, starts all threads running
		disruptor.start();

		// Get the ring buffer from the Disruptor to be used for publishing.
		this.ringBuffer = disruptor.getRingBuffer();

	}

	public List<Behavior<T>> getBehaviors() {
		return this.behaviors;
	}

	/**
	 * creates threadpool for the behaviors
	 * @see Executor
	 * @see Executors
	 * @return
	 */
	private Executor loeadExcecutor() {
		final Executor executor = Executors.newCachedThreadPool();
		return executor;
	}

	/**
	 * publish a object through a disruptor ringbuffer
	 * to all registered behaviors
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
