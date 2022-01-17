package main;

import java.util.ArrayList;
import java.util.Arrays;

import model.Joueur;
import model.Partie;

public class Main {

	public static void main(String[] args) {
		
		Joueur luc = new Joueur("Luc", null, null);
		Joueur theo = new Joueur("Théo", null, null);
		Joueur paul = new Joueur("Paul", null, null);

		ArrayList<Joueur> listeJoueur = new ArrayList<Joueur>(Arrays.asList(luc,theo,paul));
		
		Partie partie = new Partie(listeJoueur);
		
		luc.setPartie(partie);
		theo.setPartie(partie);
		paul.setPartie(partie);
		
		partie.lancerPartieDemo();
	}

}
