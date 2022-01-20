package cor;

import obj.Objets;
import obj.Rocher;
import obj.Rockford;
import plateau.Grille;
import situation.Situation;
import situation.SituationRockford_Rocher;

public class DetecteurRockford_Rocher extends DetecteurSituation {
	private SituationRockford_Rocher situation;

	//Cette m�thode teste si Rockford se trouver dans la situation SituationRocher
	@Override
	public boolean estDetectee(Objets obj , int ligne , int col, Grille grille)
	{
		if (obj instanceof Rockford)
		{
			boolean conforme = DetecteurUtil.estValide(ligne,col,grille);
			//La case face � Rockford est bien un ROCHER
			if (conforme && grille.get(ligne,col) instanceof Rocher)
			{
				System.out.print("Rockford se trouve en {"+ obj.getLigne()+","+obj.getColonne()+"} \n");
				System.out.print("Rockford se situe face a un ROCHER\n");
				// On m�morise la situation
				situation = new SituationRockford_Rocher(ligne, col);
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
