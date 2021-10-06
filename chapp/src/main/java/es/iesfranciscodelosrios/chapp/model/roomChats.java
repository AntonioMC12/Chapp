package es.iesfranciscodelosrios.chapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "roomChats")

public class roomChats implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<room>chats = new ArrayList<>();
	private String name;
	
	public roomChats() {
		super();
	}

	public roomChats(List<room> chats, String name) {
		super();
		this.chats = chats;
		this.name = name;
	}

	public List<room> getChats() {
		return chats;
	}

	public void setChats(List<room> chats) {
		this.chats = chats;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
