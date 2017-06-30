import org.junit.*;
import static org.junit.Assert.*;

import example.util.*;   
import example.Robot;

public class monBoxTest {	

    @Test
    public void testBoxCreation() {
        Box someBox = new Box(10);
        assertNotNull(someBox);
    }
    
    @Test
    public void donnePoids() {
        Box someBox = new Box(10);
        assertEquals(someBox.getWeight(),10);
    }

    @Test
    public void testCarry(){
        Robot someRobot = new Robot();
        Box someBox = new Box(10);
        assertFalse(someRobot.carryBox());
        someRobot.take(someBox);
        assertTrue(someRobot.carryBox());
    }

    @Test
    public void testTake(){
        Robot someRobot = new Robot();
        Box someBox = new Box(10);
        Box someBox2 = new Box(15);

        someRobot.take(someBox);
        assertTrue(someRobot.carryBox());
        try {
            someRobot.take(someBox);
        }catch (IllegalStateException e){
            assertTrue(e instanceof IllegalStateException);
        }   
        
    }

    @Test
    public void testputOn(){
        Robot someRobot = new Robot();
        Robot someRobot2 = new Robot();
        Box someBox = new Box(10);
        Box someBox2 = new Box(9);
        Box someBox3 = new Box(8);
        Box someBox4 = new Box(10);
        ConveyerBelt someConv = new ConveyerBelt(1);
        ConveyerBelt someConv2 = new ConveyerBelt(10);
        //test si pas de box dans les mains
        assertFalse(someRobot.carryBox());
        someRobot.putOn(someConv);
        assertFalse(someRobot.carryBox());
        //test si la box est trop lourde
        someRobot.take(someBox);
        someRobot.putOn(someConv);
        assertTrue(someRobot.carryBox());
        //test si la conv est full (les premiere seconde et troisième poses fonctionnent dans ce cas là, pas la troisième la capacité étant de 2 sur un tapis)
        someRobot.putOn(someConv2);
        assertFalse(someRobot.carryBox());
        someRobot2.putOn(someConv2);
        assertFalse(someRobot2.carryBox());
        someRobot.take(someBox3);
        someRobot.putOn(someConv2);
        someRobot.take(someBox4);
        someRobot.putOn(someConv2);
        assertTrue(someRobot.carryBox());

    }



    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(monBoxTest.class);
    }

}
