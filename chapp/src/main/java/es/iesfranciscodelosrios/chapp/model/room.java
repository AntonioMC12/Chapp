package es.iesfranciscodelosrios.chapp.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Sala")
public class room implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@XmlAttribute(name="Nombre")
	protected String name;
	@XmlElementWrapper(name="Mensajes")
	@XmlElement(name="Mensaje", type = message.class)
	protected List<message> listMessage;
	@XmlElementWrapper(name="Usuarios")
	@XmlElement(name="Usuario", type = user.class)
	protected List<user> listUser;
	@XmlAttribute(name=":18")
	//si al name :18 no le pongo los ':', peta.
	protected boolean under18;
	
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
	
	public void addMessage(message ms) {
		this.listMessage.add(ms);
	}

	@Override
	public String toString() {
		return  name ;
	}
	
	
	
}