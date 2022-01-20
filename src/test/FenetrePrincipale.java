package test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;

import cor.DetecteurDiamant_Autres;
import cor.DetecteurDiamant_Rockford;
import cor.DetecteurDiamant_Vide;
import cor.DetecteurRocher_Autres;
import cor.DetecteurRocher_Monstre;
import cor.DetecteurRocher_Rocher;
import cor.DetecteurRocher_Rockford;
import cor.DetecteurRocher_Vide;
import cor.DetecteurRockford_Acier;
import cor.DetecteurRockford_Brique;
import cor.DetecteurRockford_Diamant;
import cor.DetecteurRockford_Monstre;
import cor.DetecteurRockford_Rocher;
import cor.DetecteurRockford_Terre;
import cor.DetecteurRockford_Vide;
import cor.DetecteurUtil;
import exception.BoulderException;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import obj.Acier;
import obj.Brique;
import obj.Diamant;
import obj.Monstre;
import obj.Objets;
import obj.Rocher;
import obj.Rockford;
import obj.Terre;
import obj.Vide;
import plateau.Grille;
import plateau.Plateau;
import ui.Gravite;
import ui.PanneauFooter;
import ui.PanneauHeader;
import ui.Timer;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

public class FenetrePrincipale extends Application {
	private Canvas grillePane;
	private BorderPane root;
	private Scene scene;
	private PanneauFooter panneauFooter;

	Timer timer = new Timer(1);
	Plateau plateau = new Plateau(); //Création d'un plateau
	Objets[][] tab = new Objets[0][0];
	Grille grille = new Grille(0,0,tab); //Création d'une grille vide qui sera ensuite modifiée
	private HashMap< Class<?>, Image > tabImage;

	public Canvas getGrillePane() {
		return grillePane;
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			
			plateau.ajouterSituation(new DetecteurRockford_Vide());
			plateau.ajouterSituation(new DetecteurRockford_Terre());
			plateau.ajouterSituation(new DetecteurRockford_Rocher());
			plateau.ajouterSituation(new DetecteurRockford_Monstre());
			plateau.ajouterSituation(new DetecteurRockford_Diamant());
			plateau.ajouterSituation(new DetecteurRockford_Acier());
			plateau.ajouterSituation(new DetecteurRocher_Vide());
			plateau.ajouterSituation(new DetecteurRocher_Rockford());
			plateau.ajouterSituation(new DetecteurRocher_Rocher());
			plateau.ajouterSituation(new DetecteurRocher_Monstre());
			plateau.ajouterSituation(new DetecteurRocher_Autres());
			plateau.ajouterSituation(new DetecteurDiamant_Rockford());
			plateau.ajouterSituation(new DetecteurDiamant_Vide());
			plateau.ajouterSituation(new DetecteurDiamant_Autres());
			plateau.ajouterSituation(new DetecteurRockford_Brique());
			
			primaryStage.setTitle("Boulder Dash");

			root = new BorderPane(grillePane);

			
			
			scene = new Scene(root);
			scene.setOnKeyPressed(new HandlerClavier());

			initGrille();
			initImages();
			initFooter();
			initGrav();
			initHeader();
			dessinerGrille();
			
			
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	private void initImages() {
		tabImage = new HashMap< Class<?>, Image >();
		Image image;
		if (plateau.getRF().getPtsVie()==0)
		{
			image = new Image(getClass().getResourceAsStream("/images/Mort.png"));
			tabImage.put(Rockford.class, image);
		}
		else
		{
			image = new Image(getClass().getResourceAsStream("/images/Rockford.png"));
			tabImage.put(Rockford.class, image);
		}
		image = new Image(getClass().getResourceAsStream("/images/Vide.png"));
		tabImage.put(Vide.class, image);
		image = new Image(getClass().getResourceAsStream("/images/Terre.png"));
		tabImage.put(Terre.class, image);
		image = new Image(getClass().getResourceAsStream("/images/Rocher.png"));
		tabImage.put(Rocher.class, image);
		image = new Image(getClass().getResourceAsStream("/images/Monstre.png"));
		tabImage.put(Monstre.class, image);
		image = new Image(getClass().getResourceAsStream("/images/Diamant.png"));
		tabImage.put(Diamant.class, image);
		image = new Image(getClass().getResourceAsStream("/images/Brique.png"));
		tabImage.put(Brique.class, image);
		image = new Image(getClass().getResourceAsStream("/images/Acier.png"));
		tabImage.put(Acier.class, image);
	}

	public void dessinerGrille() {
		for (int l = 0; l < plateau.getGrille().getHauteur(); l++) {
			for (int c = 0; c < plateau.getGrille().getLargeur(); c++) {
				Objets objet = grille.get(l,c);
				Image image = tabImage.get(objet.getClass());
				getGrillePane().getGraphicsContext2D().drawImage(image, c * 64, l * 64);
			}
		}
	}

	private void initGrille() throws IOException {
		plateau.setGrille(grille.importerGrille("./temp/Test.txt"));
		grille = plateau.getGrille();
		
		int lGrille = 64 * grille.getLargeur();
		int hGrille = 64 * grille.getHauteur();
		grillePane = new Canvas(lGrille, hGrille);
		((BorderPane) root).setCenter(grillePane);

		grillePane.getGraphicsContext2D();

		
		plateau.setRF(new Rockford(1,1));
		plateau.afficherGrille();
	}

	public static void main(String[] args) {
		launch(args);
	}

	private final class HandlerClavier implements EventHandler<KeyEvent> {
		public void handle(KeyEvent ke) {
			Rockford rf = plateau.getRF();
			if(rf.getPtsVie()>0)
			{
				int xRockford = rf.getLigne();
				int yRockford = rf.getColonne();
					
				grille.set(yRockford,xRockford,new Vide(yRockford,xRockford));
				switch (ke.getCode()) {
				case LEFT: {
					if (yRockford == 0)
						return;
					yRockford--;
					break;
				}
				case RIGHT: {
					if (yRockford == plateau.getGrille().getLargeur() - 1)
						return;
					yRockford++;
					break;
				}
				case DOWN: {
					if (xRockford == plateau.getGrille().getHauteur() - 1)
						return;
					xRockford++;
					break;
				}
				case UP: {
					if (xRockford == 0)
						return;
					xRockford--;
					break;
				}
				default:
					return;
	
				}
				boolean conforme = DetecteurUtil.estValide(xRockford, yRockford, grille);
				if(conforme)
				{
					try {
						plateau.deplacer(rf, yRockford, xRockford); //On deplace Rockford.
					} catch (BoulderException e) {
						System.out.print("Deplacement impossible\n\n");
						e.printStackTrace();
					}
				}
			}				
			dessinerGrille();
			
		}
	}

	private void initGrav() {
		Gravite grav = new Gravite(plateau,this,plateau.getRF());
		try {
			timer.add(grav);
		} catch (BoulderException e) {e.printStackTrace();}
	}
	
	private void initHeader() throws MalformedURLException {
		PanneauHeader panneauHeader = new PanneauHeader(plateau.getRF());
		((BorderPane) root).setTop(panneauHeader);
		
	}

	private void initFooter() {
		panneauFooter = new PanneauFooter(plateau.getRF());
		((BorderPane) root).setBottom(panneauFooter);
		
	}
}

