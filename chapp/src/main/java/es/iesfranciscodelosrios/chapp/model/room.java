package es.iesfranciscodelosrios.chapp.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "room")
public class room implements Serializable {
	
	private static final long serialVersionUID = 1L;

	// private static final int ID = 0;
	@XmlElement(name="message",type= message.class)
	private String name;
	private List<message> listMessage;
	private List<user> listUser;
	private boolean under18;
	
	public room() {
		super();
	}

	public room(String name, List<message> listMessage, List<user> listUser, boolean under18) {
		super();
		this.name = name;
		this.listMessage = listMessage;
		this.listUser = listUser;
		this.under18 = under18;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<message> getListMessage() {
		return listMessage;
	}

	public void setListMessage(List<message> listMessage) {
		this.listMessage = listMessage;
	}

	public List<user> getListUser() {
		return listUser;
	}

	public void setListUser(List<user> listUser) {
		this.listUser = listUser;
	}

	public boolean isUnder18() {
		return under18;
	}

	public void setUnder18(boolean under18) {
		this.under18 = under18;
	}
	
}
	