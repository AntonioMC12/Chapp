package es.iesfranciscodelosrios.chapp;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;
import es.iesfranciscodelosrios.chapp.model.chat;
import es.iesfranciscodelosrios.chapp.model.chatDAO;
import es.iesfranciscodelosrios.chapp.model.message;
import es.iesfranciscodelosrios.chapp.model.room;
import es.iesfranciscodelosrios.chapp.model.user;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class chatRoom extends Thread {

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

	private static chat chapp;
	private static room room;

	@FXML
	protected void initialize() {
		chapp = chatDAO.loadChat(App.RUTAANTONIO);
		chapp.getRooms().get(App.roomIndex).addUser(App.currentUser);
		chatDAO.saveChat(App.RUTAANTONIO, chapp);
		loadMessages();
		loadUsers();
		if (chapp != null) {
			refresqueshion();
		}
	}

	@FXML
	private void loadMessages() {
		ObservableList<message> items = FXCollections
				.observableArrayList(chapp.getRooms().get(App.roomIndex).getListMessage());
		chatPane.setItems(items);
	}

	@FXML
	private void loadUsers() {
		ObservableList<user> items = FXCollections
				.observableArrayList(chapp.getRooms().get(App.roomIndex).getListUser());
		userOnline.setItems(items);
	}

	@FXML
	private void sendMessage() {
		if (messageBox.getText() != null && !messageBox.getText().isEmpty()) {
			message dummy = new message(LocalDateTime.now(), App.currentUser, messageBox.getText());
			room.addMessage(dummy);
			chatDAO.saveChat(App.RUTAANTONIO, chapp);
			loadMessages();
			this.messageBox.clear();
		}
	}

	@FXML
	private void exit(ActionEvent event) {

		try {
			App.setRoot("mainAndCreatefxml");
			chapp.getRooms().get(App.roomIndex).removeUser(App.currentUser);
			chatDAO.saveChat(App.RUTAANTONIO, chapp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		refresqueshion();
	}

	public void refresqueshion() {
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			public void run() {
				Platform.runLater(() -> {
					System.out.println("LEO");
					chapp = chatDAO.loadChat(App.RUTAANTONIO);
					loadMessages();
					loadUsers();
					chatDAO.saveChat(App.RUTAANTONIO, chapp);
					room = chapp.getRooms().get(App.roomIndex);
				});
			}
		}, 0, 6000);
	}
}
