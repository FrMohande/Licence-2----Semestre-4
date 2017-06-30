package goosegame ;

/**
 * @author : Eddy El Khatib
 */

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class GooseBoardTest {
	private Board gooseBoard ;

	@Before
	public void before() {
		this.gooseBoard = new GooseBoard() ;	
	}
	@Test
	public void testnormalcell() {
		assertNotNull(this.gooseBoard) ;	
	}
	@Test
	public void testNbCells(){
		assertEquals(this.gooseBoard.getNbOfCells(),63);
	}
	@Test
	public void testGetCell(){
		assertTrue(this.gooseBoard.getCell(0) instanceof StartCell);
		assertTrue(this.gooseBoard.getCell(1) instanceof NormalCell);
		assertTrue(this.gooseBoard.getCell(9) instanceof GooseCell);
		assertTrue(this.gooseBoard.getCell(31) instanceof TrapCell);
		assertTrue(this.gooseBoard.getCell(19) instanceof WaitCell);
		assertTrue(this.gooseBoard.getCell(58) instanceof WarpCell);	
	}

    // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(goosegame.GooseBoardTest.class);
    }
}
