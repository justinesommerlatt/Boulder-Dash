package cor;

import obj.Diamant;
import obj.Objets;
import obj.Rockford;
import plateau.Grille;
import situation.Situation;
import situation.SituationRockford_Diamant;

public class DetecteurRockford_Diamant extends DetecteurSituation{
	private SituationRockford_Diamant situation;

	//Cette m�thode teste si Rockford se trouver dans la situation SituationDiamant
	@Override
	public boolean estDetectee(Objets obj , int ligne , int col, Grille grille)
	{
		if (obj instanceof Rockford)
		{
			boolean conforme = DetecteurUtil.estValide(ligne,col,grille);
			//La case face � Rockford est bien un DIAMANT
			if (conforme && grille.get(ligne,col) instanceof Diamant)
			{
				System.out.print("Rockford se trouve en {"+ obj.getColonne()+","+obj.getLigne()+"} \n");
				System.out.print("Rockford se situe face a un DIAMANT\n");
				// On m�morise la situation
				situation = new SituationRockford_Diamant(ligne, col);
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

