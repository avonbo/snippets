package avonbo.snippets.java.ruleengine.eventbus.service;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * Perform SQL statements to create complex events and addd these events to event sourcing
 * @author vonbale
 *
 */
@Startup
@Singleton
public class ComplexEventProcessorServiceImpl {

	
	@Schedule(minute = "*/5", hour = "*")
	public void readData(){
		//TODO Implement Event creation factory
		System.out.println("Process complex events");
	}
}
