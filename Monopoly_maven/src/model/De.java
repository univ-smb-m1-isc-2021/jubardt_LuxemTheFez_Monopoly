package model;

import java.util.concurrent.ThreadLocalRandom;

public class De {
	private int nbFace;
	
	public De(int nbFace) {
		this.nbFace = nbFace;
	}
	

	public int lancer() {
		int randomNum = ThreadLocalRandom.current().nextInt(0, nbFace + 1);
		return randomNum;
	}
}
