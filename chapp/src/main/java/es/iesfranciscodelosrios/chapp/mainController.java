package es.iesfranciscodelosrios.chapp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import es.iesfranciscodelosrios.chapp.model.chat;
import es.iesfranciscodelosrios.chapp.model.chatDAO;
import es.iesfranciscodelosrios.chapp.model.message;
import es.iesfranciscodelosrios.chapp.model.room;
import es.iesfranciscodelosrios.chapp.model.user;
import es.iesfranciscodelosrios.chapp.utils.JAXBManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
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
	private Button exitButt;
	@FXML
	private Button createRoomButt;

	private chat chapp;

	@FXML
	public void initialize() {
		chapp = chatDAO.loadChat(App.RUTAANTONIO);
		loadChats();

	}

	@FXML
	protected void createRoom(ActionEvent Event) {
		List<message> listMessage = new ArrayList<message>();
		List<user>ListUsers = new ArrayList<user>();
		String name = this.txtName.getText();
		if(name != null && name.length()>4){
			room data= new room(name, listMessage, ListUsers, true);
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setHeaderText(null);
			alert.setTitle("Enhorabuena");
			alert.setContentText("La sala ha sido creada correctamente");
			alert.showAndWait();
			chatDAO.saveChat(App.RUTAANTONIO, chapp);
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error al crear la sala");
			alert.setContentText("No dejes ningun campoa vacío");
			alert.showAndWait();
		}
	}

	  @FXML
	  public void goChat(MouseEvent e) throws IOException {
	    room click = chatPane.getSelectionModel().getSelectedItem();
	    if (chapp.getRooms().contains(click)) {
	      App.selected = click;
	      App.setRoot("chatRoom");
	    } else {
	      Alert alert = new Alert(Alert.AlertType.ERROR);
	      alert.setHeaderText(null);
	      alert.setTitle("Error al cargar la sala");
	      alert.showAndWait();
	    }
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
			chapp.deleteUser(App.currentUser);
			chatDAO.saveChat(App.RUTAANTONIO, chapp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
