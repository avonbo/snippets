package avonbo.snippets.java.ruleengine.eventbus.eventbus.consumer;

import java.util.logging.Logger;

import avonbo.snippets.java.ruleengine.eventbus.domain.Message;

public class ProcessStarter implements EventHandler<Message> {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(ProcessStarter.class);

    private String processToStart;

    private String ruleExpression;

    public String getProcessToStart() {
        return this.processToStart;
    }

    @Override
    public void onEvent(Message messageEvent, long sequence, boolean endOfBatch)
            throws Exception {

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("get event {}", messageEvent.getName());
        }

        // should be boolean TODO use simple rule engine to capsulate mvel
        final Boolean result = (Boolean) MVEL.eval(this.ruleExpression, messageEvent);

        if (result) {

            // TODO add attrributes to start special process with process
            // variables
            // startProcessInstance(getProcessToStart());
        }

    }

    public void setProcessToStart(String processToStart) {
        this.processToStart = processToStart;
    }

    public void setRuleExpression(String ruleExpression) {
        this.ruleExpression = ruleExpression;
    }

}
