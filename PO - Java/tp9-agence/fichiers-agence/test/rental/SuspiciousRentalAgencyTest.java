package rental;

import static org.junit.Assert.*;
import rental.*;
import org.junit.Test;
import org.junit.Before;

public class SuspiciousRentalAgencyTest {
	private RentalAgency agency ;

	@Before
	public void before() {
		this.agency = new SuspiciousRentalAgency() ;
	}

	@Test
	public void rentPriceTest(){
		Client c1 = new Client("Outioua",20) ;
		Client c2 = new Client("Amelie", 25 ) ;
		Vehicle v = new Vehicle("brand1","model1",2000,200);
		this.agency.addVehicle(v) ;
		assertEquals(this.agency.rentVehicule(c2,v), 200f,0f);
		this.agency.returnVehicle(c2);
		assertEquals(this.agency.rentVehicule(c1,v), 220f,0f);
	}
    
    // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
	return new junit.framework.JUnit4TestAdapter(rental.SuspiciousRentalAgencyTest.class);
    }

}
