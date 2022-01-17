package model.etat;

import model.Joueur;
import model.Rue;

public class estConstruit extends EtatCase {

	public estConstruit(Rue rueAsso) {
		super(rueAsso);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Etat: est construit";
	}
	
	public boolean construit() {
		return true;
	}
	
	@Override
	public void changementEtat() {
		
	}
	
	@Override
	public void traitementJoueur(Joueur joueur) {
		System.out.println("Vous êtes dans la rue construite " + rueAsso.getNom());
		if (!rueAsso.estProprietaire(joueur)) {
			int loyer = getLoyerComplet();
			if(joueur.possedeSomme(loyer)) {
				joueur.payer(loyer);
				rueAsso.payerProprietaire(loyer);
				System.out.println("Vous avez payez "+loyer +" euros au proprietaire "+rueAsso.getProprietaire().getNom());
				System.out.println("Le prix correspond au loyer d'un quartier complet accompagné de "+rueAsso.getNbMaison()+" fois la taxe de maison de "+ rueAsso.getPrixMaison());
			}else{
				System.out.println("Vous n'avez pas assez d'argent ! Fin de partie");
			}
		}else {
			System.out.println("Bienvenue chez vous cher proprietaire !");
		}	
	}
	
	public int getLoyerComplet() {
		return rueAsso.getLoyer()+rueAsso.getNbMaison()*rueAsso.getPrixMaison();
	}
}
