package model.etat;

import model.Service;

import java.util.Scanner;

import model.Joueur;

public class serviceLibre extends EtatService {
	
	
	public serviceLibre(Service serviceAsso) {
		super(serviceAsso);
	}

	@Override
	public String toString() {
		return "Etat: service libre";
	}
	
	@Override
	public boolean estLibre() {
		return true;
	}

	@Override
	public void changementEtat() {
		serviceAsso.setEtat(new serviceAchete(serviceAsso));
	}
	
	
	@Override
	public void traitementJoueur(Joueur joueur) {
		String res;
		System.out.println("Vous êtes dans le service " + serviceAsso.getNom());
		System.out.println("Ce service est à vendre");
		System.out.println("Vous avez "+joueur.getCompte()+"€ sur votre compte" );
		System.out.println("Voulez vous l'acheter pour "+serviceAsso.getPrixAchat()+"€ : y/n");		
		Scanner inputScanner = new Scanner(System.in);
		res = inputScanner.nextLine();
		if(res.equals("y")){
			int somme = serviceAsso.getPrixAchat();
			achete(joueur, somme);
		}else {
			System.out.println("Vous avez refusé l'offre");
		}
	}
	
	
	@Override
	public void achete(Joueur joueur, int somme) {
		if(joueur.possedeSomme(somme)) {
			joueur.payer(somme);
			joueur.ajouterProprieteS(serviceAsso);
			serviceAsso.setPropritaire(joueur);
			System.out.println("Vous êtes le nouveau proprietaire de la case");

			changementEtat();
		}else {
			System.out.println("Vous n'avez pas assez d'argent sur votre compte. Perdu !");
		}
	}
	

}
