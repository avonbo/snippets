package avonbo.snippets.java.ruleengine.eventbus.service;

import avonbo.snippets.java.ruleengine.eventbus.domain.EventImpl;

public interface ProcessingService {

    void execute();

    void setArguments(EventImpl messageEvent);

}
