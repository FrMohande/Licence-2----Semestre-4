package goosegame;
import goosegame.Player;
import goosegame.Cell;

/**
 * @author : Mohand Outioua
 */

public class WarpCell extends NormalCell{
	private final int indexWarp;

	public WarpCell(int index, int indexWarp){
		super(index);
		this.indexWarp = indexWarp;
	}

	/**
	 *	The fact that this cell is a Warp one, the cell really reached by
	 *	the player is the cell to be warped on.
	 *	@param diceThrow
	 *		the result of the dice when the player reaches this cell
	 *	@return always the index of the cell to be warped on
	 */
	public int handleMove(int diceThrow){
		return this.indexWarp;
	}

}