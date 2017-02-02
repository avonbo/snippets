package avonbo.snippets.java.ruleengine.eventbus.eventbus.handler;

import org.mvel2.MVEL;

import com.lmax.disruptor.EventHandler;

import avonbo.snippets.java.ruleengine.eventbus.domain.EventImpl;

public abstract class AbstractHandler implements EventHandler<EventImpl> {

    private String ruleExpression;

    abstract void execute(EventImpl messageEvent);

    @Override
    public void onEvent(EventImpl messageEvent, long sequence, boolean endOfBatch) throws Exception {

        if (this.ruleExpression != null) {
            final Boolean result = (Boolean) MVEL.eval(this.ruleExpression, messageEvent);

            if (result) {
                this.execute(messageEvent);
            }
        }

    }

    public void setRuleExpression(String ruleExpression) {
        this.ruleExpression = ruleExpression;
    }

}
