package goosegame ;

/**
 * @author : Mohand Outioua
 */

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class NormalCellTest {
	private Cell normalcell ;

	@Before
	public void before() {
		this.normalcell = new NormalCell(20) ;	
	}
	@Test
	public void testnormalcell() {
		assertNotNull(this.normalcell) ;	
	}
	@Test
	public void testcanBeLeft() {
		assertTrue(this.normalcell.canBeLeft()) ;	
	}
	@Test
	public void testgetindex() {
		assertEquals(this.normalcell.getIndex(),20) ;
	}
	@Test	
	public void testhandleMove() {
		assertEquals(this.normalcell.handleMove(20),20) ;
	}
	@Test
	public void testGetPlayer() {
		Player p1 = new Player("Outioua") ;
		this.normalcell.welcomePlayer(p1) ;
		assertEquals(this.normalcell.getPlayer().toString(),"Outioua") ;	
	}
	@Test
	public void testIsBusy() {
		Player p1 = new Player("Elkhatib") ;
		assertFalse(this.normalcell.isBusy()) ;
		this.normalcell.welcomePlayer(p1) ;
		assertTrue(this.normalcell.isBusy()) ;

	}




    // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(goosegame.NormalCellTest.class);
    }
}
