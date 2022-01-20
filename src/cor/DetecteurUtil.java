package cor;

import plateau.Grille;

public class DetecteurUtil {
	/**
	 * Evalue la conformite des coordonnees
	 * @param l la ligne
	 * @param c la colonne
	 * @param grille la grille d'objets
	 * @return true si les coordonnees sont corrects, false sinon
	 */
    public static boolean estValide(int l, int c, Grille grille){
        if ( (l<0) || (c<0) || (l>=grille.getHauteur()) || (c>=grille.getLargeur()))
        {
        	return false;
        }
        else
            return true;
    }

}