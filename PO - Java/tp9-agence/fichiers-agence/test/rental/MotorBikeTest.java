package rental;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MotorBikeTest {

	private MotorBike m1;
	private MotorBike m2;

    
	@Before 
	public void before() {
		//String brand, String model, int productionYear, int dailyRentalPrice, int cylinder
		this.m1 = new MotorBike("Kawazaki","Z800",1993,500,860);
		this.m2 = new MotorBike("Moubilou","Mobylette",1992,550,50);
	}
    
	@Test
	public void testMotorbike() {
		assertNotNull(this.m1);
		assertNotNull(this.m2);
	}

	@Test
	public void testGetCylinder() {
		assertEquals(this.m1.getCylinder(),860);
		assertEquals(this.m2.getCylinder(),50);
	}

	@Test
	public void testEquals() {
		MotorBike m3 = new MotorBike("Kawazaki","Z800",1993,500,860);
		MotorBike m4 = new MotorBike("Clio","Renault",1992,550,13);


		assertTrue(m1.equals(m3));
		assertFalse(m2.equals(m4));
		assertFalse(m1.equals(m4));
		assertFalse(m1.equals(new Object()));
	}
    // ---Pour permettre l'execution des tests ----------------------
    
    public static junit.framework.Test suite() {
	return new junit.framework.JUnit4TestAdapter(rental.MotorBikeTest.class);
    }

}
