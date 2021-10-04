package es.iesfranciscodelosrios.chapp.utils;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class connect {

	private static Connection con;
	
	private final static String server = connect.load().getServer();
	private final static String database = connect.load().getDatabase();
	private final static String username = connect.load().getUsername();
	private final static String password = connect.load().getPassword();
	private final static String file = "connection.xml";

	public static void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(server + "/" + database, username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			con = null;
			e.printStackTrace();
		}
	}

	public static Connection getConnect() {
		if (con == null) {
			connect();
		}
		return con;
	}

	
	public static void save(connection c) {
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(connection.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(c, new File(file));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static connection load() {
		connection con = new connection();
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(connection.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			connection newR = (connection) jaxbUnmarshaller.unmarshal(new File(file));
			con = newR;
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

}