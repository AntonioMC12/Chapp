package es.iesfranciscodelosrios.chapp.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "message")
public class message implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@XmlElement(name="user",type=user.class)
	private LocalDateTime timer;
	private user user;
	private List<String> messages = new ArrayList<>();
	
	public message() {
		super();
	}

	public message(LocalDateTime timer, es.iesfranciscodelosrios.chapp.model.user user, List<String> messages) {
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

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	
	
}
