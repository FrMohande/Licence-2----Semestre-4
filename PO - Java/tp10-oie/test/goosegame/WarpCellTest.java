package goosegame ;

/**
 * @author : Mohand Outioua
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WarpCellTest {
	private Cell warpcell ;

	@Before
	public void before() {
		this.warpcell = new WarpCell(6,12) ;
	}
	@Test 
	public void testWarpCell() {
		assertNotNull(this.warpcell) ;

	}
	@Test
	public void testHandleMove() {
		assertEquals(this.warpcell.handleMove(10),12) ;
	}
	@Test
	public void testcanBeLeft() {
		assertTrue(this.warpcell.canBeLeft()) ;	
	}
	public void testGetPlayer() {
		Player p1 = new Player("Outioua") ;

		this.warpcell.welcomePlayer(p1) ;
		assertEquals(this.warpcell.getPlayer().toString(),"Outioua") ;	
	}
	public void testIsBusy() {
		Player p1 = new Player("Elkhatib") ;
		assertFalse(this.warpcell.isBusy()) ;
		this.warpcell.welcomePlayer(p1) ;
		assertTrue(this.warpcell.isBusy()) ;

	}
    // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(goosegame.WarpCellTest.class);
    }
}
