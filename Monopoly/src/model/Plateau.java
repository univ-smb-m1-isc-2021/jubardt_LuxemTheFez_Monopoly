package model;

import java.util.ArrayList;

public class Plateau {
	private ArrayList<Quartier> listeQuartiers;
	private Case caseDepart;
	
	
	public Plateau(ArrayList<Quartier> listeQuartiers, Case caseDepart) {
		super();
		this.listeQuartiers = listeQuartiers;
		this.caseDepart = caseDepart;
	}


	
	//Getter&Setter 
	public ArrayList<Quartier> getListeQuartiers() {
		return listeQuartiers;
	}


	public void setListeQuartiers(ArrayList<Quartier> listeQuartiers) {
		this.listeQuartiers = listeQuartiers;
	}


	public Case getCaseDepart() {
		return caseDepart;
	}


	public void setCaseDepart(Case caseDepart) {
		this.caseDepart = caseDepart;
	}
}
