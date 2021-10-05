package es.iesfranciscodelosrios.chapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import es.iesfranciscodelosrios.chapp.model.chat;
import es.iesfranciscodelosrios.chapp.model.message;
import es.iesfranciscodelosrios.chapp.model.room;
import es.iesfranciscodelosrios.chapp.model.user;
import es.iesfranciscodelosrios.chapp.utils.JAXBManager;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    
    static List<message> mensajes = new ArrayList<message>();
	static List<user> usuarios = new ArrayList<user>();
	static List<room> salas = new ArrayList<room>();
	

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("logIn"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

	public void addMensajes(message m) {
		mensajes.add(m);
	}
	
	public void addUsuario(user u) {
		usuarios.add(u);
	}
	
	public void addSalas(room c) {
		salas.add(c);
	}

    public static void main(String[] args) {
        //launch();
    	
    	user Usuario1 = new user("Francisquito",true,true);
    	user Usuario2 = new user("Fran",true,true);
		message mensaje = new message(LocalDateTime.now(), Usuario1,"Mensaje de prueba");
		mensajes.add(mensaje);
		usuarios.add(Usuario1);
		usuarios.add(Usuario2);
		room sala = new room("Sala 1", mensajes, usuarios, true);
		salas.add(sala);
		
		chat Chat = new chat(usuarios, salas);
		
    	JAXBManager.saveFile("C:\\Users\\Antonio\\Desktop\\Cosas_Antonio\\chat.xml",Chat);
    	
    }

}