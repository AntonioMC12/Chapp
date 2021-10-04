package es.iesfranciscodelosrios.chapp.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * class in which we will save a user's data
 * 
 * @author Abepuoh
 *
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "user")
public class user implements Serializable {

	/**
	 * UID that we´ill use in this proyect.
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private Boolean gender;
	private Boolean age; // To checks rooms +18

	public user() {
		super();
	}

	public user(String name, Boolean gender, Boolean age) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public boolean getAge() {
		return age;
	}

	public void setAge(Boolean age) {
		this.age = age;
	}
	
	
}
