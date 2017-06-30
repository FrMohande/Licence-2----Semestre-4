package image;
import image.color.*;
import image.*;

/**
 * @author : Eddy El Khatib
 */


public class ImageMain {

	public static void main(String[] args) {
		if (args.length > 1) {
			Image monI = Image.initImagePGM(args[0]);
			ImageDisplayer iD = new ImageDisplayer();
			int firstArg;
			int sndArg;
   			try {
        			firstArg = Integer.parseInt(args[1]);
        			sndArg = Integer.parseInt(args[2]);
        			iD.display(monI, "Image Initiale");
				iD.display(monI.edge(firstArg),"edge "+args[1]);
				iD.display(monI.decreaseGrayLevels(sndArg), "ndg " +args[2]);
    			} catch (NumberFormatException e) {
        			System.err.println("The last two must be integers.");
        			System.exit(1);
    			}
		}
	}

}
