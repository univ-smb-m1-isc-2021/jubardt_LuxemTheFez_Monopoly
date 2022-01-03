package model;

import model.etat.EtatCase;
import model.etat.estAchete;
import model.etat.estLibre;

public class CasePropriete extends Case {
	private int prixAchat;
	private int loyer;
	private Quartier quartier;
	private Joueur proprietaire;
	protected EtatCase etat;

	public CasePropriete(String nom, Quartier quartier, Case suivante,int PrixAchat, int loyer) {
		super(nom,suivante);
		this.quartier = quartier;
		this.proprietaire = null;
		this.prixAchat = prixAchat;
		this.loyer = loyer;
		this.etat = new estLibre(this);
	}

	public void traitementJoueur(){
		etat.traitementJoueur(proprietaire);
	}
	
	public void changementEtat() {
		etat.changementEtat();
	}

	public void payerProprietaire(int loyer) {
		proprietaire.recevoir(loyer);

	}
	

	
	//Getters&Setters
	
	public int getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(int prixAchat) {
		this.prixAchat = prixAchat;
	}

	public int getLoyer() {
		return loyer;
	}

	public void setLoyer(int loyer) {
		this.loyer = loyer;
	}

	public void setEtat(EtatCase etat) {
		this.etat = etat;
		
	}

	public Joueur getProprietaire() {
		return proprietaire;
	}

	public void setPropritaire(Joueur joueur) {
		this.proprietaire = joueur;
		
	}

	public Quartier getQuartier() {
		return quartier;
	}

}
