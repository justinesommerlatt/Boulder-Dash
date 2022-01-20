package cor;

import obj.Acier;
import obj.Objets;
import obj.Rockford;
import plateau.Grille;
import situation.Situation;
import situation.SituationRockford_Acier;

public class DetecteurRockford_Acier extends DetecteurSituation{
	private SituationRockford_Acier situation;

	//Cette m�thode teste si Rockford se trouver dans la situation SituationAcier
	@Override
	public boolean estDetectee(Objets obj , int ligne , int col, Grille grille)
	{
		if (obj instanceof Rockford)
		{
			boolean conforme = DetecteurUtil.estValide(ligne,col,grille);
			//La case face � Rockford est bien de l'ACIER
			if (conforme && grille.get(ligne,col) instanceof Acier)
			{
				System.out.print("Rockford se trouve en {"+ obj.getColonne()+","+obj.getLigne()+"} \n");
				System.out.print("Rockford se situe face a une case en ACIER, il ne peut donc pas la traverser\n");
				// On m�morise la situation
				situation = new SituationRockford_Acier(ligne, col);
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
