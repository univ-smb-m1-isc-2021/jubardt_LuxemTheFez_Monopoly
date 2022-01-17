package model.etat;

import model.Gare;
import model.Joueur;

public class EtatGare {
	protected Gare gareAsso;

	public EtatGare(Gare gareAsso) {
		this.gareAsso = gareAsso;
	}

	public int calculLoyerGare() {
		return 0;
	}
	
	public void achete(Joueur j, int sommme) {
	}
	
	public void traitementJoueur(Joueur j) {
		
	}
	
	public void changementEtat() {
		
	}
	
	public boolean estLibre() {
		return false;
	}
}
