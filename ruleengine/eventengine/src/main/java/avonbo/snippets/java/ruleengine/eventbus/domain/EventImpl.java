package avonbo.snippets.java.ruleengine.eventbus.domain;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class EventImpl implements Event {

    /**
     *
     */
    private static final long serialVersionUID = 8676974219796917956L;

    private int id;

    private String name;

    private final Map<String, Object> variables = new HashMap<>();

    private Date ocurred;

    private Date noticed;

    /*
     * (non-Javadoc)
     *
     * @see avonbo.snippets.java.ruleengine.eventbus.domain.Event#getId()
     */
    @Override
    public int getId() {
        return this.id;
    }

    /*
     * (non-Javadoc)
     *
     * @see avonbo.snippets.java.ruleengine.eventbus.domain.Event#getName()
     */
    @Override
    public String getName() {
        return this.name;
    }

    /*
     * (non-Javadoc)
     *
     * @see avonbo.snippets.java.ruleengine.eventbus.domain.Event#getNoticed()
     */
    @Override
    public Date getNoticed() {
        return this.noticed;
    }

    /*
     * (non-Javadoc)
     *
     * @see avonbo.snippets.java.ruleengine.eventbus.domain.Event#getOcurred()
     */
    @Override
    public Date getOcurred() {
        return this.ocurred;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * avonbo.snippets.java.ruleengine.eventbus.domain.Event#getVariable(java.
     * lang.String)
     */
    @Override
    public Object getVariable(String key) {
        return this.variables.get(key);
    }

    /*
     * (non-Javadoc)
     *
     * @see avonbo.snippets.java.ruleengine.eventbus.domain.Event#setId(int)
     */
    @Override
    public void setId(int id) {
        this.id = id;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * avonbo.snippets.java.ruleengine.eventbus.domain.Event#setName(java.lang.
     * String)
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * avonbo.snippets.java.ruleengine.eventbus.domain.Event#setNoticed(java.
     * util.Date)
     */
    @Override
    public void setNoticed(Date noticed) {
        this.noticed = noticed;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * avonbo.snippets.java.ruleengine.eventbus.domain.Event#setOcurred(java.
     * util.Date)
     */
    @Override
    public void setOcurred(Date ocurred) {
        this.ocurred = ocurred;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * avonbo.snippets.java.ruleengine.eventbus.domain.Event#setVariable(java.
     * lang.String, java.lang.Object)
     */
    @Override
    public void setVariable(String key, Object data) {
        this.variables.put(key, data);
    }

}
