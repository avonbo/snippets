package avonbo.snippets.java.ruleengine.eventbus.domain;

import java.io.Serializable;
import java.util.Date;

public interface Event extends Serializable {

    int getId();

    String getName();

    Date getNoticed();

    Date getOcurred();

    Object getVariable(String key);

    void setId(int id);

    void setName(String name);

    void setNoticed(Date noticed);

    void setOcurred(Date ocurred);

    void setVariable(String key, Object data);

}