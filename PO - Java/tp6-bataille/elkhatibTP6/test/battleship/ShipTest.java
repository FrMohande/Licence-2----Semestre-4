package battleship;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import battleship.Ship;

/**
 * @author : Mohand Outioua
 */

public class ShipTest {

    @Test
	public void testgetLife() {
		Ship someShip = new Ship(10);
		assertNotNull(someShip);
    }

    @Test
	public void testisSunk() {
		Ship someShip = new Ship(1);
		assertEquals(someShip.isSunk(),false);
		someShip.hitted();
		assertEquals(someShip.isSunk(),true);
    }

    @Test
	public void testHit() {
		Ship someShip = new Ship(6);
		someShip.hitted();
		someShip.hitted();
		assertEquals(someShip.getLife(),4);
    }

    @Test 
	public void testtoString() {
		Ship someShip = new Ship(10);
		assertEquals(someShip.toString(),"10");
    }
    
    public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(battleship.ShipTest.class);
    }
}