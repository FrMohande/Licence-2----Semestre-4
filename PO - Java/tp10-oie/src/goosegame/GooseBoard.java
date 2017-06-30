package goosegame;
import goosegame.Cell;
import goosegame.NormalCell;
import goosegame.WarpCell;
import goosegame.TrapCell;
import goosegame.StartCell;
import goosegame.WaitCell;
import goosegame.Board;
import goosegame.GooseCell;

public class GooseBoard extends Board{

	public GooseBoard(){
		super(63);
	}

	/**
	 *	Initialize a classic Goose Game board
	 *	
	 */
	protected void initBoard(){
		for(int i = 1; i<=this.nbOfCells;i++)
			this.theCells[i] = new NormalCell(i);
		this.theCells[0] = new StartCell(0);
		this.theCells[9] = new GooseCell(9);
		this.theCells[18] = new GooseCell(18);
		this.theCells[27] = new GooseCell(27);
		this.theCells[36] = new GooseCell(36);
		this.theCells[45] = new GooseCell(45);
		this.theCells[54] = new GooseCell(54);

		this.theCells[31] = new TrapCell(31);
		this.theCells[52] = new TrapCell(52);

		this.theCells[19] = new WaitCell(19,2);

		this.theCells[6] = new WarpCell(6,12);
		this.theCells[42] = new WarpCell(42,30);
		this.theCells[58] = new WarpCell(58,1);
	}
}
