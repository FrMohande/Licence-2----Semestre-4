package goosegame;
import goosegame.*;

/**
 * @author : Mohand Outioua
 */

public class GooseMain {
	public static void main(String[] arg) {
		Board gooseBoard = new GooseBoard();
		Game gooseGame = new Game(gooseBoard);
		gooseGame.addPlayer(new Player("Bilbo"));
		gooseGame.addPlayer(new Player("Frodo"));
		gooseGame.addPlayer("Sam");
		gooseGame.addPlayer("Mohand");
		gooseGame.play();
	}
}