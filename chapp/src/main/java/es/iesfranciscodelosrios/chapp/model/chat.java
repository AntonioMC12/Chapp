package es.iesfranciscodelosrios.chapp.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "chat")
public class chat implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@XmlElementWrapper(name="Usuarios")
	@XmlElement(name="usuario", type = user.class)
	private List<user> users;
	@XmlElementWrapper(name="Salas")
	@XmlElement(name="Sala", type = room.class)
	private List<room> rooms;
	
	public chat() {
		super();
	}

	public chat(List<user> users, List<room> rooms) {
		super();
		this.users = users;
		this.rooms = rooms;
	}
	
	public chat(List<user> users) {
		super();
		this.users = users;
	}

	public List<user> getUsers() {
		return users;
	}

	public void setUsers(List<user> users) {
		this.users = users;
	}

	public List<room> getRooms() {
		return rooms;
	}

	public void setRooms(List<room> rooms) {
		this.rooms = rooms;
	}
	
	public void addUser(user u) {
		this.users.add(u);
	}
	
	public void addRoom(room r) {
		this.rooms.add(r);
	}
	
	public void deleteUser(user u) {
		if(this.users.contains(u)) {
			this.users.remove(u);
		}
	}
	
	public void deleteRoom(room r) {
		if(this.rooms.contains(r)) {
			this.rooms.remove(r);
		}
	}

	@Override
	public String toString() {
		return "chat [users=" + users + ", rooms=" + rooms + "]";
	}
}
