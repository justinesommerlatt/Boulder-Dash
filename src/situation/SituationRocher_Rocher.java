package situation;

import cor.DetecteurUtil;
import obj.Objets;
import obj.Rocher;
import obj.Vide;
import plateau.Grille;

public class SituationRocher_Rocher extends Situation {
	public void traiter(Objets obj, int ligne, int col, Grille G)
	{
		Rocher r = (Rocher)obj;
		//On v�rifier si � la droite du rocher se trouve une case VIDE
		if (DetecteurUtil.estValide(col+1, ligne, G) && G.get(ligne, col+1) instanceof Vide)
		{
			System.out.print("Le rocher glisse a la droite du rocher qu'il a rencontre\n");
			G.set(r.getLigne(),r.getColonne(),new Vide(r.getLigne(),r.getColonne()));
			r.setColonne(ligne);
			r.setLigne(col+1);
			G.set(r.getLigne(),r.getColonne(),r);
			System.out.print("Il se situe maintenant en {"+r.getColonne()+","+r.getLigne()+"}\n");
		}
		else if (DetecteurUtil.estValide(col-1, ligne, G) && G.get(ligne, col-1) instanceof Vide)
		{
			System.out.print("Le rocher ne peux pas glisser a la droite du rocher qu'il a rencontre\n");
			System.out.print("Il peut cependant glisser à gauche\n");
			G.set(r.getLigne(),r.getColonne(),new Vide(r.getColonne(),r.getLigne()));
			r.setColonne(ligne);
			r.setLigne(col-1);
			G.set(r.getLigne(),r.getColonne(),r);
			System.out.print("Il se situe maintenant en {"+r.getColonne()+","+r.getLigne()+"}\n");
		}
		else
		{
			System.out.print("Le rocher ne peux pas glisser\n");
			System.out.print("Il reste donc en {"+r.getColonne()+","+r.getLigne()+"}\n");
		}
	}

	public SituationRocher_Rocher(int l, int c)
	{
		super(l,c);
	}
}
