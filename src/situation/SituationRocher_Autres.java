package situation;

import obj.Acier;
import obj.Brique;
import obj.Diamant;
import obj.Objets;
import obj.Terre;
import plateau.Grille;

public class SituationRocher_Autres extends Situation{
	public void traiter(Objets obj, int ligne, int col, Grille G)
	{
		if (G.get(ligne, col) instanceof Diamant)
			System.out.print("Un diamant empeche le rocher de se deplacer\n");
		else if (G.get(ligne, col) instanceof Acier)
			System.out.print("De l'acier empeche le rocher de se deplacer\n");
		else if (G.get(ligne, col) instanceof Terre)
			System.out.print("De la terre empeche le rocher de se deplacer\n");
		else if (G.get(ligne, col) instanceof Brique)
			System.out.print("De la brique empeche le rocher de se deplacer\n");
	}

	public SituationRocher_Autres(int l, int c)
	{
		super(l,c);
	}
}
