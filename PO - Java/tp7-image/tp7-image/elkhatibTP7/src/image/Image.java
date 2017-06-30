package image;
import image.*;
import image.color.*;

import java.util.*;

/**
 * @author : Eddy El Khatib
 */


public class Image {

    Pixel[][] image;

    public Image(int width, int height){
        this.image = new Pixel[width][height];
        for(int i = 0; i<width;i++)
            for (int j = 0; j<height;j++)
                this.image[i][j] = new Pixel(GrayColor.WHITE);
    }
    /**
     * Returns the width of this image
     * @return the width of the image
     */
    public int getWidth(){
        return this.image.length;
    }
    /**
     * Returns the height of this image
     * @return the height of the image
     */
    public int getHeight(){
        return this.image[0].length;
    }

    /**
     * Returns the pixel instance located on this image [x width][y height] position.
     * @param x
     *      the width location of the wanted pixel
     * @param y
     *      the height location of the wanted pixel
     * @return the wanted pixel
     */

    public Pixel getPixel(int x, int y) throws ArrayIndexOutOfBoundsException{
        return this.image[x][y];
    }


    /**
     * Changes the pixel color located on this image [x width][y height] position.
     * @param x
     *      the width location of the pixel which the color needs to be changed
     * @param y
     *      the height location of the pixel which the color needs to be changed
     * @param color
     *      the new GrayColor instance the pixel color has to be changed with
     */

    public void changeColorPixel(int x, int y, GrayColor color) throws ArrayIndexOutOfBoundsException{
        this.image[x][y].setColor(color);
    }

    /**
     * Creates a new image displaying the edges of the given one, depending on the threshold parameter.
     * To define if one pixel is an edge, the pixel on its right and/or the pixel below it and itself must have
     * a color difference >= to the given threshold in parameter. If we're checking the bottom left pixel,
     * the fact it hasn't any pixel on its right or below it, can't make it an edge (if there's no pixel on the right
     * of a chosen one, the pixel below it we'll do the work).
     *
     * @param threshold
     *          the threshold which will be used to define if a pixel is an edge or not
     * @return an image only displaying the edges of the given one
     */
    public Image edge(int threshold) {
        Image imageRet = new Image(this.getWidth(), this.getHeight()); 
	    for(int i =0;i<imageRet.getWidth();i++){
            for(int j =0;j<imageRet.getHeight();j++){
                if((i+1)<imageRet.getWidth()){
                    if(this.image[i][j].colorDifference(this.image[i+1][j]) > threshold){
                        imageRet.changeColorPixel(i, j, GrayColor.BLACK);
                        continue;
                    }
                }
                if((j+1)<imageRet.getHeight()){
                    if(this.image[i][j].colorDifference(this.image[i][j+1]) > threshold) {
                        imageRet.changeColorPixel(i, j, GrayColor.BLACK);
                        continue;
                    }
                }
            }
        }
        return imageRet;
    }

    /**
     * Decrease the number of gray levels of a given image to create a new one.
     * The methods processes one by one the pixels of the given image, and modifies 
     * its color following the new palette defined by the nbGrayLevels parameter.
     *
     * For example : the function is called with nbGrayLevels = 4, the new gray palette will be calculated by dividing the initial one by 4:
     * 0 to 63, 64 to 127, 128 to 191 and 192 to 255 will be our 4 intervals, and the new palette will contain the 4 following colors : 0, 64, 128 and 192
     * If a chosen pixel color is 55, the new color assigned to it will be the beginning color of its interval : 
     * 55 is between 0 and 63, its new color will be 0 (black), same as every other color, initial : 100 -> new : 64, etc..
     *
     * @param nbGrayLevels
     *          the number of gray levels, we'll use to create a new Image object from the given image
     * @return a new Image object, which is the given object but customized to fit the nbGrayLevels
     *          imposed by the parameter
     */
    public Image decreaseGrayLevels(int nbGrayLevels) {
       int t = 256 / nbGrayLevels;
       Image imageRet = new Image(this.getWidth(), this.getHeight());

       for(int i =0;i<imageRet.getWidth();i++){
            for(int j =0;j<imageRet.getHeight();j++){
                GrayColor currentColor = this.getPixel(i,j).getColor();
        		for(int k = 0 ; k <= nbGrayLevels ; k ++){
        			int pToCompInf = (k*t);
               		int pToCompSup = ((k+1)*t)-1;
	                if(currentColor.getLevel() >= pToCompInf && currentColor.getLevel() <= pToCompSup) {
     	                imageRet.changeColorPixel(i, j, new GrayColor(pToCompInf));
        				break;
        	        }
        		}
            }
        }
        return imageRet;
    }

    // ======================================================================
    /** Reads a PGM image from file.
     * It is assumed that file respect the following PGM file syntax:
     *  <ul><li> first line with string "P2"</li>
     *  <li>second line : a comment</li> 
     *  <li>one int for width <code>w</code>, one int for height<code>h</code></li>
     *  <li>one int for max gray level (not used here, we consider this level to be 255 in our images)</li>
     *  <li><code>w</code> x <code>h</code> integers between 0 and max (for us =255) for each pixel</li></ul>
     *  
     *  @param fileName the name of the file with the image
     */
    public static Image initImagePGM(String fileName) {
        Scanner scan = new Scanner(Image.class.getResourceAsStream(fileName));

        scan.nextLine(); // line P2
        scan.nextLine(); // line comment
        // read width
        int width = scan.nextInt();
        // read height        
        int height = scan.nextInt();
        // read max gray level (not used)
        scan.nextInt(); 
        // create an initially white image
        Image result = new Image(width, height); 
        // rad pixels
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                result.changeColorPixel(y, x, new GrayColor(scan.nextInt()));
            }
        }
        return result;
    }


}
