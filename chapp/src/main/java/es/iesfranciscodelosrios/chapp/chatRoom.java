package es.iesfranciscodelosrios.chapp;

import java.util.List;

import es.iesfranciscodelosrios.chapp.model.chat;
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
		room = roomDAO.loadRoom(App.RUTAANTONIO, App.roomIndex);
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

}
