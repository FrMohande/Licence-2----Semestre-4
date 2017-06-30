import java.io.*;
import drawing.*;
import java.awt.*;

/**
 *  classe de test de la classe de dessin 
 *
 *@author   Didier Mailliet 
 */
public class TestDraw {

	private DrawingFrame d =new DrawingFrame();
 public static void main(String[] args) throws Exception {
TestDraw td= new TestDraw();
td.d.goTo(new Point (100,100));
	 td.d.drawTo(new Point (100,120));
	 String s=System.console().readLine("");
	 td.d.drawTo(200,120);
	  s=System.console().readLine("");
	 td.d.drawTo(new Point (200,220));
	  s=System.console().readLine("");
	 td.d.drawTo(new Point (100,100));
	  s=System.console().readLine("");
	 td.d.reset();
	  s=System.console().readLine("");
	 td.d.setColor(Color.blue);
	 td.d.fillRect (200,120,50,10);
	  s=System.console().readLine("");
	 td.d.drawTo(new Point (200,220));
	  s=System.console().readLine("");
	 td.d.drawTo(new Point (100,100));
	  s=System.console().readLine("");
	 System.exit(0);
}

}
