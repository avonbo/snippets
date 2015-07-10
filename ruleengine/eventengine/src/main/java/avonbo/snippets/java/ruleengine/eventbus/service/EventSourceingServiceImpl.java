package avonbo.snippets.java.ruleengine.eventbus.service;

import java.util.Map;

import javax.naming.NamingException;

import avonbo.snippets.java.ruleengine.eventbus.dao.SourceEventDAO;
import avonbo.snippets.java.ruleengine.eventbus.domain.EventType;
import avonbo.snippets.java.ruleengine.eventbus.domain.SourceEvent;
import avonbo.snippets.java.ruleengine.eventbus.domain.SourceType;
import avonbo.snippets.java.ruleengine.eventbus.eventbus.BusinessEventBus;
import avonbo.snippets.java.ruleengine.eventbus.eventbus.consumer.ProcessStarter;

@Startup
@Singleton
@EJB(name = ControllerLookups.EVENTENGINE, beanInterface = EventSourceingService.class)
public class EventSourceingServiceImpl implements EventSourceingService {

    @Inject
    private SourceEventDAO eventDao;

    @Inject
    private @Named("disruptor") BusinessEventBus eventBus;

    @Override
    public void add(String type, String name) {
        // TODO use factory
        final SourceEvent e = new SourceEvent();
        e.setSource(SourceType.HumanInteraction);
        e.setType(EventType.SimpleNotificationEvent);

        // first add to db
        this.eventDao.storeSourceEvent(e);

        // second add to eventstream
        this.eventBus.post(e);
    }

    @Override
    public void add(String type, String name, Map<String, Object> properties) {

        this.add(type, name);

    }

    // TODO Method for reprocessing events

    // TODO Exception handling inject process manager as param instead as jndi
    // lookup

    @Override
    public void registerProcessConsumer(String expression, String processToStart)
            throws NamingException {
        final ProcessStarter cons = new ProcessStarter();
        cons.setProcessToStart(processToStart);
        cons.setRuleExpression(expression);

        this.eventBus.registerEventConsumer(cons);
    }

}
