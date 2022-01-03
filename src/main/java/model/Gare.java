package model;

import java.util.ArrayList;

public class Gare extends CasePropriete {

	
	public Gare(String nom, Quartier quartier, Case suivante, Joueur proprietaire, int PrixAchat, int loyer) {
		super(nom, quartier, suivante, PrixAchat, loyer);
	}

}
