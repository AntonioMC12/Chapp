package es.iesfranciscodelosrios.chapp;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

import es.iesfranciscodelosrios.chapp.model.user;
import es.iesfranciscodelosrios.chapp.utils.JAXBManager;


/**
 * JavaFX App
 */
public class App extends Application {
	  
	  public static final String RUTAANTONIO = "C:\\Users\\Antonio\\Desktop\\Cosas_Antonio\\chat.xml";
	  public static final String RUTAMIGUEL = "C:\\Users\\garci\\Desktop\\FOTOS";
	  public static int roomIndex = 0;
	  public static user currentUser;

	  private static Scene scene;
	  public static Stage rootstage;
	  
	    @Override
	  public void start(Stage stage) throws IOException {
	      
	    scene = new Scene(loadFXML("chatRoom"), 1040, 620);
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
	      launch();

	      //JAXBManager.saveFile(RUTAANTONIO);
	      //JAXBManager.saveFile(RUTAMIGUEL);
	    }

	}

