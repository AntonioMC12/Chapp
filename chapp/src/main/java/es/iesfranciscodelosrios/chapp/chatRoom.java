package es.iesfranciscodelosrios.chapp;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import es.iesfranciscodelosrios.chapp.model.chat;
import es.iesfranciscodelosrios.chapp.model.chatDAO;
import es.iesfranciscodelosrios.chapp.model.message;
import es.iesfranciscodelosrios.chapp.model.room;
import es.iesfranciscodelosrios.chapp.model.roomDAO;
import es.iesfranciscodelosrios.chapp.model.user;
import es.iesfranciscodelosrios.chapp.utils.refresh;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;

public class chatRoom {

	@FXML
	private ListView<user> userOnline;
	@FXML
	private ListView<message> chatPane;
	@FXML
	private TextArea messageBox;
	@FXML
	private Button buttonSend;
	@FXML
	private Button exit;
	
	private chat chapp;
	private room room;


	@FXML
	protected void initialize() {
		chapp = chatDAO.loadChat(App.RUTAMIGUEL);
		room = chapp.getRooms().get(App.roomIndex);
		loadMessages();
		loadUsers();
	}
	@FXML
	private void loadMessages() {
		ObservableList<message> items = FXCollections.observableArrayList(chapp.getRooms().get(App.roomIndex).
				getListMessage());
		chatPane.setItems(items);
	}
	@FXML
	private void loadUsers() {
		ObservableList<user> items = FXCollections.observableArrayList(room.getListUser());
		userOnline.setItems(items);
	}
	
	@FXML
	private void sendMessage() {
		if(messageBox.getText() != null && !messageBox.getText().isEmpty()) {
			message dummy = new message(LocalDateTime.now(), App.currentUser, messageBox.getText());
			room.addMessage(dummy);
			refresh.refresqueshion();
			chatDAO.saveChat(App.RUTAMIGUEL, chapp);
			this.messageBox.clear();
		}
	}
	@FXML
	private void exit(ActionEvent event) {
		
		try {
			App.setRoot("mainAndCreatefxml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
