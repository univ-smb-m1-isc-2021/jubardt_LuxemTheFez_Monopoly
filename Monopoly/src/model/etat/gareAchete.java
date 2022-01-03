package model.etat;

import model.CasePropriete;
import model.Joueur;

public class gareAchete extends EtatCase {

	public gareAchete(CasePropriete caseAsso) {
		super(caseAsso);
		// TODO Auto-generated constructor stub
	}
	
	public void traitementJoueur(Joueur joueur) {
		if (!estProprietaire(joueur)) {
			int loyer = calculLoyerGare();
			if(joueur.possedeSomme(loyer)) {
				joueur.payer(loyer);
				caseAsso.payerProprietaire(loyer);
			}else{
				System.out.println("Perdu");
			}
		}
	}
	
	public int calculLoyerGare() {
		int nbGares = caseAsso.getProprietaire().getNombreServices();
		int loyer = caseAsso.getLoyer();
		return nbGares*loyer;
	}
	
	@Override
	public String toString() {
		return "Etat: gare acheté";
	}

}
