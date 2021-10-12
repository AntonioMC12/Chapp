package es.iesfranciscodelosrios.chapp.model;

import java.util.ArrayList;
import java.util.List;

public class userDAO extends user{

	private static final long serialVersionUID = 1L;

	public userDAO() {
		super();
	}

	public userDAO(String name, Boolean gender, Boolean age) {
		super(name, gender, age);
	}
	public userDAO(user aux) {
		this.name = aux.name;
		this.gender = aux.gender;
		this.age = aux.age;
	}
	
	public int saveUser() {
		int result = 0;
		return result;
	}
	public int daleteUser(String name) {
		int result = 0;
		return result;
	}
	public int addUser(user auxUser) {
		int result = 0;
		return result;		
	}
	
	public int SavePlayer(user aux) {
		int save = 0;
		List<user> usuarios = new ArrayList<user>();
		if (aux != null) {
			usuarios.add(aux);
		}
		return save;
	}
}
