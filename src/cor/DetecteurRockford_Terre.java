package cor;

import obj.Objets;
import obj.Rockford;
import obj.Terre;
import plateau.Grille;
import situation.Situation;
import situation.SituationRockford_Terre;

public class DetecteurRockford_Terre extends DetecteurSituation{
	private SituationRockford_Terre situation;

	//Cette m�thode teste si Rockford se trouver dans la situation SituationTerre
	@Override
	public boolean estDetectee(Objets obj , int ligne , int col, Grille grille)
	{
		if (obj instanceof Rockford)
		{
			boolean conforme = DetecteurUtil.estValide(ligne,col,grille);
			//La case face � Rockford est bien de la TERRE
			if (conforme && grille.get(ligne,col) instanceof Terre)
			{
				System.out.print("Rockford se trouve en {"+ obj.getColonne()+","+obj.getLigne()+"} \n");
				System.out.print("Rockford se situe face a de la TERRE\n");
				// On m�morise la situation
				situation = new SituationRockford_Terre(ligne, col);
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
