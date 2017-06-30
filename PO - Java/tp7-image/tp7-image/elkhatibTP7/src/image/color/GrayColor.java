package image.color;

/**
 * @author : Mohand Outioua
 */

public class GrayColor {
	private int level;
	public static final GrayColor WHITE = new GrayColor(255);
	public static final GrayColor BLACK = new GrayColor(0);
	
	/* constructor */ 
	public GrayColor(int level) {
		this.level = level;
	}
	/*
	*  return the level color of this grayColor
	* @return <code>int</code> 
	*/
	public int getLevel(){
		return this.level;
	}
	/* return <code>true</code> if the object is equals of this graycolor who called the function
	* else <code>false</code>
	* @param <code>o</code> type Object 
	* @return <code>true</code> if the object is equals else <code>false</code>
	*/ 
	public boolean equals(Object o){
		if(o instanceof GrayColor)
			return ((GrayColor)o).level == this.level;
		return false;
	}
}