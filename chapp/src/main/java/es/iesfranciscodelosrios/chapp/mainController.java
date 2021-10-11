package es.iesfranciscodelosrios.chapp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import es.iesfranciscodelosrios.chapp.model.message;
import es.iesfranciscodelosrios.chapp.model.room;
import es.iesfranciscodelosrios.chapp.model.user;
import es.iesfranciscodelosrios.chapp.utils.JAXBManager;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

	@FXML
	public void initialize() {
		//ObservableList<room>data = JAXBManager.readXML(user); 
		
		//chatPane.setItems(data);
	}
	
	@FXML
	protected void createRoom(ActionEvent Event) {
		List<message> listMessage = new ArrayList<message>();
		List<user>ListUsers = new ArrayList<user>();;
		
		String name = this.txtName.getText();
		if(name != null && name.length()>4 && 
				this.over18.isSelected()){
			room data= new room(name, listMessage, ListUsers,  this.over18.isSelected());
			//JAXBManager.readXML(/*UBI*/);
		}
	}
	@FXML
	protected void goChat(ActionEvent Event) {
		
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
