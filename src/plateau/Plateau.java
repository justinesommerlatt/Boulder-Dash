package plateau;

import cor.DetecteurSituation;
import exception.BoulderException;
import obj.Acier;
import obj.Brique;
import obj.Diamant;
import obj.Monstre;
import obj.Objets;
import obj.ObjetsGravite;
import obj.Rocher;
import obj.Rockford;
import obj.Terre;
import obj.Vide;
import situation.Situation;

public class Plateau {
	private Grille grille;
	private Rockford RF;
	private DetecteurSituation cor; //la chaine de responsabilite


    /**
	 * Deplacer RockFord sur la grille de jeu aux coordonnee c,l
	 * @param obj l'objet que l'on veut deplacer
	 * @param col colonne souhaitée
	 * @param ligne ligne souhaitée
	 */
	public void deplacer(Objets obj, int col , int ligne) throws BoulderException
	{
		assert cor != null : "Erreur : la chaine de responsabilite est vide ...";
		System.out.print("\nOn veut deplacer l'objet vers la position {"+col+","+ligne+"} \n");
		Situation situation = cor.detecter(obj , ligne, col, grille);
		if (situation == null)
			System.out.println("On se trouve dans une situation non-repertoriee \n");
		else
		{
			situation.traiter(obj,ligne,col,grille);
		}
	}


    /**
	 * METHODE POUR LA CONSOLE
	 * Affiche entierement la grille dans la console
	 */
    public void afficherGrille() {
    	for(int i=0 ; i <= grille.getLargeur()-1 ; i++)
        {
            for(int j=0 ; j <= grille.getLargeur()-1 ; j++)
            	afficherObjet(grille.get(i, j));
            System.out.print("\n");
        }
    }

    /**
	 * METHODE POUR LA CONSOLE
	 * Affiche une lettre correspondant à l'objet obj
	 * @param obj l'objet que l'on veut visualiser
	 */
    public void afficherObjet(Objets obj)
    {
    	if (obj instanceof Vide)
    		System.out.print("V ");
    	else if(obj instanceof Terre)
    		System.out.print("T ");
    	else if(obj instanceof Rocher)
    		System.out.print("R ");
    	else if(obj instanceof Monstre)
    		System.out.print("M ");
    	else if(obj instanceof Diamant)
    		System.out.print("D ");
    	else if(obj instanceof Acier)
    		System.out.print("A ");
    	else if(obj instanceof Brique)
    		System.out.print("B "); 
    	else if(obj instanceof Rockford)
    		System.out.print("J "); //J pour joueur
    }

    /**
	 * Ajoute un detecteur dans la COR 
	 * @param s Detecteur
	 */
	public void ajouterSituation(DetecteurSituation s)
	{
		assert s != null : "Le detecteur ne doit pas etre null ";
		// Insertion du nouveau detecteur en tete de liste
		s.setSuivant(cor);
		cor = s;
	}

	/**
	 * Applique la gravite sur tout les objets de la grille, sauf la derniere ligne
	 */
    public void appliquerGravite () 
    {
    	for(int li = grille.getHauteur()-2 ; li >= 0 ; li--) //lignes : on ne compte pas la derniere ligne car aucun interet
    	{
    		for(int col = grille.getLargeur()-1; col >= 0 ; col--) //colonnes-1 car on a inclu 0
    		{
    			if (grille.get(li, col) instanceof ObjetsGravite)
					try {
						deplacer(grille.get(li, col),col,li+1);
					} catch (BoulderException e) {e.printStackTrace();}
    		}
    	}
    }

	public Grille getGrille() {
		return grille;
	}

	public void setGrille(Grille grille) {
		this.grille = grille;
	}

	public Rockford getRF() {
		return RF;
	}

	public void setRF(Rockford rF) {
		grille.set(rF.getLigne(),rF.getColonne(),new Rockford(rF.getLigne(), rF.getColonne()));
		RF = rF;
	}

}
