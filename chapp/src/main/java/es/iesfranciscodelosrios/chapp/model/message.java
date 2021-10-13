package es.iesfranciscodelosrios.chapp.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
//import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import es.iesfranciscodelosrios.chapp.utils.LocalDateAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "message")
public class message implements Serializable {

	private static final long serialVersionUID = 1L;
	@XmlJavaTypeAdapter(value = LocalDateAdapter.class)
	private LocalDateTime timer;
	@XmlElement(name = "Usuairo", type = user.class)
	private user user;
	@XmlElement(name = "Mensaje")
	private String messages;

	public message() {
		super();
	}

	public message(LocalDateTime timer, user user, String messages) {
		super();
		this.timer = timer;
		this.user = user;
		this.messages = messages;
	}

	public LocalDateTime getTimer() {
		return timer;
	}

	public void setTimer(LocalDateTime timer) {
		this.timer = timer;
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}

	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}

	@Override
	public String toString() {
		return "[ " + timer + ", "+ user + "]      " + messages ;
	}

}