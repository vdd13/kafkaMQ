package pl.dom.KafkaMQ.model;

import java.io.Serializable;

import lombok.Data;

public class Client implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8623704096406108438L;
	private String fName;
	private String lName;
	private Long id;
	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Client [fName=" + fName + ", lName=" + lName + ", id=" + id + "]";
	}
	
	
	
}
