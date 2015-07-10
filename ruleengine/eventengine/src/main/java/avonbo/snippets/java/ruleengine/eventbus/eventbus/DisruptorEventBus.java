package avonbo.snippets.java.ruleengine.eventbus.eventbus;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.inject.Named;
import javax.naming.NamingException;

import avonbo.snippets.java.ruleengine.eventbus.domain.Message;
import avonbo.snippets.java.ruleengine.eventbus.domain.SourceEvent;
import avonbo.snippets.java.ruleengine.eventbus.eventbus.consumer.ProcessStarter;
import avonbo.snippets.java.ruleengine.eventbus.eventbus.factory.DisruptorFactory;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.EventHandlerGroup;

@Named("disruptor")
public class DisruptorEventBus implements BusinessEventBus {

	private final DisruptorFactory disruptorFactory;

	private Disruptor<Message> disruptor;

	private final List<ProcessStarter> consumerList = new ArrayList<ProcessStarter>();
	private Lock lock = new ReentrantLock();

	public DisruptorEventBus() throws NamingException {
		disruptorFactory = new DisruptorFactory();
	}

	private Disruptor<Message> getDisruptor() {

		lock.lock();
		try {
			if (disruptor == null) {
				disruptor = disruptorFactory.createBusinessEventDiruptor();
			}
			return disruptor;

		} finally {
			lock.unlock();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eurexchange.clear.bpm.controller.eventengine.v1.eventbus.BusinessEventBus
	 * #
	 * post(com.eurexchange.clear.bpm.controller.eventengine.v1.domain.BusinessEvent
	 * )
	 */
	@Override
	public void post(SourceEvent event) {

		RingBuffer<Message> ringBuffer = getDisruptor().getRingBuffer();

		long sequence = ringBuffer.next();
		Message newevent = ringBuffer.get(sequence);

		newevent.setName(event.getType().name());

		ringBuffer.publish(sequence);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.eurexchange.clear.bpm.controller.eventengine.v1.eventbus.BusinessEventBus
	 * #
	 * registerEventConsumer(com.eurexchange.clear.bpm.controller.eventengine.v1
	 * .eventbus.consumer.BusinessEventConsumer)
	 */
	@Override
	public void registerEventConsumer(ProcessStarter consumer) {
		consumerList.add(consumer);
		startDisruptor();
	}

	private void startDisruptor() {

		Disruptor<Message> newDisruptor = disruptorFactory
				.createBusinessEventDiruptor();
		for (ProcessStarter eventConsumer : consumerList) {
			@SuppressWarnings({ "unchecked", "unused" })
			EventHandlerGroup<Message> handleEventsWith = newDisruptor
					.handleEventsWith(eventConsumer);
		}
		newDisruptor.start();

		try {
			lock.lockInterruptibly();
			try {

				Disruptor<Message> oldDisruptor = disruptor;
				disruptor = newDisruptor;
				if (oldDisruptor != null) {
					oldDisruptor.shutdown();
				}
			} finally {
				lock.unlock();
			}

		} catch (InterruptedException e) {
		}

	}

}
