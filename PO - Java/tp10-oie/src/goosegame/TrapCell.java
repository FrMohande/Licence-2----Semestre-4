package goosegame;
import goosegame.Player;
import goosegame.Cell;

/**
 * @author : Eddy El Khatib
 */

public class TrapCell extends NormalCell{

	public TrapCell(int index){
		super(index);
	}

	/**
	 *	The fact that this cell is a trap one, the player can't move.
	 *	@return always false
	 */
	public boolean canBeLeft(){
		return false;
	}

	public String toString(){
		return super.toString() + "(trap) ";
	}


}