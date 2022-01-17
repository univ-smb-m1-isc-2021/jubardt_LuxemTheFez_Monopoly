package model.etat;

import java.util.Scanner;

import model.Joueur;
import model.Service;

public class serviceAchete extends EtatService {

	public serviceAchete(Service caseAsso) {
		super(caseAsso);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public String toString() {
		return "Etat: est acheté";
	}
	
	@Override
	public int calculLoyerService(int resDe) {
		int nbServices = serviceAsso.getProprietaire().getNombreServices();
		int loyer = serviceAsso.getLoyer();
		if (nbServices==1) {
			return 4*resDe*loyer;
			
		}
		return 10*resDe*loyer;
		
	}
	
	@Override
	public void traitementJoueur(Joueur joueur) {
		String res;
		int de=1;
		Scanner inputScanner = new Scanner(System.in);
		System.out.println("Vous êtes dans le service non libre " + serviceAsso.getNom());
		if (!serviceAsso.estProprietaire(joueur)) {
			System.out.println("Vous n'êtes pas le proprietaire: faite un lancer de dé pour savoir le montant de la taxe");
			res = inputScanner.nextLine();
			if(res.equals("lancer")) {
				de = joueur.lancerDe();
				System.out.println("La taxe est multiplié par le résultat du dé: "+de);
			}
			int loyer = calculLoyerService(de);
			if(joueur.possedeSomme(loyer)) {
				joueur.payer(loyer);
				serviceAsso.payerProprietaire(loyer);
				System.out.println("Vous avez payé" + loyer +"euros au proprietaire "+serviceAsso.getProprietaire().getNom());
			}else{
				System.out.println("Perdu");
			}
		}
	}
}
