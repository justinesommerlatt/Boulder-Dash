package cor;

import obj.Monstre;
import obj.Objets;
import obj.Rockford;
import plateau.Grille;
import situation.Situation;
import situation.SituationRockford_Monstre;

public class DetecteurRockford_Monstre extends DetecteurSituation{
	private SituationRockford_Monstre situation;

	//Cette m�thode teste si Rockford se trouver dans la situation SituationMonstre
	@Override
	public boolean estDetectee(Objets obj , int ligne , int col, Grille grille)
	{
		if (obj instanceof Rockford)
		{
			boolean conforme = DetecteurUtil.estValide(ligne,col,grille);
			//La case face � Rockford est bien un MONSTRE
			if (conforme && grille.get(ligne,col) instanceof Monstre)
			{
				System.out.print("Rockford se trouve en {"+ obj.getColonne()+","+obj.getLigne()+"} \n");
				System.out.print("Rockford se situe face a un MONSTRE\n");
				// On m�morise la situation
				situation = new SituationRockford_Monstre(ligne, col);
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

