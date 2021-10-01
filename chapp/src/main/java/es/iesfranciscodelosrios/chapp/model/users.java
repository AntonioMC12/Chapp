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
public class users implements Serializable {
	/**
	 * UID that we´ill use in this proyect.
	 */
	private static final long serialVersionUID = 1L;
	@XmlElement(name="person",type=person.class)
	
	private List<person> listOfUser = new ArrayList<>();
	
	
	public users() {
		super();
	}

	public users(List<person> listOfUser) {
		super();
		this.listOfUser = listOfUser;
	}

	public List<person> getListOfUser() {
		return listOfUser;
	}

	public void setListOfUser(List<person> listOfUser) {
		this.listOfUser = listOfUser;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
