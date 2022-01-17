package model;

import java.util.ArrayList;
import java.util.Iterator;

import model.etat.estConstructible;

public class Quartier {
	private String couleur;
	private boolean estComplet;
	private ArrayList<Rue> listeRues;
	
	public Quartier(String couleur, ArrayList<Rue> listeRues) {
		this.couleur = couleur;
		this.listeRues = listeRues;
		this.estComplet=false;
	}
	
	public boolean estComplet(){
		boolean res = true;
		if (!estComplet) { 
			estComplet = true;
			Joueur proprio = listeRues.get(0).getProprietaire();
			if(proprio==null) {
				res = false;
				estComplet=false;
			}
			for(Rue cp:listeRues) {
				if(cp.getProprietaire()==null) {
					res = false;
					estComplet=false;

				}else if (!cp.getProprietaire().equals(proprio)) {
					res=false;
					estComplet=false;
				}
			}
		}

		return res;
	}
	
	public void setQuartierComplet() {
			for(Rue cp:listeRues) {
				cp.setLoyer(cp.getLoyer()*2);
				cp.setEtat(new estConstructible(cp));
		}
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
	
}
