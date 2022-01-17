package model;

import model.etat.EtatCase;
import model.etat.estAchete;
import model.etat.estLibre;

public class CasePropriete extends Case {
	private int prixAchat;
	private int loyer;
	private Joueur proprietaire;

	public CasePropriete(String nom, Case suivante, int prixAchat, int loyer) {
		super(nom,suivante);
		this.proprietaire = null;
		this.prixAchat = prixAchat;
		this.loyer = loyer;
	}

	
	public boolean estLibre() {
		return false;
	}
	
	@Override
	public void traitementJoueur(Joueur j){
		
	}
	
	
	public void payerProprietaire(int loyer) {
		proprietaire.recevoir(loyer);

	}
	
	public boolean estProprietaire(Joueur joueur) {
		return joueur.equals(proprietaire);
	}
	
	public void achete(Joueur j, int somme) {
		
	}
	
	public void changementEtat() {
		
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


	public Joueur getProprietaire() {
		return proprietaire;
	}

	public void setPropritaire(Joueur joueur) {
		this.proprietaire = joueur;
		
	}

}
