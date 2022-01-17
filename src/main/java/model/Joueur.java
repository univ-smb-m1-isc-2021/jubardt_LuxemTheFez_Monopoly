package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Joueur {
	private String nom;
	private int compte;
	private int nombreGares;
	private int nombreServices;
	private Case estSur;
	private ArrayList<Rue> rues;
	private ArrayList<Gare> gares;
	private ArrayList<Service> services;
	private Partie partie;
	
	public Joueur(String nom,Case estSur,Partie partie){
		this.nom = nom;
		this.estSur = estSur;
		this.partie = partie;
		nombreGares = 0;
		nombreServices = 0;
		compte = 1000000000;
		this.rues = new ArrayList<>();
		this.gares = new ArrayList<>();
		this.services = new ArrayList<>();
	}
	
	public void avancer(int nombre) {
		Case caseA = estSur.suivant(nombre);
		estSur = caseA;
		caseA.setVisiteur(this);
	}
	
	
	public boolean payer(int somme){
		boolean res = false;
		if (compte - somme>0) {
			compte-=somme;
			res = true;
		}
		
		return res;
	}
	
	public void recevoir(int somme) {
		compte+=somme;
	}
	
	public boolean possedeSomme(int somme) {
		return compte-somme>0;
	}
	
	public void ajouterProprieteR(Rue r) {
		rues.add(r);
	}
	
	public void joueTour() {
		estSur.traitementJoueur(this);
	}
	
	public void ajouterProprieteG(Gare g) {
		nombreGares +=1;
		gares.add(g);
	}
	
	public void ajouterProprieteS(Service s) {
		/*System.out.println(s);*/
		nombreServices+=1;
		services.add(s);
		/*for(Service ss:services) {
			System.out.println("les services du joueur " +nom+" : ");
			System.out.println(ss);
		}*/
	}
	
	public int lancerDe(){
		return partie.lanceDe();
	}

	public void traitementFinDeTour() {
		
		for(Rue rue:rues) {
			if(rue.getQuartier().estComplet()) {
				String res;
				String couleurQuartier=rue.getQuartier().getCouleur();
				System.out.println("Le quartier "+couleurQuartier+ " est complet");
				System.out.println("Vous avez "+compte+"€ sur votre compte" );
				System.out.println("Une maison coûte : "+rue.getPrixMaison());
				System.out.println("Voulez vous construire une maison sur la rue : "+rue+" y/n");
				
				Scanner inputScanner = new Scanner(System.in);
				res = inputScanner.nextLine();
				if(res.equals("y")){
					construire(rue);
					System.out.println("Vous avez "+compte+"€ sur votre compte" );

				}
			}else {
				System.out.println("Vous n'avez pas de quartier complet, aucune action ne peut être menée !");
			}
		}
		System.out.println("Terminez votre tour (appuyez sur une touche)");
		String res;
		Scanner inputScanner = new Scanner(System.in);
		res = inputScanner.nextLine();
	}
	
	public void construire(Rue r) {
		r.construire();
	}
	
	public void afficheEtatJoueur() {
		System.out.println("Voici l'état de "+ nom);
		System.out.println("Compte "+ compte +" euros");
		
		System.out.println("===================");
		//Affichage rues
		if(rues.size()==0) {
			System.out.println("Aucune rue possédée");
		}else {
			System.out.println("Rue(s) possédée(s)");
			for(Rue rue: rues) {
				System.out.println(rue.toString());
			}
		}
		System.out.println("===================");
		//Affichage services
		if(services.size()==0) {
			System.out.println("Aucun service possédé");
		}else {
			System.out.println("Service(s) possédé(s)");
			for(Service service: services) {
				System.out.println(service.toString());
			}
		}
		System.out.println("===================");
		//Affichage gares
		if(gares.size()==0) {
			System.out.println("Aucune gare possédé");
		}else {
			System.out.println("Gare(s) possédé(s)");
			for(Gare gare: gares) {
				System.out.println(gare.toString());
			}
		}
		System.out.println("");
	}
	
	
	//Getters&Setters
	
	
	public int getNombreGares() {
		return nombreGares;
	}

	public void setNombreGares(int nombreGares) {
		this.nombreGares = nombreGares;
	}

	public int getNombreServices() {
		return nombreServices;
	}

	public void setNombreServices(int nombreServices) {
		this.nombreServices = nombreServices;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	public Partie getPartie() {
		return partie;
	}

	public void setPartie(Partie partie) {
		this.partie = partie;
	}

	/**
	 * @param estSur the estSur to set
	 */
	public void setEstSur(Case estSur) {
		this.estSur = estSur;
	}

	public int getCompte() {
		return compte;
	}

	public void setCompte(int compte) {
		this.compte = compte;
	}
	
	
	
	
}
