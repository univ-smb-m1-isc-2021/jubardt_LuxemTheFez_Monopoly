package model.etat;

import java.util.Scanner;

import model.Case;
import model.Gare;
import model.Joueur;

public class gareLibre extends EtatGare {

	public gareLibre(Gare gareAsso) {
		super(gareAsso);
	}
	
	@Override
	public String toString() {
		return "Etat: gare libre";
	}

	@Override
	public void achete(Joueur joueur, int somme) {
		if(joueur.possedeSomme(somme)) {
			joueur.payer(somme);
			joueur.ajouterProprieteG(gareAsso);
			gareAsso.setPropritaire(joueur);
			System.out.println("Vous êtes le nouveau proprietaire de la case");

			changementEtat();
		}else {
			System.out.println("Vous n'avez pas assez d'argent sur votre compte");
		}
	}
	
	@Override
	public void traitementJoueur(Joueur joueur) {
		String res;
		System.out.println("Vous êtes dans la gare " + gareAsso.getNom());
		System.out.println("Cette gare est à vendre");
		System.out.println("Vous avez "+joueur.getCompte()+"€ sur votre compte" );
		System.out.println("Voulez vous l'acheter pour "+gareAsso.getPrixAchat()+"€ : y/n");		
		Scanner inputScanner = new Scanner(System.in);
		res = inputScanner.nextLine();
		if(res.equals("y")){
			int somme = gareAsso.getPrixAchat();
			achete(joueur, somme);
		}else {
			System.out.println("Vous avez refusé l'offre");
		}
	}
	
	@Override
	public void changementEtat() {
		gareAsso.setEtat(new gareAchete(gareAsso));
	}
}
