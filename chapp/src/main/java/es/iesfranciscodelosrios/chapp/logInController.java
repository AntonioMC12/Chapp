package es.iesfranciscodelosrios.chapp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import es.iesfranciscodelosrios.chapp.model.chat;
import es.iesfranciscodelosrios.chapp.model.chatDAO;
import es.iesfranciscodelosrios.chapp.model.room;
import es.iesfranciscodelosrios.chapp.model.user;
import es.iesfranciscodelosrios.chapp.model.userDAO;
import es.iesfranciscodelosrios.chapp.utils.JAXBManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class logInController {

	@FXML
	private TextField txtUser;
	@FXML
	private Button LogButt;
	
	private chat chapp;
	private room room;
	private List<user> users;
	
	@FXML
	public void initialize() {
		chapp = chatDAO.loadChat(App.RUTAMIGUEL);
		//room = chapp.getRooms().get(App.roomIndex);
		users = chapp.getUsers();
	}

	@FXML
	protected void logUser(ActionEvent Event) throws IOException {
		String name = this.txtUser.getText();
		this.txtUser.clear();
		user data = new user(name);
		if (name != null && name.length() > 3 &&
				chapp.getUsers().contains(data)){
			//CHECK
			users.add(data);
			chatDAO.saveChat(App.RUTAMIGUEL, chapp);
			App.setRoot("mainAndCreatefxml");
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error de acceso");
			alert.setContentText("Has introducido mal algun dato");
			alert.showAndWait();
		}
	}
}
