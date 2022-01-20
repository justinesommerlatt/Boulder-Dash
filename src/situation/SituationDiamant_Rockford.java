package situation;

import obj.Objets;
import plateau.Grille;

public class SituationDiamant_Rockford extends Situation{
	public void traiter(Objets obj, int ligne, int col, Grille G)
	{
		System.out.print("Il ne se passe rien\n");
	}

	public SituationDiamant_Rockford(int l, int c)
	{
		super(l,c);
	}
}
