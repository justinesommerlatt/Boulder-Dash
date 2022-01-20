package test;

import java.io.IOException;

import cor.DetecteurDiamant_Autres;
import cor.DetecteurDiamant_Rockford;
import cor.DetecteurDiamant_Vide;
import cor.DetecteurRocher_Autres;
import cor.DetecteurRocher_Monstre;
import cor.DetecteurRocher_Rocher;
import cor.DetecteurRocher_Rockford;
import cor.DetecteurRocher_Vide;
import cor.DetecteurRockford_Acier;
import cor.DetecteurRockford_Diamant;
import cor.DetecteurRockford_Monstre;
import cor.DetecteurRockford_Rocher;
import cor.DetecteurRockford_Terre;
import cor.DetecteurRockford_Vide;
import exception.BoulderException;
import obj.Objets;
import obj.Rockford;
import plateau.Grille;
import plateau.Plateau;

public class Test {
	public static void main(String[] args) throws IOException, BoulderException
	{
		Plateau    plateau = new Plateau();
		Objets[][] tab = new Objets[0][0];
		Grille G = new Grille(0,0,tab);
		plateau.setGrille(G.importerGrille("./temp/testRockford.txt")); //grille des tests importee
		
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
		
		System.out.print("Voici la grille au depart : \n");
		plateau.afficherGrille();

		//D�placer Rockford � droite vers une case contenant du vide
		plateau.setRF(new Rockford(0,0));
		plateau.deplacer(plateau.getRF(),1,0);

		//D�placer Rockford vers la gauche vers une case contenant de l'acier
		plateau.setRF(new Rockford(1,1));
		plateau.deplacer(plateau.getRF(),0,1);

		//D�placer Rockford vers la droite vers un monstre
		plateau.setRF(new Rockford(0,5));
		plateau.deplacer(plateau.getRF(),6,0);

		//D�placer Rockford vers la droite vers de la terre
		plateau.setRF(new Rockford(1,3));
		plateau.deplacer(plateau.getRF(),4,1);

		//D�placer Rockford vers la droite vers un diamant
		plateau.setRF(new Rockford(1,6));
		plateau.deplacer(plateau.getRF(),7,1);

		//D�placer Rockford vers la droite vers un rocher (il pousse le rocher)
		plateau.setRF(new Rockford(3,0));
		plateau.deplacer(plateau.getRF(),1,3);

		//D�placer Rockford vers la gauche vers un rocher (rien ne bouge)
		plateau.setRF(new Rockford(4,3));
		plateau.deplacer(plateau.getRF(),2,4);
		System.out.print("\nVoici la grille apres tout ces deplacements : \n");
		plateau.afficherGrille();

		plateau.setRF(new Rockford(1,1));
		plateau.deplacer(plateau.getRF(),0,1);
		System.out.print("\n\n\n");
		plateau.afficherGrille();
		
		///////////////////////// TEST DE LA GRAVITE /////////////////////////


		plateau.setGrille(G.importerGrille("./temp/testGravite.txt"));
		plateau.setRF(new Rockford (9,4));
		plateau.setRF(new Rockford (9,3));
		plateau.setRF(new Rockford (9,7));
		plateau.setRF(new Rockford (9,8));
		plateau.getRF().setPtsVie(1);
		System.out.print("\nOn va appliquer la gravite sur la grille suivante : \n");
		plateau.afficherGrille();
		plateau.appliquerGravite();
		System.out.print("\nVoici la grille apres avoir applique la gravite : \n");
		plateau.afficherGrille();

		//Faire tomber le rocher jusqu'a ce qu'il s'arrete sur le plateau
		//Faire tomber le rocher jusqu'a ce qu'il rencontre Rockford qui doit perdre une vie
		//Faire tomber le rocher au dessus de RF. Rien ne doit changer
		//Faire tomber le rocher. Il doit rouler vers la droite
		//Faire tomber le diamant sur Rockford. Rien ne doit se passer
		//Faire tomber le diamant sur Rockford. Il gagne un diamant et celui ci disparait

	}
}
