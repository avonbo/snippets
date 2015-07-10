package avonbo.snippets.java.ruleengine.eventbus.eventbus.factory;

import java.util.concurrent.Executor;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import avonbo.snippets.java.ruleengine.eventbus.domain.Message;
import avonbo.snippets.java.ruleengine.eventbus.service.ExecutorServiceImpl;

import com.lmax.disruptor.dsl.Disruptor;

public class DisruptorFactory {

	Executor executor;

	public DisruptorFactory() throws NamingException {
		// Executor that will be used to construct new threads for consumers
		InitialContext initialContext = new InitialContext();
		executor = (Executor) initialContext.lookup("java:module/"
				+ ExecutorServiceImpl.EXECUTOR_JNDINAME);
	}

	public Disruptor<Message> createBusinessEventDiruptor() {

		// The factory for the event
		BusinessEventFactory factory = new BusinessEventFactory();

		// Specify the size of the ring buffer, must be power of 2.
		int bufferSize = 1024;

		// Construct the Disruptor
		Disruptor<Message> disruptor = new Disruptor<Message>(factory,
				bufferSize, executor);

		return disruptor;
	}
}
