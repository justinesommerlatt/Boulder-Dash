package cor;

import obj.Acier;
import obj.Diamant;
import obj.Objets;
import obj.Rocher;
import obj.Terre;
import plateau.Grille;
import situation.Situation;
import situation.SituationRocher_Autres;

public class DetecteurRocher_Autres extends DetecteurSituation{
	private SituationRocher_Autres situation;

	//Cette m�thode teste si un Rocher se trouve face � des objets qui l'empeche d'avancer
	@Override
	public boolean estDetectee(Objets obj , int ligne , int col, Grille grille)
	{
		if (obj instanceof Rocher)
		{
			boolean conforme = DetecteurUtil.estValide(ligne,col,grille);
			//La case face au Rocher est un Diamant, de l'Acier ou de la Terre
			if (conforme && (grille.get(ligne,col) instanceof Diamant || grille.get(ligne,col) instanceof Acier || grille.get(ligne,col) instanceof Terre))
			{
				System.out.print("Le rocher se trouve en {"+ obj.getLigne()+","+obj.getColonne()+"} \n");
				// On m�morise la situation
				situation = new SituationRocher_Autres(ligne, col);
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
