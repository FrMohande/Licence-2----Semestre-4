import org.junit.*;
import static org.junit.Assert.*;

import hanoi.util.*;

/**
 * Test class Disc
 * 
 * @author : Eddy El Khatib
 */


public class TowerTest {  

    @Test
    public void testTowerCreation() {
        Tower someTower = new Tower(5);
        assertNotNull(someTower);
    }
    
    @Test
    public void testGetCapacity() {
        Tower someTower = new Tower(5);
        assertEquals(someTower.getCapacity(), 5);
    }

    @Test
    public void testPileUp(){
        Tower someTower = new Tower(5);
        Disc someDisc = new Disc(3);
        Disc someDisc2 = new Disc(2);
        assertEquals(someTower.getNbDiscs(),0);
        someTower.pileUp(someDisc);
        assertEquals(someTower.getNbDiscs(),1);
        assertNotNull(someTower.getTop());
        someTower.pileUp(someDisc2);
        assertEquals(someTower.getTop(),someDisc2);
        assertEquals(someDisc2.getDessous(), someDisc);
    }

    @Test
    public void testPileDown(){
        Tower someTower = new Tower(5);
        Disc someDisc = new Disc(3);
        Disc someDiscRecup = null;
        someTower.pileUp(someDisc);
        someDiscRecup = someTower.pileDown();
        assertNotNull(someDiscRecup);
        assertEquals(someDiscRecup, someDisc);
        assertNull(someTower.getTop());
        assertEquals(someTower.getNbDiscs(),0);
    }

    @Test
    public void testIsFull(){
        Tower someTower = new Tower(3);
        Disc someDisc = new Disc(3);
        Disc someDisc2 = new Disc(2);
        Disc someDisc3 = new Disc(1);
        someTower.pileUp(someDisc);
        assertFalse(someTower.isFull());
        someTower.pileUp(someDisc2);
        assertFalse(someTower.isFull());
        someTower.pileUp(someDisc3);
        assertTrue(someTower.isFull());
    }

    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(TowerTest.class);
    }

}
