package model;

import java.security.SecureRandom;

public class De {
	private int nbFace;
	private SecureRandom random;
	
	public De(int nbFace) {
		this.nbFace = nbFace;
		random = new SecureRandom(); // Compliant for security-sensitive use cases
	}
	

	public int lancer() {
		int randomNum = random.nextInt(nbFace)+1;
		//int randomNum = ThreadLocalRandom.current().nextInt(1, nbFace + 1);
		return randomNum;
	}
}
