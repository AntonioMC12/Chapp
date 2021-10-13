package es.iesfranciscodelosrios.chapp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import es.iesfranciscodelosrios.chapp.model.chat;
import es.iesfranciscodelosrios.chapp.model.chatDAO;
import es.iesfranciscodelosrios.chapp.model.message;
import es.iesfranciscodelosrios.chapp.model.room;
import es.iesfranciscodelosrios.chapp.model.roomDAO;
import es.iesfranciscodelosrios.chapp.model.user;
import es.iesfranciscodelosrios.chapp.utils.JAXBManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
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
	private CheckBox over18;
	
	private chat chapp;
	private room room;
	
	@FXML
	public void initialize() {
		chapp = chatDAO.loadChat(App.RUTAMIGUEL);
		loadChats();
	}
	
	@FXML
	protected void createRoom(ActionEvent Event) {
		List<message> listMessage = new ArrayList<message>();
		List<user>ListUsers = new ArrayList<user>();;
		
		String name = this.txtName.getText();
		if(name != null && name.length()>4){
			room data= new room(name, listMessage, ListUsers, true);
			roomDAO.
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setHeaderText(null);
			alert.setTitle("Enhorabuena");
			alert.setContentText("La sala ha sido creada correctamente");
			alert.showAndWait();
		}else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error al crear la sala");
			alert.setContentText("No dejes ningun campoa vacío");
			alert.showAndWait();
		}
	}
	@FXML
	protected void goChat(ActionEvent Event) {
	room name = chatPane.getSelectionModel().getSelectedItem();	
	}
	@FXML
	private void loadChats() {
		ObservableList<room> items = FXCollections.observableArrayList(chapp.getRooms());
		chatPane.setItems(items);
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
