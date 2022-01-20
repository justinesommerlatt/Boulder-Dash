package ui;


import javafx.scene.layout.HBox;
import obj.Rockford;
import exception.BoulderException;


public class PanneauFooter extends HBox {

	
	/**
	 * Timer qui se déclenche tous les 0.1 s
	 */
	private	Timer	timer = new Timer(0.1);
	Rockford rf ;
	

	public PanneauFooter(Rockford RF) {
		super();
		this.rf = RF;

// YL : j'ajoute uniquement l'afficheur du temps écoulé. Vous pouvez enrichir cette partie de l'interface
// avec le score, le nombre de vies, etc.
		
		// afficheur est un observateur du timer
		AfficheurTempsEcoule afficheur = new AfficheurTempsEcoule(this,rf);
		try {
			timer.add(afficheur);
		} catch (BoulderException e) {
			e.printStackTrace();
		}
	}


}

