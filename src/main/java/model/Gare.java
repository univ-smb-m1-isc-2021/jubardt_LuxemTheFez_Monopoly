package model;

import model.etat.EtatGare;
import model.etat.gareLibre;

public class Gare extends CasePropriete {
	
	private EtatGare etat;

	
	public Gare(String nom, Case suivante, int PrixAchat, int loyer) {
		super(nom, suivante, PrixAchat, loyer);
		this.etat = new gareLibre(this);
	}
	
	@Override
	public void achete(Joueur j, int somme) {
		etat.achete(j,somme);
	}
	
	@Override
	public boolean estLibre() {
		return etat.estLibre();
	}
	
	@Override
	public void traitementJoueur(Joueur j) {
		etat.traitementJoueur(j);
	}
	
	@Override
	public void changementEtat() {
		etat.changementEtat();
	}
	
	@Override
	public String toString() {
		return "Gare: "+nom;
	}

	/**
	 * @param etat the etat to set
	 */
	public void setEtat(EtatGare etat) {
		this.etat = etat;
	}

	
}
