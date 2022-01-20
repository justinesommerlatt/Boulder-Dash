package situation;

import obj.Diamant;
import obj.Objets;
import obj.Rocher;
import obj.Vide;
import plateau.Grille;

public class SituationRocher_Monstre extends Situation{
	public void traiter(Objets obj, int ligne, int colonne, Grille G)
	{
		Rocher r = (Rocher)obj;
		System.out.print("Le rocher ecrase le monstre\n");
		G.set(r.getLigne(),r.getColonne(),new Vide(r.getColonne(),r.getLigne()));
		System.out.print("Un diamant apparait ! \n");
		G.set(colonne,ligne,new Diamant(ligne,colonne));
		System.out.print("Le diamant se situe donc en {"+ligne+","+colonne+"}\n");
	}

	public SituationRocher_Monstre(int l, int c)
	{
		super(l,c);
	}
}
