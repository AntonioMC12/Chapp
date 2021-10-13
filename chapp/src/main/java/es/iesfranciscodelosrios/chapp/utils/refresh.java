package es.iesfranciscodelosrios.chapp.utils;

import java.util.Timer;
import java.util.TimerTask;

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
               // JAXBManager.readXML(/*RUTITA*/);
            });
        }
    }, 0, 6000);
	}
}
