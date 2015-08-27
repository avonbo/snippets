package avonbo.snippets.java.actor.actorimpl.disruptor;

import com.lmax.disruptor.EventHandler;

import avonbo.snippets.java.actor.Behavior;
import avonbo.snippets.java.actor.actorimpl.ActorMessage;

public class DisruptorMessageEventHandler<T> implements EventHandler<ActorMessage<T>> {

	Behavior<T> behavior;

	public DisruptorMessageEventHandler(Behavior<T> behavior) {
		this.behavior = behavior;
	}

	@Override
	public void onEvent(ActorMessage<T> msg, long sequence, boolean endOfBatch) throws Exception {
		try {
			this.behavior.receive(msg.getBody());
		} catch (final Exception e) {
			this.behavior.exception(e);
		}

	}
}
