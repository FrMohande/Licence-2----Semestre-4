package battleship;

/**
 * @author : Eddy El Khatib
 */

public class Position{
	private int x ;
	private int y ;

	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}
	/**
	 *	returns the x attribute value 
	 *	@return <code>x</code>, the abscissa of the position
	 */
	public int getX(){
		return this.x;
	}
	/**
	 *	returns the y attribute value
	 *	@return <code>y</code>, the odinate of the position
	 */
	public int getY(){
		return this.y;
	}
	/**
	 *	Predicates if an object is equal to a position instance.
	 *	The object is equal to the position if it is an instance of Position class
	 *	and if its positions are the same as the given position.
	 * 	@param <code>o</code> 
	 *				the given object instance to be compared 
	 *	@return <code>true</code> if the object is equal to this position
	 */
	public boolean equals(Object o){
		if(o instanceof Position){
			Position theOther = (Position) o;
			return (this.x == theOther.x) && (this.y == theOther.y);
		}else
			return false;
	}

	public String toString(){
		return "(" + this.x + "," + this.y + ")";
	}
}