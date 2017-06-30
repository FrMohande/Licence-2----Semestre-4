package rental;

import static org.junit.Assert.*;
import java.util.NoSuchElementException;
import org.junit.Test;
import org.junit.Before;
import rental.RentalAgency;
public class RentalAgencyTest {
	private RentalAgency agency;
	private Vehicle v1;
	private Vehicle v2;
	private Client c ;
	@Before
	public void before() {
		this.c = new Client("Outioua",20) ;
		this.agency = new RentalAgency() ;
		this.v1 = new Vehicle("brand1","model1",2000,200);
		this.v2 = new Vehicle("brand2","model2",2000,250) ;
	}
	@Test
	public void testAgency(){
		assertNotNull(this.agency);
	}
	@Test
	public void testSelect() {
		this.agency.addVehicle(this.v1) ;
		assertTrue((this.agency.select(new PriceCriterion(225)).contains(this.v1))) ;
	}

	@Test
	public void rentVehicule() {
		Client c2 = new Client("Eddy",26) ;
		this.agency.addVehicle(this.v1) ;
		assertEquals((this.agency.rentVehicule(this.c,this.v1)),200f, 0f) ;
		try{
			this.agency.rentVehicule(c2, this.v1);
		}catch(Exception e){
			assertTrue(e instanceof IllegalStateException);
		}
		try{
			this.agency.rentVehicule(c2, this.v2);
		}catch(Exception e){
			assertTrue(e instanceof NoSuchElementException);
		}
		this.agency.addVehicle(this.v2);
		try{
			this.agency.rentVehicule(this.c, this.v2);
		}catch(Exception e){
			assertTrue(e instanceof IllegalStateException);
		}
	}
	@Test
	public void testHasRentedAVehicle() {
		Client c2 = new Client("Eddy",22) ;
		this.agency.addVehicle(this.v1) ;
		this.agency.rentVehicule(this.c,this.v1) ; 
		assertTrue(this.agency.hasRentedAVehicle(this.c)) ;
		assertFalse(this.agency.hasRentedAVehicle(c2)) ;
	}
	@Test
	public void testIsRented() {	
		this.agency.addVehicle(this.v1) ;
		this.agency.addVehicle(this.v2) ;
		this.agency.rentVehicule(this.c,this.v1) ; 
		assertTrue(this.agency.isRented(this.v1)) ;
		assertFalse(this.agency.isRented(this.v2)) ;
	}
	@Test
	public void testAllRentedVehicles() {
		this.agency.addVehicle(this.v1) ;
		this.agency.rentVehicule(this.c,this.v1) ; 
		assertTrue(this.agency.allRentedVehicles().contains(this.v1)) ;
	}
	@Test
	public void testReturnVehicle() {
		this.agency.addVehicle(this.v1) ;
		this.agency.rentVehicule(this.c,this.v1) ; 
		this.agency.returnVehicle(this.c) ;
		assertFalse(this.agency.hasRentedAVehicle(this.c)) ;
		assertFalse(this.agency.isRented(this.v1));
	}
    
    // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
	return new junit.framework.JUnit4TestAdapter(rental.RentalAgencyTest.class);
    }

}
