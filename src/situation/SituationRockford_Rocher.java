package situation;

import cor.DetecteurUtil;
import obj.Objets;
import obj.Rocher;
import obj.Rockford;
import obj.Vide;
import plateau.Grille;

public class SituationRockford_Rocher extends Situation {
	public void traiter(Objets obj, int ligne, int col, Grille G)
	{
		Rockford rf = (Rockford)obj;
		if (ligne == rf.getLigne())
		{
			if(col==rf.getColonne()+1)//Le rocher se trouver a droite
			{
				boolean conform = DetecteurUtil.estValide(ligne,col+1,G);
				if(conform && G.get(ligne,col+1) instanceof Vide)
				{
					System.out.print("Rockford peut pousser le rocher vers la droite \n");
					G.set(rf.getColonne(),rf.getLigne(),new Vide(rf.getColonne(),rf.getLigne()));
					rf.setColonne(col);
					rf.setLigne(ligne);
					G.set(col,ligne,rf);
					G.set(col+1,ligne,new Rocher(col+1,ligne));
					System.out.print("Rockford se situe donc en {"+rf.getColonne()+","+rf.getLigne()+"} et le rocher en {"+ligne+","+(col+1)+"}\n");
				}
				else //(!conform || G.G[l+1][c] != Grille.VIDE)
				{
					G.set(rf.getColonne(), rf.getLigne(), rf);
					System.out.print("Rockford ne peut pas pousser ce rocher situe a sa droite\n");
					System.out.print("Il reste donc en {"+rf.getColonne()+","+rf.getLigne()+"} et le rocher en {"+ligne+","+col+"}\n");
				}
			}
			else //Le rocher se trouve forcement � gauche
			{
				boolean conform = DetecteurUtil.estValide(ligne,col-1,G);
				if(conform && G.get(ligne,col-1) instanceof Vide)
				{
					System.out.print("Rockford peut pousser le rocher vers la gauche \n");
					G.set(rf.getColonne(),rf.getLigne(),new Vide(rf.getColonne(),rf.getLigne()));
				
					rf.setColonne(col);
					rf.setLigne(ligne);
					G.set(col,ligne,rf);
					G.set(col-1,ligne,new Rocher(col-1,ligne));
					System.out.print("Rockford se situe donc en {"+rf.getColonne()+","+rf.getLigne()+"} et le rocher en {"+ligne+","+(col-1)+"}\n");
				}
				else //(!conform || G.G[l-1][c] != Grille.VIDE)
				{
					G.set(rf.getColonne(), rf.getLigne(), rf);
					System.out.print("Rockford ne peut pas pousser ce rocher situe a sa gauche\n");
					System.out.print("Il reste donc en {"+rf.getColonne()+","+rf.getLigne()+"} et le rocher en {"+ligne+","+col+"}\n");
				}
			}
		}
		else
		{
			G.set(rf.getColonne(), rf.getLigne(), rf);
			System.out.print("Rockford ne peut pas pousser de rocher verticalement\n");
			System.out.print("Il reste donc en {"+rf.getColonne()+","+rf.getLigne()+"} et le rocher en {"+ligne+","+col+"}\n");
		}
	}

	public SituationRockford_Rocher(int l, int c)
	{
		super(l,c);
	}
}
