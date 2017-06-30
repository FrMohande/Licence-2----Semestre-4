package image;
import image.color.*;
import image.*;

/**
 * @author : Eddy El Khatib
 */

public class ImageExample {

	public static void main(String[] args) {
		Image monI = new Image(100,200);
		ImageDisplayer iD = new ImageDisplayer();
		for(int i = 10; i <=30; i++){
			for(int j = 30 ;j<= 60; j++){
				monI.changeColorPixel(i,j, GrayColor.BLACK);
			}
		}
		for(int i = 1; i <=20; i++){
			for(int j = 1 ;j <= 50; j++){
				monI.changeColorPixel(50+i,50+j,new GrayColor(64));
				monI.changeColorPixel(20+i,110+j, new GrayColor(230));
			}
		}
		iD.display(monI, "affiche normal");
		iD.display(monI.edge(20),"edge 20");
		iD.display(monI.edge(63), "edge 63");
		iD.display(monI.edge(229), "edge 229");
		iD.display(monI.edge(255), "edge 255");
	}

}