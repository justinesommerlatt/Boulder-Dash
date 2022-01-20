package situation;

import obj.Objets;
import obj.Rockford;
import obj.Vide;
import plateau.Grille;

public class SituationRockford_Diamant extends Situation{
	public void traiter(Objets obj, int ligne, int col, Grille G)
	{
		Rockford rf = (Rockford)obj;
		G.set(rf.getColonne(),rf.getLigne(),new Vide(rf.getColonne(),rf.getLigne()));
		rf.setColonne(col);
		rf.setLigne(ligne);
		G.set(col,ligne,rf);
		System.out.print("Rockford a "+rf.getNbDiamants()+" diamants\n");
		rf.setNbDiamants(rf.getNbDiamants()+1);
		System.out.print("Rockford a ramasse le DIAMANT. Il a desormais "+rf.getNbDiamants()+" diamants. \n");
		System.out.print("Il se situe maintenant en {"+rf.getColonne()+","+rf.getLigne()+"}\n");
	}

	public SituationRockford_Diamant(int l, int c)
	{
		super(l,c);
	}

}
