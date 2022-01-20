package cor;

import obj.Objets;
import obj.Rocher;
import obj.Vide;
import plateau.Grille;
import situation.Situation;
import situation.SituationRocher_Vide;

public class DetecteurRocher_Vide extends DetecteurSituation{
	private SituationRocher_Vide situation;

	//Cette m�thode teste si un Rocher se trouve dans la situation SituationRocher_Vide
	@Override
	public boolean estDetectee(Objets obj , int ligne , int col, Grille grille)
	{
		if (obj instanceof Rocher)
		{
			boolean conforme = DetecteurUtil.estValide(ligne,col,grille);
			//La case face au Rocher est bien une case Vide
			if (conforme && grille.get(ligne,col) instanceof Vide)
			{
				System.out.print("Le rocher se trouve en {"+ obj.getLigne()+","+obj.getColonne()+"} \n");
				System.out.print("Le rocher se situe face a une case Vide\n");
				// On m�morise la situation
				situation = new SituationRocher_Vide(ligne, col);
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
