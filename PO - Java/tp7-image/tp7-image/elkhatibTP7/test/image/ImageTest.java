package image;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import image.*;
import image.color.*;

/**
 * @author : Eddy El Khatib
 */

public class ImageTest {


	@Test
	public void testImage(){
		Image someImage = new Image(4,4);
		assertNotNull(someImage);
	}

	@Test
	public void testGetWidth(){
		Image someImage = new Image(4,100);
		assertEquals(someImage.getWidth(),4);
	}

	@Test
	public void testGetHeight(){
		Image someImage = new Image(4,100);
		assertEquals(someImage.getHeight(),100);
	}


  @Test
  public void testGetPixel(){
  	Image someImage = new Image(1,1);
  	assertTrue(someImage.getPixel(0,0).equals(new Pixel(GrayColor.WHITE)));
  }


 	@Test
 	public void testChangeColorPixel(){
 		Image someImage = new Image(1,1);
    assertTrue(someImage.getPixel(0,0).equals(new Pixel(GrayColor.WHITE)));
 		someImage.changeColorPixel(0,0,GrayColor.BLACK);
 		assertTrue(someImage.getPixel(0,0).equals(new Pixel(GrayColor.BLACK)));
 	}

 	@Test
 	public void testEdge(){
 		Image someImage = new Image(2,2);
 		for(int i = 0; i < 2; i++){
 			someImage.changeColorPixel(1,i,GrayColor.BLACK);
 		}
 		someImage.edge(1);
 		assertTrue(someImage.getPixel(0,1).equals(new Pixel(GrayColor.WHITE)));
 		assertTrue(someImage.getPixel(1,1).equals(new Pixel(GrayColor.BLACK)));

 	}


  @Test
  public void testDecreaseGrayLevels(){
    Image someImage = new Image(2,2);
    Image someImage2 = null ;
    for(int i = 0; i < 2; i++){
      for(int j = 0; j < 2; j++){
        someImage.changeColorPixel(j,i,new GrayColor(32+(((2*i)+j)*64)));
      }
    }
    someImage2 =someImage.decreaseGrayLevels(4);
    assertTrue(someImage2.getPixel(0,0).equals(new Pixel(GrayColor.BLACK)));
    assertTrue(someImage2.getPixel(1,0).equals(new Pixel(new GrayColor(64))));
    assertTrue(someImage2.getPixel(0,1).equals(new Pixel(new GrayColor(128))));
    assertTrue(someImage2.getPixel(1,1).equals(new Pixel(new GrayColor(192))));
  }

     public static junit.framework.Test suite() {
	return new junit.framework.JUnit4TestAdapter(image.ImageTest.class);
    }

}
