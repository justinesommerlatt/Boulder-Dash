package ui;

import java.net.MalformedURLException;

import exception.BoulderException;
import javafx.scene.layout.HBox;
import obj.Rockford;

public class PanneauHeader extends HBox{
	private	Timer	timer = new Timer(0.1);
	Rockford rf ;
	
	/**
	 * Creer un panneau en haut de l'interface de jeu contenant les points de vie, ainsi que le nb de diamants
	 * @param RF le Rockford associe a la partie
	 * @throws MalformedURLException
	 */
	public PanneauHeader(Rockford RF) throws MalformedURLException{
		super();
		this.rf = RF;
		
		AfficheurScore afficheur = new AfficheurScore(this,rf);
		try {
			timer.add(afficheur);
		} catch (BoulderException e) {
			e.printStackTrace();
		}
	}
}
