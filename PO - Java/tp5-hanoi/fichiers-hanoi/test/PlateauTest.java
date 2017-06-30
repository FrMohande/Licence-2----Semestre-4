import org.junit.*;
import static org.junit.Assert.*;

import hanoi.*;
import hanoi.util.*;

/**
 * Test class plateau
 * 
 * @author : Eddy El Khatib
 */


public class PlateauTest {	

    @Test
    public void testPlateauCreation() {
        Plateau somePlateau = new Plateau(5);
        assertNotNull(somePlateau);
    }
    
    @Test
    public void testMoveCanMove() {
        Plateau somePlateau = new Plateau(5);
        assertTrue(somePlateau.canMove(0,1));
        somePlateau.move(0,1);
        assertFalse(somePlateau.canMove(0,1));
        assertFalse(somePlateau.canMove(2,1));
    }

    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(PlateauTest.class);
    }

}
