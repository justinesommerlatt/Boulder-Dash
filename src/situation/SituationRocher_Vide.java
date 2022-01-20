package situation;

import cor.DetecteurUtil;
import exception.BoulderMortException;
import obj.Objets;
import obj.Rocher;
import obj.Rockford;
import obj.Vide;
import plateau.Grille;

public class SituationRocher_Vide extends Situation{
	public void traiter(Objets obj, int ligne, int colonne, Grille G) throws BoulderMortException
	{
		Rocher r = (Rocher)obj;
		boolean conforme = DetecteurUtil.estValide(ligne+1, colonne, G);
		if (conforme && G.get(ligne+1,colonne) instanceof Rockford)
		{
			//Dans sa chute, le rocher rencontre Rockford. Il lui inflige donc un pts de degat
			System.out.print("Le rocher rencontre Rockford pendant sa chute\n");
			System.out.print("Rockford perd donc un point de vie\n");
			Rockford rf = (Rockford)G.get(ligne+1,colonne);
			rf.setPtsVie(rf.getPtsVie()-1);
			if(rf.getPtsVie() <= 0) //Rockford meurt
				throw new BoulderMortException("Rockford est mort");
			System.out.print("Les nvx pts de vies de Rockford (initialement 3) : "+ rf.getPtsVie()+"\n");
			G.set(r.getLigne(),r.getColonne(),new Vide(r.getColonne(),r.getLigne()));
			r.setColonne(colonne);
			r.setLigne(ligne);
			G.set(colonne,ligne,r);
			System.out.print("Le rocher se situe maintenant en {"+r.getColonne()+","+r.getLigne()+"}\n");

		}
		else //Il ne rencontre que du Vide
		{
			System.out.print("Le rocher ne rencontre que du vide pendant sa chute\n");
			G.set(r.getLigne(),r.getColonne(),new Vide(r.getColonne(),r.getLigne()));
			r.setColonne(ligne);
			r.setLigne(colonne);
			G.set(r.getLigne(),r.getColonne(),r);
			System.out.print("Le rocher se situe maintenant en {"+r.getColonne()+","+r.getLigne()+"}\n");
		}
	}

	public SituationRocher_Vide(int l, int c)
	{
		super(l,c);
	}
}
