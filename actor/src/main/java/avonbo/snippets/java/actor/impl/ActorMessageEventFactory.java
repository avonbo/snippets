package avonbo.snippets.java.actor.impl;

public class ActorMessageEventFactory<T> implements com.lmax.disruptor.EventFactory<ActorMessage<T>> {

	@Override
	public ActorMessage<T> newInstance() {
		return new ActorMessage<T>();
	}

}