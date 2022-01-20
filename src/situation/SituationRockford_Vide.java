package situation;

import obj.Objets;
import obj.Rockford;
import obj.Vide;
import plateau.Grille;

public class SituationRockford_Vide extends Situation {

	public void traiter(Objets obj, int ligne, int col, Grille G)
	{
		Rockford rf = (Rockford)obj;
		G.set(rf.getColonne(),rf.getLigne(),new Vide(rf.getColonne(),rf.getLigne()));
		rf.setColonne(col);
		rf.setLigne(ligne);
		G.set(col,ligne,rf);
		System.out.print("Rockford se situe maintenant en {"+rf.getLigne()+","+rf.getColonne()+"} \n");
	}

	public SituationRockford_Vide(int l, int c)
	{
		super(l,c);
	}
}
