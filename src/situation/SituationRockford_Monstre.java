package situation;

import exception.BoulderMortException;
import obj.Objets;
import obj.Rockford;
import obj.Vide;
import plateau.Grille;

public class SituationRockford_Monstre extends Situation {
	public void traiter(Objets obj, int ligne, int col, Grille G) throws BoulderMortException
	{
		Rockford rf = (Rockford)obj;
		G.set(rf.getColonne(),rf.getLigne(),new Vide(rf.getColonne(),rf.getLigne()));
		rf.setColonne(col);
		rf.setLigne(ligne);
		G.set(col,ligne,rf);
		System.out.print("Les points de vie de Rockford actuellement : "+rf.getPtsVie()+"\n");
		rf.setPtsVie(rf.getPtsVie()-1);
		if(rf.getPtsVie() <= 0) //Rockford meurt
			throw new BoulderMortException("Rockford est mort");
		System.out.print("Rockford perd 1 pt de vie et le monstre meurt. Nvx pts de vie : "+rf.getPtsVie()+"\n");
		System.out.print("Il se situe maintenant en {"+rf.getColonne()+","+rf.getLigne()+"}\n");
	}

	public SituationRockford_Monstre(int l, int c)
	{
		super(l,c);
	}
}
