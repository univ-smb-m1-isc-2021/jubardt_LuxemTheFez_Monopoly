package model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Partie {
	private ArrayList<Joueur> participants;
	private Plateau plateau;
	private ArrayList<De> des;

	
	public Partie(ArrayList<Joueur> participants) {
		this.participants = participants;
		initPartieDemo();
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
	
	//Melange la liste des joueurs pour definir l'ordre de jeu
	public Joueur choixOrdreJeu(){
		Collections.shuffle(participants);
		return participants.get(0);
	}
	
	public void lancerPartieDemo() {
		ArrayList<Integer> resDemoDes = new ArrayList<Integer>(Arrays.asList(2,2,3,3,6));
	
		int compte = 0;
		int resDe = 0;
		boolean fini = false;
		
		//Affectation des proprietes pour demo 
		Rue p = (Rue) plateau.getCaseDepart().getSuivante();
		Service eaux = (Service) p.getSuivante().getSuivante();
		Gare lyon = (Gare) eaux.getSuivante();
		Gare Mont = (Gare) lyon.getSuivante();
		Gare Nord = (Gare) Mont.getSuivante();
		
		participants.get(0).ajouterProprieteR(p);
		p.setPropritaire(participants.get(0));
		p.changementEtat();
		
		participants.get(1).ajouterProprieteS(eaux);
		eaux.setPropritaire(participants.get(1));
		eaux.changementEtat();
		
		participants.get(2).ajouterProprieteG(lyon);
		lyon.setPropritaire(participants.get(2));
		lyon.changementEtat();
		participants.get(2).ajouterProprieteG(Mont);
		Mont.setPropritaire(participants.get(2));
		Mont.changementEtat();
		participants.get(2).ajouterProprieteG(Nord);
		Nord.setPropritaire(participants.get(2));
		Nord.changementEtat();
		
		participants.get(1).setNombreServices(1);
		participants.get(2).setNombreGares(3);
		
		while(!fini) {
			if(resDe>4) {
				fini = true;
			}else {
				for(Joueur joueur: participants) {
					if(resDe>4) {
						fini = true;
						break;
					}else {
						System.out.println("============================================");
						System.out.println("=======TOUR DE "+joueur.getNom().toUpperCase() +" ========");
						System.out.println("============================================\n");
						if(compte==0) {
							joueur.setEstSur(plateau.getCaseDepart());
						}
						joueur.afficheEtatJoueur();
						System.out.println("Début du Tour");
						System.out.println("==============");
						System.out.println("Le lancer de dé donne le résultat "+ resDemoDes.get(resDe));
						joueur.avancer(resDemoDes.get(resDe));
						joueur.joueTour();
						joueur.afficheEtatJoueur();
						joueur.traitementFinDeTour();
						
						resDe+=1;
					}
				}
				compte+=1;
			}
		}
		System.out.println("============================================");
		System.out.println("==============FIN DE LA DEMO ===============");
		System.out.println("============================================\n");
		
	}
	
	public void initPartieDemo() {
	
		Case caseDepart = new Case("Case départ", null);
		Gare gareDuNord = new Gare("Gareé du nord", caseDepart, 500, 500);
		Gare gareMontparnasse = new Gare("gare Montparnasse", gareDuNord, 464, 285);
		Gare gareDeLyon = new Gare("gare de lyon", gareMontparnasse , 350, 745);
		Service serviceDesEaux = new Service("service des eaux", gareDeLyon , 650, 450);
		Rue rueDeLaPaix = new Rue("rue de la paix", serviceDesEaux , 300, 300, 500, null); 
		Rue pigale = new Rue("rue de pigale", rueDeLaPaix, 300, 300, 500, null);

		
		caseDepart.setSuivante(pigale);
		
		ArrayList<Rue> qbListe = new ArrayList<Rue>(Arrays.asList(pigale,rueDeLaPaix)); 
		
		Quartier quartierBleu = new Quartier("bleu",qbListe);
		rueDeLaPaix.setQuartier(quartierBleu);
		pigale.setQuartier(quartierBleu);
		
		this.plateau = new Plateau(caseDepart);
		this.des = new ArrayList<De>(Arrays.asList(new De(6),new De(6)));
	}
}
