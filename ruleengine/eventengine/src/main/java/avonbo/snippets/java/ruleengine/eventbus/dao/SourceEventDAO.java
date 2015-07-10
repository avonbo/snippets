package avonbo.snippets.java.ruleengine.eventbus.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import avonbo.snippets.java.ruleengine.eventbus.domain.SourceEvent;

//TODO add load reply Events Methode
public class SourceEventDAO {

	@PersistenceContext(name = "event", unitName = "event")
	EntityManager em;

	/**
	 * Persist an Event to Persistence Context "event"
	 * @param event
	 */
	public void storeSourceEvent(SourceEvent event) {

		em.persist(event);
	}

}
