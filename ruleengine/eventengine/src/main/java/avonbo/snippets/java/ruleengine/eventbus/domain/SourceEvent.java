package avonbo.snippets.java.ruleengine.eventbus.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SourceEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7776883312150429600L;

	@Id
	@GeneratedValue
	private int id;

	private SourceType source;

	private EventType type;

	private Date ocurred;

	private Date noticed;

	//
	// @ManyToMany(cascade = CascadeType.ALL)
	// private Map<String, String> variables;

	public int getId() {
		return id;
	}

	public Date getNoticed() {
		return noticed;
	}

	public Date getOcurred() {
		return ocurred;
	}

	public SourceType getSource() {
		return source;
	}

	public EventType getType() {
		return type;
	}

	// public Map<String, String> getVariables() {
	// return variables;
	// }

	public void setId(int id) {
		this.id = id;
	}

	public void setNoticed(Date noticed) {
		this.noticed = noticed;
	}

	public void setOcurred(Date ocurred) {
		this.ocurred = ocurred;
	}

	public void setSource(SourceType source) {
		this.source = source;
	}

	public void setType(EventType type) {
		this.type = type;
	}

	// public void setVariables(Map<String, String> variables) {
	// this.variables = variables;
	// }

}
