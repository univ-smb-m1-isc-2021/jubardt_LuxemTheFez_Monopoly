package model.etat;

import model.CasePropriete;
import model.Joueur;

public class EtatCase {
	protected CasePropriete caseAsso;
	
	public EtatCase(CasePropriete caseAsso) {
		this.caseAsso = caseAsso;
	}

	
	
	public boolean estLibre(){
		return false;
	}
	
	public boolean estProprietaire(Joueur joueur) {
		return joueur.equals(caseAsso.getProprietaire());
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

}
