package battleship;

import org.junit.*;
import static org.junit.Assert.*;
import battleship.*;
import battleship.direction.*;

/**
 * @author : Eddy El Khatib
 */


public class SeaTest {
    @Test
	public void testSea() {
		Sea someSea = new Sea(5,5);	
		assertNotNull(someSea);
    }

	@Test
	public void testPlace(){
		Sea someSea = new Sea(1,1);
		try {
			someSea.placeShip(new Ship(1), new Position(2, 2), new EastDirection());
		} catch (Exception e) {
			assertTrue(e instanceof IllegalStateException);
		}
		someSea.placeShip(new Ship(1), new Position(0, 0), new EastDirection());
		try {
			someSea.placeShip(new Ship(1), new Position(0, 0), new EastDirection());
		} catch (Exception e) {
			assertTrue(e instanceof IllegalStateException);
		}
	}

	@Test
	public void testShoot() {
	    Sea someSea = new Sea(5,5);
	    someSea.placeShip(new Ship(2), new Position(0, 0), new EastDirection());
	    assertEquals(someSea.shoot(new Position(0,0)),Answer.HIT);
	    assertEquals(someSea.shoot(new Position(0,0)),Answer.MISSED);
	    assertEquals(someSea.shoot(new Position(0,1)),Answer.MISSED);
	    assertEquals(someSea.shoot(new Position(1,0)),Answer.SUNK);
	    try{
	    	someSea.shoot(new Position(5,5));
	    }catch(Exception e){
	    	assertTrue(e instanceof ArrayIndexOutOfBoundsException);
	    }
	}
	
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(SeaTest.class);
	    }
	}


