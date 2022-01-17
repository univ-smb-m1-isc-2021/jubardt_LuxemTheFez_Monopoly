package model.etat;

import model.CasePropriete;
import model.Joueur;
import model.Rue;

public class estAchete extends EtatCase {

	public estAchete(Rue rueAsso) {
		super(rueAsso);
		if(rueAsso.getQuartier().estComplet()) {
			System.out.println("Le quartier est complet");
			rueAsso.getQuartier().setQuartierComplet();
		}
		
	}

	
	@Override
	public void traitementJoueur(Joueur joueur) {
		System.out.println("Vous dans la rue non libre " + rueAsso.getNom());
		if (!rueAsso.estProprietaire(joueur)) {
			int loyer = rueAsso.getLoyer();
			if(joueur.possedeSomme(loyer)) {
				joueur.payer(loyer);
				rueAsso.payerProprietaire(loyer);
				System.out.println("Vous avez payez "+loyer +" euros au proprietaire "+rueAsso.getProprietaire().getNom());
			}else{
				System.out.println("Vous n'avez pas assez d'argent ! Fin de partie");
			}
		}else {
			System.out.println("Bienvenue chez vous cher proprietaire !");
		}	
	}
	
	
	@Override
	public void changementEtat() {
		rueAsso.setEtat(new estConstructible(rueAsso));
	}
	
	@Override
	public String toString() {
		return "Etat: est acheté";
	}
	
}
