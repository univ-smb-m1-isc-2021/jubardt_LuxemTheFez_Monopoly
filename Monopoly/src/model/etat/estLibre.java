package model.etat;

import java.util.Scanner;

import model.CasePropriete;
import model.Joueur;

public class estLibre extends EtatCase {

	public estLibre(CasePropriete caseAsso) {
		super(caseAsso);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean estLibre() {
		return true;
	}
	
	@Override
	public void traitementJoueur(Joueur joueur) {
		System.out.println("La case est à vendre");
		System.out.println("Voulez vous l'acheter : y/n");
		Scanner inputScanner = new Scanner(System.in);
		if(inputScanner.equals("y")){
			int somme = caseAsso.getPrixAchat();
			achete(joueur, somme);
		}else {
			System.out.println("Vous avez refusé l'offre");
		}
	}
	
	public void achete(Joueur joueur, int somme) {
		
		if(joueur.possedeSomme(somme)) {
			joueur.payer(somme);
			joueur.ajouterPropriete(caseAsso);
			caseAsso.setPropritaire(joueur);
			System.out.println("Vous êtes le nouveau proprietaire de la case");
			
			changementEtat();
		}else {
			System.out.println("Vous n'avez pas assez d'argent sur votre compte");
		}
	}
		
	@Override
	public void changementEtat() {
		caseAsso.setEtat(new estAchete(caseAsso));
	}
	
	@Override
	public String toString() {
		return "Etat: est libre";
	}
		
}
