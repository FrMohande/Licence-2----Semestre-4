package goosegame;
import goosegame.Player;
import goosegame.Cell;

/**
 * @author : Eddy El Khatib
 */

public class WaitCell extends NormalCell{
	private final int turns;
	private int nbTurns;

	public WaitCell(int index, int turns){
		super(index);
		this.turns = turns;
		this.nbTurns = 0;
	}
	/**
	 *	The fact that this cell is a wait one, the player can only
	 *	move when the number of round he passed on it is equals to 
	 *	number of rounds required
	 *	@return true when enough time is passed on the cell by a player
	 */
	public boolean canBeLeft(){
		return this.turns == this.nbTurns++;
	}


	/**
	 *	a player arrives in this Cell
	 *	@param player
	 *		the new player in the cell
	 */
	public void welcomePlayer(Player player){
		this.nbTurns = 0;
		super.welcomePlayer(player);
	}

	public String toString(){
		String tmp = "";
		if(this.nbTurns == 0)
			tmp += " (waiting for " + this.turns + " turns)";
		return super.toString() +  tmp + " ";
	}

}