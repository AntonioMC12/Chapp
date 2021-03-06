package es.iesfranciscodelosrios.chapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import es.iesfranciscodelosrios.chapp.model.chat;
import es.iesfranciscodelosrios.chapp.model.chatDAO;
import es.iesfranciscodelosrios.chapp.model.room;
import es.iesfranciscodelosrios.chapp.model.user;

/**
 * JavaFX App
 */
public class App extends Application {

	public static final String RUTAANTONIO = "C:\\Users\\Antonio\\Desktop\\Cosas_Antonio\\chat.xml";
	public static final String RUTAMIGUEL = "C:\\Users\\garci\\Desktop\\FOTOS\\chat.xml";
	public static int roomIndex = 0;
	public static user currentUser;
	public static chat chapp;
	public static room selected;

	private static Scene scene;
	public static Stage rootstage;

	@Override
	public void start(Stage stage) throws IOException {

		scene = new Scene(loadFXML("logIn"), 1040, 620);
		loadChat();
		stage.setScene(scene);
		stage.show();
	}

	public static void setRoot(String fxml) throws IOException {
		scene.setRoot(loadFXML(fxml));
	}

	private static Parent loadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
		return fxmlLoader.load();
	}

	public void loadChat() {
		chapp = chatDAO.loadChat(RUTAANTONIO);
	}

	public static void main(String[] args) {
		launch();
	}

}
