package cor;

import obj.Diamant;
import obj.Objets;
import obj.Vide;
import plateau.Grille;
import situation.Situation;
import situation.SituationDiamant_Vide;

public class DetecteurDiamant_Vide extends DetecteurSituation{
	private SituationDiamant_Vide situation;

	//Cette m�thode teste si un Diamant se trouve dans la situation SituationDiamant_Vide
	@Override
	public boolean estDetectee(Objets obj , int ligne , int col, Grille grille)
	{
		if (obj instanceof Diamant)
		{
			boolean conforme = DetecteurUtil.estValide(ligne,col,grille);
			//La case face au Diamant est bien du Vide
			if (conforme && grille.get(ligne,col) instanceof Vide)
			{
				System.out.print("Le diamant se trouve en {"+ obj.getLigne()+","+obj.getColonne()+"} \n");
				System.out.print("Le diamant se situe face a du Vide\n");
				// On m�morise la situation
				situation = new SituationDiamant_Vide(ligne, col);
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
