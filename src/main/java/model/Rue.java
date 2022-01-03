package model;

public class Rue extends CasePropriete{
	private int nbMaison;
	private int prixMaison;

	public Rue(String nom, Quartier quartier, Case suivante, Joueur proprietaire, int PrixAchat, int loyer, int prixHotel, int prixMaison) {
		super(nom, quartier, suivante, PrixAchat, loyer);
		this.prixMaison = prixMaison;
	}

	
	public void construire() {
		etat.construire();
	}
	
	//////////////////////////////
	///////////GETTERS////////////
	//////////////////////////////
	/**
	 * @return the nbMaison
	 */
	public int getNbMaison() {
		return nbMaison;
	}

	/**
	 * @return the prixMaison
	 */
	public int getPrixMaison() {
		return prixMaison;
	}


	public void setNbMaison() {
		this.nbMaison++;
	}



	

}
