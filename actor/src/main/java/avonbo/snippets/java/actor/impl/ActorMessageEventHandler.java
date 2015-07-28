package avonbo.snippets.java.actor.impl;

import avonbo.snippets.java.actor.Behavior;

import com.lmax.disruptor.EventHandler;

public class ActorMessageEventHandler<T> implements EventHandler<ActorMessage<T>> {

    Behavior<T> behavior;

    public ActorMessageEventHandler(Behavior<T> behavior) {
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
