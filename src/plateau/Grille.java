package plateau;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import obj.Acier;
import obj.Brique;
import obj.Diamant;
import obj.Monstre;
import obj.Objets;
import obj.Rocher;
import obj.Rockford;
import obj.Terre;
import obj.Vide;

public class Grille {
    private int largeur;
    private int hauteur;
    private Objets G[][];

    /** Lire un fichier texte et creer une grille a partir de ce fichier
     * 	Le format du fichier sera le suivant :
     * 		- premiere ligne : deux entiers qui donnent la dimension de la grille (hauteur largeur)
     * 		- la suite : la grille ligne par ligne 
     * @param s chemin du fichier contenant les informations de la grille
     * @return Grille la grille d'objets G creer a partir du fichier
    */
    public Grille importerGrille (String s) throws IOException
    {
        BufferedReader fich = new BufferedReader(new FileReader(s));
        String line = fich.readLine();
        String[] dim = line.split(" ",2);
        hauteur = Integer.parseInt(dim[0]);
        largeur = Integer.parseInt(dim[1]);
        
        Objets grille[][]= new Objets[largeur][hauteur];
        line = fich.readLine();
        do
        {
            for(int i=0 ; i<=hauteur-1 ; i++)
            {
                for(int j=0 ; j<=largeur-1 ; j++)
                {
                	grille[j][i] = nature(line.charAt(j),i,j);
                }
                line = fich.readLine();
            }

        }
        while(line!=null);
        fich.close();
        Grille g = new Grille(largeur, hauteur, grille);
        return g;
    }

    /** 
     * Creer un objet en fonction du caractere lu 
     * @param c caractere lu
     * @param ligne 
     * @param colonne 
     * @return Objets objet de coordonnees (ligne,colonne) correspondant au caractere lu
     */
    private Objets nature(char c,int ligne, int colonne)
    {	Objets obj = null;
    	switch(c)
    	{
    	case 'V':
    		obj = new Vide(ligne,colonne);
    		break;
		case 'J':
			obj = new Rockford(ligne,colonne);
			break;
    	case 'R':
    		obj = new Rocher(ligne,colonne);
    		break;
    	case 'T':
    		obj = new Terre(ligne,colonne);
    		break;
    	case 'B':
    		obj = new Brique(ligne,colonne);
    		break;
    	case 'M':
    		obj = new Monstre(ligne,colonne);
    		break;
    	case 'A':
    		obj = new Acier(ligne,colonne);
    		break;
    	case 'D':
    		obj = new Diamant(ligne,colonne);
    		break;
    	}
		return obj;
    }

    public Grille(int largeur, int hauteur, Objets[][] g) {
        super();
        this.largeur = largeur;
        this.hauteur = hauteur;
        G = g;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public Objets[][] getG() {
        return G;
    }

    public void setG(Objets[][] g) {
        G = g;
    }

    public Objets get(int col, int ligne) {
    	return G[ligne][col];
    }
    
    public void set(int x, int y, Objets obj) {
    	G[x][y]=obj;
    }
    




}
