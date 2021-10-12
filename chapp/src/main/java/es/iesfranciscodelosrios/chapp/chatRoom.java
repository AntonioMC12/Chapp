package es.iesfranciscodelosrios.chapp;

import java.time.LocalDateTime;
import java.util.List;

import es.iesfranciscodelosrios.chapp.model.chat;
import es.iesfranciscodelosrios.chapp.model.chatDAO;
import es.iesfranciscodelosrios.chapp.model.message;
import es.iesfranciscodelosrios.chapp.model.room;
import es.iesfranciscodelosrios.chapp.model.roomDAO;
import es.iesfranciscodelosrios.chapp.model.user;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
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

	private chat chapp;
	private room room;
	private List<user> users;
	private List<room> rooms;

	@FXML
	protected void initialize() {
		chapp = chatDAO.loadChat(App.RUTAANTONIO);
		room = chapp.getRooms().get(App.roomIndex);
		loadMessages();
		loadUsers();
	}

	private void loadMessages() {
		ObservableList<message> items = FXCollections.observableArrayList(room.getListMessage());
		chatPane.setItems(items);
	}

	private void loadUsers() {
		ObservableList<user> items = FXCollections.observableArrayList(room.getListUser());
		userOnline.setItems(items);
	}
	
	@FXML
	private void sendMessage() {
		if(messageBox.getText() != null && !messageBox.getText().isEmpty()) {
			message dummy = new message(LocalDateTime.now(), App.currentUser, messageBox.getText());
			room.addMessage(dummy);
			loadMessages();
			chatDAO.saveChat(App.RUTAANTONIO, chapp);
			this.messageBox.clear();
		}
	}

}
