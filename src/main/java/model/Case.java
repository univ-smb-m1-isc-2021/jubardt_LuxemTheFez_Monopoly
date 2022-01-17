package model;

public class Case {
	protected String nom;

	protected Case suivante;
	protected Joueur visiteur;

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


	
	public void traitementJoueur(Joueur j) {
		System.out.print("le joueur "+j.getNom() +" est sur la case"+ nom);
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

	
	public void setSuivante(Case suivante) {
		this.suivante = suivante;
	}


	/**
	 * @return the visiteur
	 */
	public Joueur getVisiteur() {
		return visiteur;
	}


	/**
	 * @param visiteur the visiteur to set
	 */
	public void setVisiteur(Joueur visiteur) {
		this.visiteur = visiteur;
	}


}
