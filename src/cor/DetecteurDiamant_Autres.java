package cor;

import obj.Acier;
import obj.Diamant;
import obj.Monstre;
import obj.Objets;
import obj.Rocher;
import obj.Terre;
import plateau.Grille;
import situation.Situation;
import situation.SituationDiamant_Autres;

public class DetecteurDiamant_Autres extends DetecteurSituation{
	private SituationDiamant_Autres situation;

	//Cette m�thode teste si un Diamant se trouve face � des objets qui l'empeche d'avancer
	@Override
	public boolean estDetectee(Objets obj , int ligne , int col, Grille grille)
	{
		if (obj instanceof Diamant)
		{
			boolean conforme = DetecteurUtil.estValide(ligne,col,grille);
			//La case face au Diamant est un Rocher,un Diamant, de l'Acier, de la Terre ou un Monstre
			if (conforme && (grille.get(ligne,col) instanceof Rocher || grille.get(ligne,col) instanceof Diamant || grille.get(ligne,col) instanceof Acier || grille.get(ligne,col) instanceof Terre || grille.get(ligne,col) instanceof Monstre))
			{
				System.out.print("Le diamant se trouve en {"+ obj.getLigne()+","+obj.getColonne()+"} \n");
				// On m�morise la situation
				situation = new SituationDiamant_Autres(ligne, col);
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
