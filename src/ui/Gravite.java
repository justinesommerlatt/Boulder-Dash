package ui;

import application.FenetrePrincipale;
import modele.Observable;
import modele.Observateur;
import obj.Rockford;
import plateau.Plateau;

public class Gravite implements Observateur{
	Plateau plateau;
	FenetrePrincipale fenetre;
	Rockford RF;
	
	public Gravite(Plateau plateau, FenetrePrincipale fenetre,Rockford rf) {
		super();
		this.RF = rf;
		this.plateau = plateau;
		this.fenetre = fenetre;
	}

	/**
	 * Tant que Rockford est en vie, on applique la gravite sur la grille
	 */
	@Override
	public void recevoirNotification(Observable observable) {
		if(RF.getPtsVie()>0)
			plateau.appliquerGravite();
			fenetre.dessinerGrille();
	}

}
