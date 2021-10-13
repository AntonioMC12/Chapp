package es.iesfranciscodelosrios.chapp.model;

import es.iesfranciscodelosrios.chapp.utils.JAXBManager;

public class chatDAO {

	public static chat loadChat(String url) {
		return JAXBManager.readXML(url);
	}

	public static void saveChat(String url, chat aux) {
		JAXBManager.saveFile(url, aux);
	}
}