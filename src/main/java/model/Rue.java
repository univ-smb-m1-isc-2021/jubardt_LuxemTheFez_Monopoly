package model;

import model.etat.EtatCase;
import model.etat.estAchete;
import model.etat.estConstructible;
import model.etat.estLibre;

public class Rue extends CasePropriete{
	private int nbMaison;
	private int prixMaison;
	private Quartier quartier;
	private EtatCase etat;

	public Rue(String nom, Case suivante, int PrixAchat, int loyer, int prixMaison, Quartier quartier) {
		super(nom, suivante, PrixAchat, loyer);
		this.prixMaison = prixMaison;
		this.quartier = quartier;
		this.etat = new estLibre(this);
	}

	
	public void construire() {
		etat.construire();
	}
	
	@Override
	public void achete(Joueur j, int somme) {
		etat.achete(j);
	}
	
	@Override
	public void changementEtat() {
		etat.changementEtat();
	}
	
	@Override
	public void traitementJoueur(Joueur j) {
		etat.traitementJoueur(j);
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


	public void setEtat(EtatCase ec) {
		etat = ec;
		
	}


	public Quartier getQuartier() {
		return quartier;
	}


	public void setQuartier(Quartier quartier) {
		this.quartier = quartier;
	}
	
	@Override
	public String toString() {
		return "Rue: "+ nom;
	}



	

}
