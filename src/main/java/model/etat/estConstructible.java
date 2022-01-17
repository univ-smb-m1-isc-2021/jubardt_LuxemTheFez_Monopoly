package model.etat;

import model.Case;
import model.CasePropriete;
import model.Joueur;
import model.Rue;

public class estConstructible extends EtatCase {

	public estConstructible(Rue rueAsso) {
		super(rueAsso);
	}
	
	
	@Override
	public void traitementJoueur(Joueur joueur) {
		System.out.println("Vous êtes dans la rue constructible " + rueAsso.getNom());
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
			System.out.println("Vous pouvez contruire sur cette case !");
		}	
	}
	
	@Override
	public boolean constructible() {
		return true;
	}
	
	@Override
	public void construire() {
		rueAsso.setNbMaison();
		System.out.println("Une maison a ete construite");
		changementEtat();
	}
	
	
	@Override
	public String toString() {
		return "Etat: constructible";
	}
	
	@Override
	public void changementEtat() {
		rueAsso.setEtat(new estConstruit(rueAsso));
	}
}
