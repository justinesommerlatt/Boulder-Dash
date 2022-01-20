package situation;

import exception.BoulderException;
import exception.BoulderMortException;
import obj.Objets;
import plateau.Grille;

public abstract class Situation {
	int l,c;

	public Situation(int l, int c) {
		super();
		this.l = l;
		this.c = c;
	}

	public int getL() {
		return l;
	}

	public void setL(int l) {
		this.l = l;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}
	/**
	 * Effectue les modifications necessaires selon le cas dans lequel on se trouve (grace a la COR)
	 * @param obj objet à traiter
	 * @param ligne la ligne
	 * @param col la colonne
	 * @param G la grille d'objets
	 * @throws BoulderMortException
	 * @throws BoulderException
	 */
	public abstract void traiter(Objets obj, int ligne, int col, Grille G) throws BoulderMortException, BoulderException;

}
