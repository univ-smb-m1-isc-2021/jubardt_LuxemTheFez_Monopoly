package model;

import java.util.ArrayList;

public class Plateau {
	private Case caseDepart;
	
	
	public Plateau(Case caseDepart) {
		this.caseDepart = caseDepart;
	}


	
	//Getter&Setter 

	public Case getCaseDepart() {
		return caseDepart;
	}


	public void setCaseDepart(Case caseDepart) {
		this.caseDepart = caseDepart;
	}
}
