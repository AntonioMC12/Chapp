package es.iesfranciscodelosrios.chapp;

import java.io.IOException;
import es.iesfranciscodelosrios.chapp.model.chat;
import es.iesfranciscodelosrios.chapp.model.chatDAO;
import es.iesfranciscodelosrios.chapp.model.user;
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

	@FXML
	public void initialize() {
		chapp = chatDAO.loadChat(App.RUTAANTONIO);
	}

	@FXML
	protected void logUser(ActionEvent Event) throws IOException {
		String name = this.txtUser.getText();
		user data = new user(name, true, true);
		if (name != null && name.length() > 3 && !chapp.getUsers().contains(data)) {
			chapp.addUser(data);
			chatDAO.saveChat(App.RUTAANTONIO, chapp);
			App.setRoot("mainAndCreatefxml");
			App.currentUser = data;
			System.out.println(App.currentUser);
			this.txtUser.clear();
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error de acceso");
			alert.setContentText("Has introducido mal algun dato o el usuario está en uso.");
			alert.showAndWait();
			this.txtUser.clear();
		}
	}
}
