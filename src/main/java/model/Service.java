package model;

import java.util.ArrayList;

import model.etat.EtatService;
import model.etat.serviceLibre;

public class Service extends CasePropriete{
	
	private EtatService etat;
	
	public Service(String nom, Case suivante, int PrixAchat, int loyer) {
		super(nom, suivante, PrixAchat, loyer);
		this.etat = new serviceLibre(this);
	}
	
	@Override
	public boolean estLibre() {
		return etat.estLibre();
	}

	@Override
	public void achete(Joueur j, int somme) {
		etat.achete(j,somme);
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
		return "Service: "+nom;
	}

	/**
	 * @param etat the etat to set
	 */
	public void setEtat(EtatService etat) {
		this.etat = etat;
	}
	
	
	
}
