package cor;

import obj.Objets;
import obj.Rockford;
import obj.Vide;
import plateau.Grille;
import situation.Situation;
import situation.SituationRockford_Vide;

public class DetecteurRockford_Vide extends DetecteurSituation {
	private SituationRockford_Vide situation;

	//Cette m�thode teste si Rockford se trouver dans la situation SituationVide
	@Override
	public boolean estDetectee(Objets obj , int ligne , int col, Grille grille)
	{
		if (obj instanceof Rockford)
		{
			boolean conforme = DetecteurUtil.estValide(ligne,col,grille);
			//La case face � Rockford est bien VIDE
			if (conforme && grille.get(ligne, col) instanceof Vide)
			{
				System.out.print("Rockford se trouve en {"+ obj.getColonne()+","+obj.getLigne()+"} \n");
				System.out.print("Rockford se situe face a une case VIDE \n");
				// On m�morise la situation
				situation = new SituationRockford_Vide(ligne, col);
				return true ;
			}
			else
				return false ;
		}
		else
			return false ;

	}

	@Override
	public Situation extraire(Objets obj , int l , int c, Grille grille) {
		return situation;
	}

}
