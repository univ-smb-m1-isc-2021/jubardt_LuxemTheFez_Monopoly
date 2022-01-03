package model;

import java.util.ArrayList;
import java.util.Iterator;

public class Quartier {
	private String couleur;
	private boolean estComplet;
	private ArrayList<CasePropriete> listeCases;
	
	public Quartier(String couleur, ArrayList<CasePropriete> listeCases) {
		this.couleur = couleur;
		this.listeCases = listeCases;
		this.estComplet=false;
	}
	
	public boolean estComplet(){
		boolean res = true;
		if (!estComplet) { 
			estComplet = true;
			Joueur proprio = listeCases.get(0).getProprietaire();
			for(CasePropriete cp:listeCases) {
				if (!cp.getProprietaire().equals(proprio)) {
					res=false;
					estComplet=false;
				}
			}
		}
		return res;
	}
	
	public void setQuartierComplet() {
			for(CasePropriete cp:listeCases) {
				cp.setLoyer(cp.getLoyer()*2);
				cp.changementEtat();
		}
	}
	
}
