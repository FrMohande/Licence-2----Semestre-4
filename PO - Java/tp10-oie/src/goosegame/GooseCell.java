package goosegame;
import goosegame.Player;
import goosegame.Cell;

/**
 * @author : Mohand Outioua
 */

public class GooseCell extends NormalCell{

	public GooseCell(int index){
		super(index);
	}

	/**
	 *	The fact that this cell is a goose one, the cell really reached by
	 *	the player is the one that is diceThrow cells after it
	 *	@param diceThrow
	 *		the result of the dice when the player reaches this cell
	 *	@return the cell, diceThrow cells after this one
	 */
	public int handleMove(int diceThrow){
		return super.handleMove(diceThrow) + diceThrow;
	}

	public String toString(){
		return super.toString() + " (goose)";
	}

}
