
package es.iesfranciscodelosrios.chapp.utils;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import es.iesfranciscodelosrios.chapp.model.message;
import es.iesfranciscodelosrios.chapp.model.room;
import es.iesfranciscodelosrios.chapp.model.user;

public class JAXBManager {
	
	static List<message> mensajes = new ArrayList<message>();
	static List<user> usuarios = new ArrayList<user>();
	
	public void addMensajes(message m) {
		mensajes.add(m);
	}
	
	public void addUsuario(user u) {
		usuarios.add(u);
	}
	
	public static void saveFile(String url) {
		//solo para pruebas
		user Usuario1 = new user("Francisquito",true,true);
		message mensaje = new message(LocalDateTime.now(), Usuario1,"Mensaje de prueba");
		mensajes.add(mensaje);
		usuarios.add(Usuario1);
		room sala = new room("Sala 1", mensajes, usuarios, true);
		System.out.println(sala);
		
		//marshaling
		JAXBContext jaxbContext;
		try {
			//jaxbContext = JAXBContext.newInstance(room.class);
			jaxbContext = JAXBContext.newInstance(room.class);
		    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			 
		    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		     
		    //Marshal the list in console
		    //jaxbMarshaller.marshal(_instance, System.out);
		     
		    //Marshal the employees list in file
		    jaxbMarshaller.marshal(sala, new File(url));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public static void readXML(String url) {
		
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(room.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			jaxbUnmarshaller.unmarshal(new File(url));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}