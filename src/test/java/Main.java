


import model.Joueur;

public class Main {
	
	
	@Test
	public void verifargent() {
		Joueur Theo = new Joueur("Theo", null, null);

		assertEquals(Theo.getCompte(), 100000);
	}
}
