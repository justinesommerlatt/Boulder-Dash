package obj;

public abstract class Objets {
	int colonne,ligne;

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

	public Objets(int x, int y) {
		super();
		this.colonne = x;
		this.ligne = y;
	}


}
