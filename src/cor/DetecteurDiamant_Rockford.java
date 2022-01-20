package cor;

import obj.Diamant;
import obj.Objets;
import obj.Rockford;
import plateau.Grille;
import situation.Situation;
import situation.SituationDiamant_Rockford;

public class DetecteurDiamant_Rockford extends DetecteurSituation {
	private SituationDiamant_Rockford situation;

	//Cette m�thode teste si un Diamant se trouve dans la situation SituationDiamant_Rockford
	@Override
	public boolean estDetectee(Objets obj , int ligne , int col, Grille grille)
	{
		if (obj instanceof Diamant)
		{
			boolean conforme = DetecteurUtil.estValide(ligne,col,grille);
			//La case face au Diamant est bien Rockford
			if (conforme && grille.get(ligne,col) instanceof Rockford)
			{
				System.out.print("Le diamant se trouve en {"+ obj.getLigne()+","+obj.getColonne()+"} \n");
				System.out.print("Le diamant se situe face a Rockford\n");
				// On m�morise la situation
				situation = new SituationDiamant_Rockford(ligne, col);
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
