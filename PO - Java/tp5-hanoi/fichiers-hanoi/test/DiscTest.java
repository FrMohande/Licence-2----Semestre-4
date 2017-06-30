import org.junit.*;
import static org.junit.Assert.*;

import hanoi.util.Disc;

/**
 * Test class Disc
 * 
 * @author : Eddy El Khatib
 */


public class DiscTest {  

    @Test
    public void testDiscCreation() {
        Disc someDisc = new Disc(5);
        assertNotNull(someDisc);
    }
    
    @Test
    public void testGetSetDessous() {
        Disc someDisc = new Disc(3);
        Disc someDisc2 = new Disc(4);
        assertNull(someDisc.getDessous());
        someDisc.setDessous(someDisc2);
        assertNotNull(someDisc.getDessous());
    }

    @Test
    public void testGetTaille(){
        Disc someDisc = new Disc(3);
        assertEquals(someDisc.getTaille(),3);
    }

    @Test
    public void testEstPlusPetit(){
        Disc someDisc = new Disc(3);
        Disc someDisc2 = new Disc(4);
        assertFalse(someDisc2.estPlusPetit(someDisc));
        assertTrue(someDisc.estPlusPetit(someDisc2));
    }

    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(DiscTest.class);
    }

}
