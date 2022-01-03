package model.etat;

import model.CasePropriete;
import model.Joueur;
import model.Rue;

public class estAchete extends EtatCase {

	public estAchete(CasePropriete caseAsso) {
		super(caseAsso);
		
		if(caseAsso.getQuartier().estComplet()) {
			caseAsso.getQuartier().setQuartierComplet();
		}
		
	}

	
	@Override
	public void traitementJoueur(Joueur joueur) {
		if (!estProprietaire(joueur)) {
			int loyer = caseAsso.getLoyer();
			if(joueur.possedeSomme(loyer)) {
				joueur.payer(loyer);
				caseAsso.payerProprietaire(loyer);
			}else{
				System.out.println("Vous avez perdu");
			}
			
		}else {
			System.out.println("Bienvenue chez toi mon reuf mets toi bien");
		}
			
	}
	
	
	@Override
	public void changementEtat() {
		caseAsso.setEtat(new estConstructible(caseAsso));
	}
	
	@Override
	public String toString() {
		return "Etat: est acheté";
	}
	
}
