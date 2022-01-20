package ui;

import java.net.MalformedURLException;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import modele.Observable;
import modele.Observateur;
import obj.Rockford;

public class AfficheurScore implements Observateur{
	private Label nbVies = new Label ("");
	private Label nbDiam = new Label ("");
	ImageView ptsVies = new ImageView();
	HBox box = new HBox();
	Rockford RF;
	
	/**
	 * Affiche en haut de l'interface le nombre de points de vie de rockford, ainsi que son nombre de diamants
	 * @param panneau la fenetre
	 * @param rf le Rockford associe a la partie
	 * @throws MalformedURLException
	 */
	public AfficheurScore(Pane panneau,Rockford rf) throws MalformedURLException
	{
		this.RF = rf;
		panneau.setBackground((new Background(new BackgroundFill(Color.rgb(73,50,33),CornerRadii.EMPTY, Insets.EMPTY))));
		
		ptsVies.setImage(new Image(getClass().getResourceAsStream("/images/Vie1.png")));
		nbVies.setFont(new Font("Arial", 25));
		nbVies.setTextFill(Color.GHOSTWHITE);
		nbVies.setPadding(new Insets(15,10,10,10));
		
		nbDiam.setFont(new Font("Arial", 25));
		nbDiam.setTextFill(Color.GHOSTWHITE);
		nbDiam.setPadding(new Insets(15,10,10,10));
		ImageView diam = new ImageView();
		diam.setImage(new Image(getClass().getResourceAsStream("/images/Diamant.png")));
		
		HBox vie = new HBox();
		vie.getChildren().addAll(ptsVies,nbVies);
		HBox diamants = new HBox();
		diamants.getChildren().addAll(diam,nbDiam);	
		box.getChildren().addAll(vie,diamants);
		box.setSpacing(70);
		box.setPadding(new Insets(0,0,0,130));
		panneau.getChildren().add(box);
		
	}
	
	/**
	 * Permet de mettre à jour les informations pendant que l'on joue
	 */
	@Override
	public void recevoirNotification(Observable observable) {
		nbVies.setText(": " + RF.getPtsVie());
		nbDiam.setText(": " + RF.getNbDiamants());
		if(RF.getPtsVie()==1)
			nbVies.setTextFill(Color.RED);
		else if(RF.getPtsVie()==0)
			ptsVies.setImage(new Image(getClass().getResourceAsStream("/images/Mort.png")));

	}
}
