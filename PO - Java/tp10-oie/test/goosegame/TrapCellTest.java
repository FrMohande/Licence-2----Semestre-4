package goosegame ;

/**
 * @author : Eddy El Khatib
 */

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TrapCellTest {
	private Cell trapcell ; 
	
	@Before
	public void before() {
		this.trapcell = new TrapCell(31) ; 	
	}
	@Test
	public void testTrapCell() {
		assertNotNull(trapcell) ;	
	}
	public void testcanBeLeft() {
		assertFalse(trapcell.canBeLeft()) ;	
		assertFalse(trapcell.canBeLeft()) ;	
		assertFalse(trapcell.canBeLeft()) ;	
		assertFalse(trapcell.canBeLeft()) ;	
		assertFalse(trapcell.canBeLeft()) ;	
	}
	public void testgetindex() {
		assertEquals(trapcell.getIndex(),31) ;		
	}
	public void testhandlemove() {
		assertEquals(trapcell.getIndex(),31) ; 	
	}
	public void testGetPlayer() {
		Player p1 = new Player("Outioua") ;

		this.trapcell.welcomePlayer(p1) ;
		assertEquals(this.trapcell.getPlayer().toString(),"Outioua") ;	
	}
	public void testIsBusy() {
		Player p1 = new Player("Elkhatib") ;
		assertFalse(this.trapcell.isBusy()) ;
		this.trapcell.welcomePlayer(p1) ;
		assertTrue(this.trapcell.isBusy()) ;

	}



	// ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(goosegame.TrapCellTest.class);
    }
}
