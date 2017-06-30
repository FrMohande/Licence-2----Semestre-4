//String brand, String model, int productionYear, int dailyRentalPrice, int nbPlaces

package rental;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CarTest {
	private Car car1;
	private Car car2;
	
	@Before
	public void before() {
		this.car1 = new Car("brand1","model1",2015,100,4);
		this.car2 = new Car("brand2","model2",2000,200,3);
	}
	@Test
	public void CarTest() {
		assertNotNull(this.car1);
		assertNotNull(this.car2);
	}
	@Test
	public void testGetNbPlace() {
		assertEquals(this.car1.getNbPlaces(),4);
		assertEquals(this.car2.getNbPlaces(),3);		
	}
	@Test
	public void testEquals() {
		Car car3 = new Car("brand1","model1",2015,100,4);
		Car car4 = new Car("brand1","model1",2015,200,7);

		assertTrue(car1.equals(car3));
		assertFalse(car1.equals(car2));
		assertFalse(car1.equals(car4));
		assertFalse(car1.equals(new Object()));	
	}
    // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
	return new junit.framework.JUnit4TestAdapter(rental.CarTest.class);
    }

}

