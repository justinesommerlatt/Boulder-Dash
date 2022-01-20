package cor;

import obj.Objets;
import obj.Rocher;
import plateau.Grille;
import situation.Situation;
import situation.SituationRocher_Rocher;

public class DetecteurRocher_Rocher extends DetecteurSituation {
	private SituationRocher_Rocher situation;

	//Cette m�thode teste si un Rocher se trouve dans la situation SituationRocher_Rocher
	@Override
	public boolean estDetectee(Objets obj , int ligne , int col, Grille grille)
	{
		if (obj instanceof Rocher)
		{
			boolean conforme = DetecteurUtil.estValide(ligne,col,grille);
			//La case face au Rocher est bien un autre Rocher
			if (conforme && grille.get(ligne,col) instanceof Rocher)
			{
				System.out.print("Le rocher se trouve en {"+ obj.getLigne()+","+obj.getColonne()+"} \n");
				System.out.print("Le rocher se situe face a un autre rocher\n");
				// On m�morise la situation
				situation = new SituationRocher_Rocher(ligne, col);
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
