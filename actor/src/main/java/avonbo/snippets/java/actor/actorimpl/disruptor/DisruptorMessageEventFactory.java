package avonbo.snippets.java.actor.actorimpl.disruptor;

import avonbo.snippets.java.actor.actorimpl.ActorMessage;

/**
 * only for disruptor compatibility
 *
 * @author Alexander von Boguszewski
 *
 * @param <T>
 */
public class DisruptorMessageEventFactory<T> implements com.lmax.disruptor.EventFactory<ActorMessage<T>> {

	@Override
	public ActorMessage<T> newInstance() {
		return new ActorMessage<T>();
	}

}