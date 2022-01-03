package model;

public class Case {
	private String nom;

	private Case suivante;
	private Joueur visiteur;

	public Case(String nom, Case suivante) {
		this.nom = nom;
		this.suivante = suivante;
		this.visiteur = null;
	}
	
	
	public Case suivant(int avancement) {
		Case suiv = this;
		for(int i = 0;i<avancement;i++) {
			suiv = suiv.suivante;
		}
		return suiv;
	}


	
	
	
	
	
	//////////////////////////////
	///////////GETTERS////////////
	//////////////////////////////

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}




	/**
	 * @return the suivante
	 */
	public Case getSuivante() {
		return suivante;
	}



	
	
	
	
	
	
	
	
	

	
	
}
