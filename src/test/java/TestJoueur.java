import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

import model.Joueur;

public class TestJoueur{
	
	
	@Test
	public void testVerifArgent() {
		Joueur Theo = new Joueur("Theo", null, null);

		assertEquals(Theo.getCompte(), 1000000000);
	}
	
	@Test
	public void testVerifNom() {
		Joueur Theo = new Joueur("Theo", null, null);

		assertEquals(Theo.getNom(), "Theo");
	}
	
	@Test
	public void testVerifPayer() {
		Joueur Theo = new Joueur("Theo", null, null);
		
		assertEquals(Theo.payer(10), true);
	}
	
	@Test
	public void testVerifPossedeSomme() {
		Joueur Theo = new Joueur("Theo", null, null);
		
		assertEquals(Theo.possedeSomme(100000000), true);
	}
	
}
