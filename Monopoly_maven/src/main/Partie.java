package main;
import java.util.ArrayList;
import java.util.Collections;

import model.De;
import model.Joueur;
import model.Plateau;


public class Partie {
	private ArrayList<Joueur> participants;
	private Plateau plateau;
	private ArrayList<De> des;

	
	public Partie(ArrayList<Joueur> participants,Plateau plateau, ArrayList<De>des) {
		this.participants = participants;
		this.plateau = plateau;
		this.des = des;
	}
	
	
	public int lanceDes() {
		int res = 0;
		for(De de:des) {
			res += de.lancer();
		}
		return res;
	}
	
	public int lanceDe() {
		return des.get(0).lancer();
	}
	
	//Melange la liste des joueurs pour définir l'ordre de jeu
	public Joueur choixOrdreJeu(){
		Collections.shuffle(participants);
		return participants.get(0);
	}
}