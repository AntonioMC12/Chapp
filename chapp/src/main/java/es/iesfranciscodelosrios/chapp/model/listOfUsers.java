package es.iesfranciscodelosrios.chapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "listOfUsers")
public class listOfUsers implements Serializable {
	/**
	 * UID that we´ill use in this proyect.
	 */
	private static final long serialVersionUID = 1L;
	@XmlElement(name="user",type=user.class)
	
	private List<user> listOfUser = new ArrayList<>();
	
	
	public listOfUsers() {
		super();
	}

	public listOfUsers(List<user> listOfUser) {
		super();
		this.listOfUser = listOfUser;
	}

	public List<user> getListOfUser() {
		return listOfUser;
	}

	public void setListOfUser(List<user> listOfUser) {
		this.listOfUser = listOfUser;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
