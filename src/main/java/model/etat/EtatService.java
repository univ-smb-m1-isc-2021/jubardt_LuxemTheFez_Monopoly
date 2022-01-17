package model.etat;

import model.Joueur;
import model.Service;

public class EtatService {
	protected Service serviceAsso;

	public EtatService(Service serviceAsso) {
		this.serviceAsso = serviceAsso;
	}
	

	public void achete(Joueur j, int somme) {
	}
	
	
	public void traitementJoueur(Joueur j) {
		
	}
	
	
	public void changementEtat() {
		
	}
	
	public boolean estLibre() {
		return false;
	}


	public int calculLoyerService(int resDe) {
		return 0;
	}
}
