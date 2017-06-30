package image.color;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import image.color.GrayColor;


/**
 * @author : Mohand Outioua
 */

public class GrayColorTest {


	@Test
	public void testGrayColor(){
		GrayColor someGrayColor = new GrayColor(10);
		assertNotNull(someGrayColor);
	}


    @Test
	public void testGetLevel(){
		GrayColor someGrayColor = new GrayColor(10);
		assertEquals(someGrayColor.getLevel(),10);
    }


    @Test
	public void testEquals(){
		GrayColor someGrayColor = new GrayColor(10);
		GrayColor someGrayColor2 = new GrayColor(10);
		GrayColor someGrayColor3 = new GrayColor(5);
		assertTrue(someGrayColor.equals((Object) someGrayColor2));
		assertFalse(someGrayColor.equals((Object) someGrayColor3));
    }

     public static junit.framework.Test suite() {
	return new junit.framework.JUnit4TestAdapter(image.color.GrayColorTest.class);
    }

}