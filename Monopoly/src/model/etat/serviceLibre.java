package model.etat;

import java.security.Provider.Service;

import model.CasePropriete;
import model.Joueur;

public class serviceLibre extends EtatCase {
	
	
	public serviceLibre(CasePropriete caseAsso) {
		super(caseAsso);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Etat: service libre";
	}
	
	public void traitementJoueur(Joueur joueur) {
		if (!estProprietaire(joueur)) {
			int loyer = calculLoyerService(joueur.lancerDe());
			if(joueur.possedeSomme(loyer)) {
				joueur.payer(loyer);
				caseAsso.payerProprietaire(loyer);
			}else{
				System.out.println("Perdu");
			}
		}
	}
	
	public int calculLoyerService(int resDe) {
		int nbServices = caseAsso.getProprietaire().getNombreServices();
		int loyer = caseAsso.getLoyer();
		if (nbServices==1) {
			return 4*resDe*loyer;
			
		}
		return 10*resDe*loyer;
		
	}
}
