
package es.iesfranciscodelosrios.chapp.utils;

import java.io.File;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import javax.xml.bind.Unmarshaller;

import es.iesfranciscodelosrios.chapp.model.chat;
import es.iesfranciscodelosrios.chapp.model.message;
import es.iesfranciscodelosrios.chapp.model.room;
import es.iesfranciscodelosrios.chapp.model.user;

public class JAXBManager {

	static List<message> mensajes = new ArrayList<message>();
	static List<user> usuarios = new ArrayList<user>();
	static List<room> salas = new ArrayList<room>();

	public void addMensajes(message m) {
		mensajes.add(m);
	}

	public void addUsuario(user u) {
		usuarios.add(u);
	}

	public static void saveFile(String url, chat chapp) {
		/*
		 * solo para pruebas //user Usuario1 = new user("Francisquito", true, true);
		 * //message mensaje = new message(LocalDateTime.now(), Usuario1,
		 * "Mensaje de prueba");
		 * 
		 * mensajes.add(mensaje); usuarios.add(Usuario1);
		 * 
		 * room sala = new room("Sala_1", mensajes, usuarios, true);
		 * 
		 * salas.add(sala);
		 * 
		 * chat chapp = new chat(usuarios, salas);
		 */
		// marshaling
		JAXBContext jaxbContext;
		try {
			// jaxbContext = JAXBContext.newInstance(room.class);
			jaxbContext = JAXBContext.newInstance(chat.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			// Marshal the list in console
			// jaxbMarshaller.marshal(_instance, System.out);

			// Marshal the employees list in file
			jaxbMarshaller.marshal(chapp, new File(url));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static chat readXML(String url) throws NullPointerException{
		chat chapp = new chat();

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(chat.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			chapp = (chat) jaxbUnmarshaller.unmarshal(new File(url));
			// System.out.println("unmarshal:");
			// System.out.println(chapp);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (chapp != null) {
			return chapp;
		}else {
			return null;
		}
		
	}
}

