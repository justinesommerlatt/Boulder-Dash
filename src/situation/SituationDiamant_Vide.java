package situation;

import cor.DetecteurUtil;
import exception.BoulderMortException;
import obj.Diamant;
import obj.Objets;
import obj.Rockford;
import obj.Vide;
import plateau.Grille;

public class SituationDiamant_Vide extends Situation{
	public void traiter(Objets obj, int ligne, int col, Grille G) throws BoulderMortException
	{
		Diamant d = (Diamant)obj;
		boolean conforme = DetecteurUtil.estValide(col, ligne+1, G);
		if (conforme && G.get(ligne+1,col) instanceof Rockford)
		{
			//Dans sa chute, le diamant rencontre Rockford. Il lui inflige donc un pts de degat
			System.out.print("Le diamant rencontre Rockford pendant sa chute\n");
			System.out.print("Rockford perd donc un point de vie\n");
			System.out.print("Cependant Rockford gagne le diamant\n");
			Rockford rf = (Rockford)G.get(ligne+1,col);
			rf.setPtsVie(rf.getPtsVie()-1);
			rf.setNbDiamants(rf.getNbDiamants()+1);
			if(rf.getPtsVie() <= 0) //Rockford meurt
				throw new BoulderMortException("Rockford est mort");
			System.out.print("Le nb de diamants de Rockford (initialement 0) : "+ rf.getNbDiamants()+"\n");
			System.out.print("Les nvx pts de vies de Rockford (initialement 3) : "+ rf.getPtsVie()+"\n");
			G.set(d.getLigne(),d.getColonne(),new Vide(d.getColonne(),d.getLigne()));
			System.out.print("Le diamant a disparu. Il y a maintenant une case vide\n");

		}
		else //Il ne rencontre que du Vide
		{
			System.out.print("Le diamant ne rencontre que du vide pendant sa chute\n");
			G.set(d.getLigne(),d.getColonne(),new Vide(d.getColonne(),d.getLigne()));
			d.setColonne(ligne);
			d.setLigne(col);
			G.set(d.getLigne(),d.getColonne(),d);
			System.out.print("Le diamant se situe maintenant en {"+d.getColonne()+","+d.getLigne()+"}\n");
		}
	}

	public SituationDiamant_Vide(int l, int c)
	{
		super(l,c);
	}
}
