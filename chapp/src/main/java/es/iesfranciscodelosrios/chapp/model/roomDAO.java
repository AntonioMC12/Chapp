package es.iesfranciscodelosrios.chapp.model;

import java.util.List;

import es.iesfranciscodelosrios.chapp.utils.JAXBManager;

public class roomDAO extends room {
	private static final long serialVersionUID = 1L;

	private static chat chapp;

	public roomDAO() {
		super();
	}

	public roomDAO(String name, List<message> listMessage, List<user> listUser, boolean under18) {
		super(name, listMessage, listUser, under18);
	}

	public roomDAO(room aux) {
		this.name = aux.name;
		this.listMessage = aux.listMessage;
		this.listUser = aux.listUser;
		this.under18 = aux.under18;
	}

	public static room loadRoom(String url, int roomNumber) {
		room dummy = new room();

		try {
			chapp = JAXBManager.readXML(url);
			dummy = chapp.getRooms().get(roomNumber);
		} catch (NullPointerException e) {
			// TODO: handle exception
		}

		return dummy;
	}
	
	public static void saveRoom(String url, chat aux) {
		JAXBManager.saveFile(url, aux);
	}
}