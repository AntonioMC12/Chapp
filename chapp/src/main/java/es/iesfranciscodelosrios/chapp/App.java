package es.iesfranciscodelosrios.chapp;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

import es.iesfranciscodelosrios.chapp.utils.JAXBManager;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
	public static Stage rootstage;
	
    @Override
	public void start(Stage stage) throws IOException {
    	
		scene = new Scene(loadFXML("LogIn"), 337, 272);
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

    public static void main(String[] args) {
        //launch();
    	JAXBManager.saveFile("C:\\Users\\garci\\Desktop\\FOTOS\\ejemplo.xml");
    }

}