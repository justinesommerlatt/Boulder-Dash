package ui;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import modele.Observable;


public class Timer extends Observable {
	
	private Timeline timeline;
	private	double	laps;

	/**
	 * Constructeur d'un timer à partir d'une durée exprimée en secondes. Tous les 
	 * laps de temps, l'évnement EventTimer est déclenché, et lui-même notifie à tous 
	 * ses observateurs
	 * @param laps nombre de secondes entre chaque 'top'
	 */
	public Timer(double laps) {
		this.laps = laps;
		
		KeyFrame frameJeu = new KeyFrame(Duration.seconds(laps), new EventTimer());
		timeline = new Timeline(frameJeu);
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}
	
	public double getLaps() {
		return laps;
	}
	
	class EventTimer implements EventHandler<ActionEvent> {
        public void handle(ActionEvent event) {
        	notifier();
        }	
	}
}


