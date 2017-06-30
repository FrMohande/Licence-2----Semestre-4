package image;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import image.color.GrayColor;
import image.Pixel;

/**
 * @author : Mohand Outioua
 */

public class PixelTest {


	@Test
	public void testPixel(){
		Pixel somePixel = new Pixel(new GrayColor(10));
		assertNotNull(somePixel);
	}

	@Test
	public void testGetColor(){
		Pixel somePixel = new Pixel(GrayColor.WHITE);
		assertTrue(somePixel.getColor().equals(GrayColor.WHITE));
	}

	@Test
	public void testSetColor(){
		Pixel somePixel = new Pixel(GrayColor.WHITE);
		somePixel.setColor(GrayColor.BLACK);
		assertEquals(somePixel.getColor(), GrayColor.BLACK);
	}
    
    @Test 
	public void testEquals(){
		Pixel somePixel = new Pixel(GrayColor.WHITE);
		Pixel somePixel2 = new Pixel(GrayColor.WHITE);
		Pixel somePixel3 = new Pixel(GrayColor.BLACK);
		assertTrue(somePixel.equals((Object) somePixel2));
		assertFalse(somePixel.equals((Object) somePixel3));
    }

    @Test 
	public void testColorDifference(){
		Pixel somePixel = new Pixel(new GrayColor(10));
		Pixel somePixel2 = new Pixel(new GrayColor(10));
		Pixel somePixel3 = new Pixel(new GrayColor(5));
		assertEquals(somePixel.colorDifference(somePixel2),0);
		assertEquals(somePixel.colorDifference(somePixel3),5);
		assertEquals(somePixel3.colorDifference(somePixel),5);
    }

  public static junit.framework.Test suite() {
	return new junit.framework.JUnit4TestAdapter(image.PixelTest.class);
  }

}