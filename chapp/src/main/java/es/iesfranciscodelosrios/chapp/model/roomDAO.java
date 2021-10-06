package es.iesfranciscodelosrios.chapp.model;

import java.util.List;

public class roomDAO extends room{
	private static final long serialVersionUID = 1L;

	public roomDAO() {
		super();
	}

	public roomDAO(String name, List<message> listMessage, List<user> listUser, boolean under18) {
		super(name, listMessage, listUser, under18);
	}
	
	public roomDAO(room aux) {
		this.name=aux.name;
		this.listMessage=aux.listMessage;
		this.listUser=aux.listUser;
		this.under18=aux.under18;	
	}
	}