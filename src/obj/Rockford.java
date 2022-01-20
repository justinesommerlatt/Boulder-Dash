package obj;

public class Rockford extends Objets{
	int ptsVie;
	int nbDiamants;

	public Rockford(int x, int y)
	{
		super(x,y);
		ptsVie = 3;
		nbDiamants=0;
	}


	public int getNbDiamants() {
		return nbDiamants;
	}


	public void setNbDiamants(int nbDiamants) {
		this.nbDiamants = nbDiamants;
	}


	public int getPtsVie() {
		return ptsVie;
	}

	public void setPtsVie(int ptsVie) {
		this.ptsVie = ptsVie;
	}

	public int getColonne() {
		return colonne;
	}

	public void setColonne(int x) {
		this.colonne = x;
	}

	public int getLigne() {
		return ligne;
	}

	public void setLigne(int y) {
		this.ligne = y;
	}


}
