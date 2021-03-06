package goosegame;
import goosegame.*;
import java.util.*;
/**
 * @author : Eddy El Khatib
 */


public class Game{
	protected List<Player> thePlayers;
	protected Board board;
	private Iterator<Player> it_thePlayers ;

	/**
	 * Game constructor initialized with the Board players will play on.
	 * @param board
	 *		the Board of the game
	 */
	public Game(Board board){
		this.board = board;
		this.thePlayers = new ArrayList<Player>();
	}

	/**
	 *	Adds a player to the player list of the game by its reference
	 *	@param p
	 *		the player to be added to the game		
	 */
	public void addPlayer(Player p){
		this.thePlayers.add(p);
		this.board.getCell(0).welcomePlayer(p);
	}

	/**
	 *	Creates a new player and adds it the player list of the game
	 *	@param name
	 *		the player's name to be added to the game
	 */
	public void addPlayer(String name){
		Player tmp = new Player(name, this.board.getCell(0));
		this.thePlayers.add(tmp);
		this.board.getCell(0).welcomePlayer(tmp);
	}



	/**
	 *	Determines the next player that has to play.
	 *  @return The player that has to play
	 */
	private Player nextPlayer(){
		if(this.it_thePlayers == null || !it_thePlayers.hasNext())
			this.it_thePlayers = this.thePlayers.iterator();
		return this.it_thePlayers.next();
	}

	/**
	 *	Plays the game until one player of the list wins it.
	 *	Verifies if a player can play a turn, and handles its move if so.
	 */
	public void play(){
		Player currentPlayer = null;
		boolean won = false;
		while(!won){
			currentPlayer = this.nextPlayer();
			this.displayTurn(currentPlayer);
			if(this.canPlay(currentPlayer)){
				this.movePlayer(currentPlayer,this.playTurn(currentPlayer));
				won = currentPlayer.getCell().getIndex() == this.board.getNbOfCells();
			}else
				this.displayPlayerCannotPlay(currentPlayer);
			System.out.println();
		}
		this.displayWinner(currentPlayer);
	}

	private void displayWinner(Player p){
		System.out.println(p + " won the game !");
	}

	private void displayPlayerCannotPlay(Player p){
		System.out.print(p + " cannot play.");
	}

	/**
	 *	Determines if a player can play his turn or not (if he's on a trap or wait cell)
	 *	@param p
	 *		The player on which the verification is made
	 *  @return <code>true</code> if the player can play
	 */
	private boolean canPlay(Player p){
		return p.getCell().canBeLeft();
	}

	/**
	 *	Moves a player on a given cell
	 *	@param p
	 *		the player to be moved
	 *	@param c
	 *		the cell the player has to be moved on
	 */
	private void movePlayer(Player p, Cell c){
		Cell tmpC = p.getCell();
		Player tmpP = null;
		if(c.isBusy()){
			this.displayBusy(c, tmpC);
			tmpP = c.getPlayer();
			tmpC.welcomePlayer(tmpP);
		}else{
			if(tmpC.getIndex() == 0)
				((StartCell)tmpC).removePlayer(p);
			else
				tmpC.welcomePlayer(null);
		}
		c.welcomePlayer(p);
	}

	private void displayBusy(Cell cD, Cell cA){
		/* if the player returns to its initial cell, there's no need to inform the player,
		   the cell is busy because he's on it : example:
			Bilbo is on cell 60 on a 63 cells board, bilbo throws 6, reaches 60 */
		if(cD != cA)
			System.out.print("cell is busy " + cD.getPlayer() + " is sent to " + cA);
	}

	/**
	 *	Determines the destination of the current player at the end of its turn.
	 *	@param p
	 *		the current player
	 *	@return the Cell destination of the player
	 */
	private Cell playTurn(Player p){
		int turnValue = p.twoDiceThrow();
		int currentCell = p.getCell().getIndex();
		int cellDest = currentCell + turnValue;
		int tmp;
		displayThrow(p,turnValue);
		if(cellDest > (this.board.getNbOfCells()))
			cellDest = this.board.getNbOfCells() - (cellDest % (this.board.getNbOfCells()));
		tmp = cellDest;
		displayReach(this.board.getCell(cellDest));
		cellDest = this.board.getCell(cellDest).handleMove(turnValue);

		if(cellDest > this.board.getNbOfCells())
			cellDest = this.board.getNbOfCells() - (cellDest % this.board.getNbOfCells() );
		if(tmp != cellDest)
			displayChange(this.board.getCell(tmp), this.board.getCell(cellDest));
		return this.board.getCell(cellDest);
	}

	private void displayTurn(Player p){
		System.out.print(p + " is in cell " + p.getCell()+", ");
	}

	private void displayThrow(Player p, int theThrow){
		System.out.print(p + " throws " + theThrow);
	}

	private void displayReach(Cell c){
		System.out.print(" and reaches " + c);
	}

	private void displayChange(Cell dep, Cell arr){
		if(dep instanceof WarpCell)
			System.out.print("(teleport to " + arr + ") ");
		System.out.print(" and jumps to " + arr);
	}
}
