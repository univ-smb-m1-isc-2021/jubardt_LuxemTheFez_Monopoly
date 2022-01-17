



import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Assertions.*;

import model.Joueur;

public class TestJoueur{
	
	
	@Test
	public void testverifargent() {
		Joueur Theo = new Joueur("Theo", null, null);

		assertEquals(Theo.getCompte(), 100000);
	}
}
