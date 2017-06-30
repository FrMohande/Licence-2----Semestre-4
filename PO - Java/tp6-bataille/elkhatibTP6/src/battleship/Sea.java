package battleship;
import battleship.*;
import battleship.direction.*;

/**
 * @author : Eddy El Khatib
 */

public class Sea {
	private Cell[][] board;
	private int nbShipsAlive;

	public Sea(int nr, int nc){
		this.board = new Cell[nr][nc];
		for(int i = 0 ; i< nr ; i++)
			for(int j = 0; j< nc ; j++)
				this.board[i][j] = new Cell();
		nbShipsAlive = 0;
	}

	/** returns the appropriate answer concerning the consequences
	 *	of the shooting action on a position
	 *
	 *	@return an Answer :
	 *			- MISSED : opponent targets an empty position or a ship cell already hit
	 *			- HIT : opponent targets a ship cell, which wasn't hit before
	 *			- SUNK : opponent targets a ship cell, leads the ship to sink
	 */

	public Answer shoot(Position p) throws ArrayIndexOutOfBoundsException{
		Cell c = this.board[p.getX()][p.getY()];
		Ship s = c.getShip();
		if(s==null){
			c.shot();
			return Answer.MISSED;
		}else{
			if(c.hasBeenShot())
				return Answer.MISSED;
			else
				c.shot();
			if(s.isSunk()){
				this.nbShipsAlive --;
				return Answer.SUNK;
			}
			return Answer.HIT;
		}
	}

	/** displays the board line by line and cell by cell,
	 * the display changes for the defender or the opponent, defined
	 * by the <code>defender</code> argument
	 * @param defender <code>true</code> if display is for defender,
	 * <code>false</code> if is for opponent
	*/
    public void display(boolean defender){
    	String s = "";
        for(int i = 0; i< this.board[0].length ; i++){
        	for(int j = 0 ; j < this.board.length; j++)
        		s += this.board[j][i].getCharacter(defender) ;
        	System.out.println(s);
        	s = "";
        }
    }

    /** place the ship b from position p in the direction d. The number of
	 * cells is determined by the ship length.
	 * @param shipToPlace the ship to be placed
	 * @param position the position of the first cell occupied by the ship
	 * @param direction the direction in which b is placed from p
	 * @throws IllegalStateException if the ship b can not be placed on the sea
	 * (outside of the board or some cell is not empty)
	*/
	public void placeShip(Ship shipToPlace, Position position, Direction direction) throws IllegalStateException{
		Position temp = position;
		try{
			for(int i = 1 ; i<= shipToPlace.getLife();i++){
				if(this.board[temp.getX()][temp.getY()].getShip() != null)
					throw new IllegalStateException();
				temp = direction.nextPosition(temp);
			}
			temp = position;
			for(int j = 1 ; j<= shipToPlace.getLife(); j++){
				this.board[temp.getX()][temp.getY()].setShip(shipToPlace);
				temp = direction.nextPosition(temp);
			}
			nbShipsAlive++;
		}catch(ArrayIndexOutOfBoundsException e){
			throw new IllegalStateException();
		}
	}
}
