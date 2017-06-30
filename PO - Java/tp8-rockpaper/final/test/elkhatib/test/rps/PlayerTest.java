package rps ;
import org.junit.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import rps.strategy.*;
import rps.*;
public class PlayerTest {
	@Test 
	public void testPlayerTest() {
		Player somePlayer = new Player("Outioua",new StrategyAlea() )	;
		assertNotNull(somePlayer) ;
	}
	@Test
	public void testGetName() {
		Player somePlayer = new Player("Outioua", new StrategyAlea() ) ;
		assertEquals(somePlayer.getName(),"Outioua") ;

	}
	@Test
	public void testGetAddScore() {
		Player somePlayer = new Player("Outioua", new StrategyAlea() ) ;
		assertEquals(somePlayer.getScore(),0);
		somePlayer.addPoints(10) ;
		assertEquals(somePlayer.getScore(),10) ;
	}

	@Test
	public void testPlay() {
		Player somePlayer = new Player("Outioua", new StrategyRock()) ;
		assertEquals(somePlayer.play(),Shape.ROCK) ;
		assertEquals(somePlayer.play(),Shape.ROCK) ;
	}

	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(rps.PlayerTest.class);
    }
}