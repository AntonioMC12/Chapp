package es.iesfranciscodelosrios.chapp;

import java.io.IOException;

import es.iesfranciscodelosrios.chapp.model.room;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class mainController {
	@FXML
	private BorderPane borderPane;
	@FXML
	private HBox onlineUsersHBox;
	@FXML
	private TextField txtName;
	@FXML
	private ListView<room> chatPane;
	

	@FXML
	public void initialize() {

	}
	
	@FXML
	protected void createRoom(ActionEvent Event) {
		
	}
	@FXML
	protected void fillListView(ActionEvent Event) {
		
	}
	@FXML
	private void exit(ActionEvent event) {
		try {
			App.setRoot("logIn");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
