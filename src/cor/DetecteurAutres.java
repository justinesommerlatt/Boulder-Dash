package cor;

import obj.Acier;
import obj.Monstre;
import obj.Objets;
import obj.Terre;
import obj.Vide;
import plateau.Grille;
import situation.Situation;
import situation.SituationAutres;

public class DetecteurAutres extends DetecteurSituation {
	private SituationAutres situation;

	//Cette méthode gere les cases où la gravité n'a aucun effet
	@Override
	public boolean estDetectee(Objets obj , int l , int c, Grille grille)
	{
		if (obj instanceof Vide || obj instanceof Acier || obj instanceof Terre || obj instanceof Monstre)
		{

				System.out.print("La gravite n'a aucun effet sur cet objet\n");
				// On mémorise la situation
				situation = new SituationAutres(l, c);
				return true ;
		}
		else
			return false ;
	}

	@Override
	public Situation extraire(Objets obj , int l , int c, Grille grille) {
		return situation;
	}
}
