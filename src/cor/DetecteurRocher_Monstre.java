package cor;

import obj.Monstre;
import obj.Objets;
import obj.Rocher;
import plateau.Grille;
import situation.Situation;
import situation.SituationRocher_Monstre;

public class DetecteurRocher_Monstre extends DetecteurSituation{
	private SituationRocher_Monstre situation;

	//Cette m�thode teste si un Rocher se trouve dans la situation SituationRocher_Rocher
	@Override
	public boolean estDetectee(Objets obj , int ligne , int col, Grille grille)
	{
		if (obj instanceof Rocher)
		{
			boolean conforme = DetecteurUtil.estValide(ligne,col,grille);
			//La case face au Rocher est bien un Monstre
			if (conforme && grille.get(ligne,col) instanceof Monstre)
			{
				System.out.print("Le rocher se trouve en {"+ obj.getLigne()+","+obj.getColonne()+"} \n");
				System.out.print("Le rocher se situe face a un Monstre\n");
				// On m�morise la situation
				situation = new SituationRocher_Monstre(ligne, col);
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
