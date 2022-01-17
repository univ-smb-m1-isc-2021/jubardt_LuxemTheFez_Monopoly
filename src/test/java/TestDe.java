



import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

import model.De;

public class TestDe{
	
	
	@Test
	public void testverifRes() {
		De de = new De(6);
		for(int i=0; i<1000;i++){
			int res = de.lancer();
			assertTrue(res<=6);
			assertTrue(res>0);
			System.out.println("Test numero "+i+" passe !");
		}
	}
}
