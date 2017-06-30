package goosegame ;

/**
 * @author : Mohand Outioua
 */

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;



public class StartCellTest {
	private Cell startcell ;

	@Before
	public void before() {
		this.startcell = new StartCell(0) ;
	} 
	@Test	
	public void testStartCell() {
		assertNotNull(startcell) ;
	}
	@Test	
	public void testcanBeLeft() {
		assertTrue(this.startcell.canBeLeft()) ;
	}
	@Test
	public void testgetindex() {
		assertEquals(this.startcell.getIndex(),0) ;
	}
	@Test
	public void testisBusy() {
		assertFalse(this.startcell.isBusy()) ;
	}



    // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(goosegame.StartCellTest.class);
    }
}
