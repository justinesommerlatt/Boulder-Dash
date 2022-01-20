package situation;

import obj.Objets;
import plateau.Grille;

public class SituationAutres extends Situation{
	public void traiter(Objets obj, int l, int c, Grille G)
	{
		System.out.print("Il ne se passe rien \n");
	}

	public SituationAutres(int l, int c)
	{
		super(l,c);
	}
}
