package model.etat;

import model.Case;
import model.CasePropriete;
import model.Joueur;
import model.Rue;

public class estConstructible extends EtatCase {

	public estConstructible(CasePropriete caseAsso) {
		super(caseAsso);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public void traitementJoueur(Joueur joueur) {
		
	}
	
	@Override
	public boolean estConstructible() {
		return true;
	}
	
	@Override
	public void construire() {
		/*caseAsso.setNbMaison();*/
	}
	
	
	@Override
	public String toString() {
		return "Etat: constructible";
	}
}
