package model.etat;

import model.CasePropriete;
import model.Gare;
import model.Joueur;

public class gareAchete extends EtatGare {

	public gareAchete(Gare gareAsso) {
		super(gareAsso);
		// TODO Auto-generated constructor stub
	}
	
	public void traitementJoueur(Joueur joueur) {
		System.out.println("Vous êtes dans la gare non libre " + gareAsso.getNom());
		if (!gareAsso.estProprietaire(joueur)) {
			int loyer = calculLoyerGare();
			if(joueur.possedeSomme(loyer)) {
				joueur.payer(loyer);
				gareAsso.payerProprietaire(loyer);
				System.out.println("Vous avez payé " + loyer +" euros au proprietaire "+gareAsso.getProprietaire().getNom());
				System.out.println("Ce prix correspond au loyer fois le nombre de gare du proprietaire qui est de "+gareAsso.getProprietaire().getNombreGares());
			}else{
				System.out.println("Vous n'avez pas assez d'argent ! Fin de partie");
			}
		}
	}
	
	public int calculLoyerGare() {
		int nbGares = gareAsso.getProprietaire().getNombreGares();
		int loyer = gareAsso.getLoyer();
		return nbGares*loyer;
	}
	
	
	@Override
	public void changementEtat() {
		
	}
	
	@Override
	public String toString() {
		return "Etat: gare acheté";
	}

}
