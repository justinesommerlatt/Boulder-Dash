package situation;

import obj.Acier;
import obj.Brique;
import obj.Diamant;
import obj.Objets;
import obj.Rocher;
import obj.Terre;
import plateau.Grille;

public class SituationDiamant_Autres extends Situation{
	public void traiter(Objets obj, int ligne, int col, Grille G)
	{
		if (G.get(ligne, col) instanceof Rocher)
			System.out.print("Un rocher empeche le diamant de se deplacer\n");
		else if (G.get(ligne, col) instanceof Diamant)
			System.out.print("Un autre diamant empeche le diamant de se deplacer\n");
		else if (G.get(ligne, col) instanceof Acier)
			System.out.print("De l'acier empeche le diamant de se deplacer\n");
		else if (G.get(ligne, col) instanceof Terre)
			System.out.print("De la terre empeche le diamant de se deplacer\n");
		else if (G.get(ligne, col) instanceof Brique)
			System.out.print("De la brique empeche le diamant de se deplacer\n");
	}

	public SituationDiamant_Autres(int l, int c)
	{
		super(l,c);
	}
}
