package goosegame;
import goosegame.Player;
import goosegame.Cell;
import java.util.*;

/**
 * @author : Eddy El Khatib 
 */

public class StartCell implements Cell{
	private final int index;
	private List<Player> playersOnCell;

	public StartCell(int index){
		this.index = index;
		this.playersOnCell = new ArrayList<Player>();
	}
	/**
	 *	The fact that this cell is a start one, the player can move.
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
	 *	The fact that this cell is a start one, the cell really reached by
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
		this.playersOnCell.add(player);
		if(player != null)
			player.setCell(this);
	}

	/**
	 * Get the player in this cell, <tt>null</tt> if none
	 */
	public Player getPlayer(){
		return null;
	}
	
	/**
	 *	We can add any player on a starting cell of a game
	 *	@return <tt>false</tt> always
	 */
	public boolean isBusy(){
		return false;
	}

	/**
	 *	Removes a player from the cell if he exists
	 *	@param p
	 *		The player to be removed from the cell
	 */
	public void removePlayer(Player p){
		this.playersOnCell.remove(p);
	}

	public String toString(){
		return Integer.toString(this.index) + " ";
	}

}