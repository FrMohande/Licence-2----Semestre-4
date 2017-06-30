package battleship;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import battleship.Position;

/**
 * @author : Eddy El Khatib
 */

public class PositionTest {


    @Test
	public void testPosition(){
		Position MaPos = new Position(1,2);
		assertNotNull(MaPos);
    }


    @Test
	public void testGetX(){
		Position MaPos = new Position(1,2);
		assertEquals(MaPos.getX(),1);
    }


    @Test
	public void testGetY(){
		Position MaPos = new Position(1,2);
		assertEquals(MaPos.getY(),2);
    }

    @Test
	public void testEquals(){
		Position somePos1 = new Position(10,10);
		Position somePos2 = new Position(10,10);
		Position somePos3 = new Position(10,5);
		assertTrue(somePos1.equals((Object) somePos2));
		assertFalse(somePos1.equals((Object) somePos3));
		assertFalse(somePos1.equals(new Object()));
    }


public static junit.framework.Test suite() {
	return new junit.framework.JUnit4TestAdapter(battleship.PositionTest.class);
    }
}