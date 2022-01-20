package cor;

import exception.BoulderException;
import obj.Objets;
import plateau.Grille;
import situation.Situation;

public abstract class DetecteurSituation {
	public DetecteurSituation suivant;

	public DetecteurSituation getSuivant() {
		return suivant;
	}

	public void setSuivant(DetecteurSituation suivant) {
		this.suivant = suivant;
	}

	public abstract boolean estDetectee(Objets obj , int l , int c , Grille grille) throws BoulderException;

	public abstract Situation extraire( Objets obj , int l , int c , Grille grille);

	/**
	 * Detecte dans quelle situation se trouve un objet grace a la COR
	 * @param obj objet que l'on souhaite deplacer
	 * @param l ligne
	 * @param c colonne
	 * @param grille la grille d'objets
	 * @return Situation
	 * @throws BoulderException
	 */
	public Situation detecter(Objets obj , int l , int c, Grille grille) throws BoulderException
	{

		if (estDetectee(obj ,l,c,grille))
			return extraire(obj , l, c, grille);
		else if (suivant!= null )
			return suivant.detecter(obj ,l,c,grille);
		else
			return null ;
	}


}
