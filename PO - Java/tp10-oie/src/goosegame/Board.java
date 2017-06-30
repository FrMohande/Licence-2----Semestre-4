package goosegame;
import goosegame.Cell;

/**
 * @author : Mohand Outioua
 */

public abstract class Board{
	protected final int nbOfCells;
	protected Cell[] theCells;

	/**
	 *	Board constructor, initialize the Cell array
	 *	with nbOfCells + 1 Cells defined with the parameter
	 *	@param nbOfCells
	 *		the number of cells on the board
	 */
	public Board(int nbOfCells){
		this.theCells = new Cell[nbOfCells+1];
		this.nbOfCells = nbOfCells;
		this.initBoard();
	}

	protected abstract void initBoard();

	public Cell getCell(int numero) throws ArrayIndexOutOfBoundsException{
		if(numero > nbOfCells)
			throw new ArrayIndexOutOfBoundsException();
		return this.theCells[numero];
	}

	public int getNbOfCells(){
		return this.nbOfCells;
	}

}