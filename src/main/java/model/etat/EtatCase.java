package model.etat;

import model.Joueur;
import model.Rue;

public class EtatCase {
	protected Rue rueAsso;
	
	public EtatCase(Rue caseAsso) {
		this.rueAsso = caseAsso;
	}

	
	
	public boolean estLibre(){
		return false;
	}
	
	public boolean construit(){
		return false;
	}
	

	public void traitementJoueur(Joueur joueur) {
	}
	
	public boolean estConstructible() {
		return false;
	}
	
	public void changementEtat() {
	}


	public void construire() {
			
	}
	
	
	public void achete(Joueur j) {
		
	}



	public boolean constructible() {
		return false;
	}

}
