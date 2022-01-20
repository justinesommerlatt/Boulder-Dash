package situation;

import obj.Objets;
import plateau.Grille;

public class SituationRocher_Rockford extends Situation{
	public void traiter(Objets obj, int ligne, int col, Grille G)
	{
		System.out.print("Il ne se passe rien \n");
	}

	public SituationRocher_Rockford(int l, int c)
	{
		super(l,c);
	}
}
