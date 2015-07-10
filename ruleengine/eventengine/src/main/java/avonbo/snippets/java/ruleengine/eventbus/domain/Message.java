package avonbo.snippets.java.ruleengine.eventbus.domain;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -646806168101925272L;

	private final Date ocurred = new Date(System.currentTimeMillis());

	private String name;

	public String getName() {
		return name;
	}

	public Date getOcurred() {
		return ocurred;
	}

	public void setName(String name) {
		this.name = name;
	}

}
