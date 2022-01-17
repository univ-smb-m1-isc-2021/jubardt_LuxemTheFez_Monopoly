package model.etat;

import java.util.Scanner;

import model.CasePropriete;
import model.Joueur;
import model.Rue;

public class estLibre extends EtatCase {

	public estLibre(Rue rueAsso) {
		super(rueAsso);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean estLibre() {
		return true;
	}
	
	@Override
	public void traitementJoueur(Joueur joueur) {
		String res;
		System.out.println("Vous êtes dans la rue libre " + rueAsso.getNom());
		System.out.println("Cette rue est à vendre");
		System.out.println("Vous avez "+joueur.getCompte()+"€ sur votre compte" );
		System.out.println("Voulez vous l'acheter pour "+rueAsso.getPrixAchat()+"€ : y/n");
		Scanner inputScanner = new Scanner(System.in);
		res = inputScanner.nextLine();
		if(res.equals("y")){
			int somme = rueAsso.getPrixAchat();
			achete(joueur, somme);
		}else {
			System.out.println("Vous avez refusé l'offre");
		}
	}
	
	public void achete(Joueur joueur, int somme) {
		
		if(joueur.possedeSomme(somme)) {
			joueur.payer(somme);
			joueur.ajouterProprieteR(rueAsso);
			rueAsso.setPropritaire(joueur);
			System.out.println("Vous êtes le nouveau proprietaire de "+rueAsso.toString()+" !");
			changementEtat();
		}else {
			System.out.println("Vous n'avez pas assez d'argent sur votre compte");
		}
	}
		
	@Override
	public void changementEtat() {
		rueAsso.setEtat(new estAchete(rueAsso));
	}
	
	@Override
	public String toString() {
		return "Etat: est libre";
	}
		
}
