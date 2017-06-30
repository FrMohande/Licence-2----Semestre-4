package image;
import image.color.*;

/**
 * @author : Mohand Outioua
 */

public class Pixel {
	private GrayColor color ;
   
   /*Constructor */ 
	public Pixel(GrayColor color){
		this.color = color;
	}
	/* return the color of this pixel 
	* @return <code>GrayColor</code> */
	public GrayColor getColor(){
		return this.color;
	}
	/* 
	* Changes the color of the pixel who called this function
	* @param <code>color</code> type Graycolor 
	*/
	public void setColor(GrayColor color){
		this.color = color;
	}
	/* return <code>true</code> type boolean if the object is equals of this Pixel who called the function
	* else <code>false</code>
	* @param <code>o</code> type Object 
	* @return <code>true</code> if the object is equals else <code>false</code>
	*/ 
	public boolean equals(Object o){
		if(o instanceof Pixel)
			return this.color.equals(((Pixel)o).color);
		return false;
	}
	/* 
	* Return the  color difference ( in absolute value )  of Pixel between pixelcomp and the object who called the function
	* @param <code>pixelComp</code> type Pixel 
	* @return <code>int</code>
	*/
	public int colorDifference(Pixel pixelComp){
		return Math.abs(this.color.getLevel() - pixelComp.color.getLevel());
	}
}