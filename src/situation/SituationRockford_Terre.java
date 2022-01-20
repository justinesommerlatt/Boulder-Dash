package situation;

import obj.Objets;
import obj.Rockford;
import obj.Vide;
import plateau.Grille;

public class SituationRockford_Terre extends Situation{
	public void traiter(Objets obj, int ligne, int col, Grille G)
	{
		Rockford rf = (Rockford)obj;
		G.set(rf.getColonne(),rf.getLigne(),new Vide(rf.getColonne(),rf.getLigne()));
		rf.setColonne(col);
		rf.setLigne(ligne);
		G.set(col,ligne,rf);

		System.out.print("Rockford a creuse la TERRE. Il se situe maintenant en {"+rf.getColonne()+","+rf.getLigne()+"} \n");
	}

	public SituationRockford_Terre(int l, int c)
	{
		super(l,c);
	}
}
