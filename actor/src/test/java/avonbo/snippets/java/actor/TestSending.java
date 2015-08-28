package avonbo.snippets.java.actor;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import avonbo.snippets.java.actor.actorimpl.disruptor.DisruptorSEActor;

public class TestSending {

	@Test
	public void testSend() {
		final ReceivedMessageCheckingBehaviour behaviour = new ReceivedMessageCheckingBehaviour();

		final Actor<MyMessage> a = new DisruptorSEActor<>(behaviour);

		final MyMessage msg = new MyMessage();
		msg.setMessage("initial");

		try {
			a.publish(msg);
			Thread.sleep(1000);
		} catch (final InterruptedException e) {
		}

		assertEquals("initial", behaviour.getMessage());
	}

	@Test
	public void testSendTwoReceiver() {
		final ReceivedMessageCheckingBehaviour behaviour1
		= new ReceivedMessageCheckingBehaviour();
		final ReceivedMessageCheckingBehaviour behaviour2
		= new ReceivedMessageCheckingBehaviour();

		final List<ReceivedMessageCheckingBehaviour> behaviors
		= Arrays.asList(behaviour1, behaviour2);

		final Actor<MyMessage> a = new DisruptorSEActor(behaviors);

		final MyMessage msg = new MyMessage();
		msg.setMessage("initial");

		try {
			a.publish(msg);
			Thread.sleep(1000);
		} catch (final InterruptedException e) {
		}

		assertEquals("initial", behaviour1.getMessage());
	}

}
