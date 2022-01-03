package model;

import java.util.ArrayList;

public class Joueur {
	private String nom;
	private int compte;
	private int nombreGares;
	private int nombreServices;
	private Case estSur;
	private ArrayList<CasePropriete> proprietees;
	private Partie partie;
	
	public Joueur(String nom,Case estSur,Partie partie){
		this.nom = nom;
		this.estSur = estSur;
		this.partie = partie;
		nombreGares = 0;
		nombreServices = 0;
		this.compte = 100000;
		this.proprietees = new ArrayList<>();
	}
	
	public void suivant(int nombre) {
		estSur = estSur.suivant(nombre);
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
	
	public void ajouterPropriete(CasePropriete cp) {
		proprietees.add(cp);
	}
	
	public int lancerDe(){
		return partie.lanceDe();
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

	public int getCompte() {
		return compte;
	}

	public void setCompte(int compte) {
		this.compte = compte;
	}
	
	
}
