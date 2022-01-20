package situation;

import exception.BoulderException;
import obj.Objets;
import obj.Rockford;
import plateau.Grille;

public class SituationRockford_Acier extends Situation {
	public void traiter(Objets obj, int ligne, int col, Grille G) throws BoulderException
	{
		Rockford rf = (Rockford)obj;
		G.set(rf.getColonne(), rf.getLigne(), rf);
		System.out.print("Rockford se situe donc toujours en {"+rf.getColonne()+","+rf.getLigne()+"} \n");
	}

	public SituationRockford_Acier(int l, int c)
	{
		super(l,c);
	}
}
