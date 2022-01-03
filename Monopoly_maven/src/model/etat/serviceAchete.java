package model.etat;

import model.CasePropriete;

public class serviceAchete extends EtatCase {

	public serviceAchete(CasePropriete caseAsso) {
		super(caseAsso);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public String toString() {
		return "Etat: est acheté";
	}
}
