package cor;

import obj.Objets;
import obj.Rocher;
import obj.Rockford;
import plateau.Grille;
import situation.Situation;
import situation.SituationRocher_Rockford;

public class DetecteurRocher_Rockford extends DetecteurSituation{
	private SituationRocher_Rockford situation;

	//Cette m�thode teste si un Rocher se trouve dans la situation SituationRocher_Rockford
	@Override
	public boolean estDetectee(Objets obj , int ligne , int col, Grille grille)
	{
		if (obj instanceof Rocher)
		{
			boolean conforme = DetecteurUtil.estValide(ligne,col,grille);
			//La case face au Rocher est bien Rockford
			if (conforme && grille.get(ligne,col) instanceof Rockford)
			{
				System.out.print("Le rocher se trouve en {"+ obj.getLigne()+","+obj.getColonne()+"} \n");
				System.out.print("Le rocher se situe face a Rockford\n");
				// On m�morise la situation
				situation = new SituationRocher_Rockford(ligne, col);
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
