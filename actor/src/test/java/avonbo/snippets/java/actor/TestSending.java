package avonbo.snippets.java.actor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import avonbo.snippets.java.actor.actorimpl.disruptor.DisruptorSEActor;

public class TestSending {

	@Test
	public void testSend() {
		final ReceivedMessageCheckingBehaviour behaviour = new ReceivedMessageCheckingBehaviour();

		final Actor<String> a = new DisruptorSEActor<>(behaviour);
		try {
			a.publish("testing");
			Thread.sleep(1000);
		} catch (final InterruptedException e) {
		}

		assertEquals("testing", behaviour.getMessage());
	}

}
