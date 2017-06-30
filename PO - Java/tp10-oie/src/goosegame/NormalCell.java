package goosegame;
import goosegame.Player;
import goosegame.Cell;

/**
 * @author : Mohand Outioua
 */

public class NormalCell implements Cell{
	private final int index;
	private Player playerOnCell;

	public NormalCell(int index){
		this.index = index;
		this.playerOnCell = null;
	}
	/**
	 *	The fact that this cell is a normal one, the player can always move.
	 *	@return always true
	 */
	public boolean canBeLeft(){
		return true;
	}

	/**
	 *	Returns the index of this cell
	 *	@return the index of this cell
	 */
	public int getIndex(){
		return this.index;
	}

	/**
	 *	The fact that this cell is a normal one, the cell really reached by
	 *	the player is this cell when he reaches it.
	 *	@param diceThrow
	 *		the result of the dice when the player reaches this cell
	 *	@return always this cell index
	 */
	public int handleMove(int diceThrow){
		return this.index;
	}

	/**
	 *	a player arrives in this Cell
	 *	@param player
	 *		the new player in the cell
	 */
	public void welcomePlayer(Player player){
		this.playerOnCell = player;
		if(player != null)
			player.setCell(this);
	}

	/**
	 * Get the player in this cell, <tt>null</tt> if none
	 */
	public Player getPlayer(){
		return this.playerOnCell;
	}
	
	/**
	 *	Determines if a player is in this cell
	 *	@return <tt>true</tt> if a player is in this cell
	 */
	public boolean isBusy(){
		return this.playerOnCell != null;
	}

	public String toString(){
		return this.index +" ";
	}

}