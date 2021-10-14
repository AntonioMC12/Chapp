package es.iesfranciscodelosrios.chapp.utils;

import java.util.Timer;
import java.util.TimerTask;

import es.iesfranciscodelosrios.chapp.App;
import es.iesfranciscodelosrios.chapp.model.chatDAO;
import javafx.application.Platform;

public class refresh extends Thread {

	@Override
	public void run() {
		refresqueshion();
	}
	public static void refresqueshion() {
	Timer t = new Timer();
    t.schedule(new TimerTask() {
        public void run() {
            Platform.runLater(() -> {
            	System.out.println("LEO");
				chatDAO.saveChat(App.RUTAANTONIO, App.chapp);
            });
        }
    }, 0, 6000);
	}
}
