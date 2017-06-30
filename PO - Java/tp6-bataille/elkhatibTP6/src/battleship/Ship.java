package battleship ;

/** 
 * @author : Mohand Outioua
 */

public class Ship {
	private int lifepoints;

	public Ship(int length){
		this.lifepoints = length;
	}
	/**
	 *	returns the lifepoints attribute value of the ship.
	 *
	 *	@return the total life points of this ship
	 */
	public int getLife(){
		return this.lifepoints;
	}

	/**
	 *	Prediactes if this ship is sunk or not
	 *	@return <code>true</code> if the ship is sunk
	 */
	public boolean isSunk(){
		return this.lifepoints == 0;
	}

	/**
	 *	This boat has been hit.
	 *	Decrements the lifepoints attribute of the ship
	 */
	public void hitted(){
		this.lifepoints -= 1 ;
	}

	public String toString(){
		return Integer.toString(this.lifepoints);
	}
}