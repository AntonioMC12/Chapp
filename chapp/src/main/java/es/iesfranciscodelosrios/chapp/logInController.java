package es.iesfranciscodelosrios.chapp;

import java.io.IOException;

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

	@FXML
	public void initialize() {

	}

	@FXML
	protected void logUser(ActionEvent Event) throws IOException {
		String name = this.txtUser.getText();
		this.txtUser.clear();
		
		if (name != null && name.length() >3){
		user data = new user(name);
		userDAO list = new userDAO();
		list.addUser(data);
		
		//METERLO EN LA SALA.
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
