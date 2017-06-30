package rps;

import rps.strategy.* ;
import rps.* ;
import util.Input;

public class GameMain {
	public static void main(String[] args) {
		String playerName = "Player 1";
		int nbRounds = 6;
		try{	
			int tmpI;
			System.out.println("Enter your name :");
			playerName = Input.readString();
			System.out.println("Enter the number of rounds you want to play (6 by default):");
			tmpI = Input.readInt();
			if(tmpI != 0)nbRounds = tmpI;
		}catch(java.io.IOException e){
		}
		Strategy strRock = new StrategyRock();
		Strategy strScissors = new StrategyScissors();
		Strategy strSelect = new StrategySelect();
		Strategy strPaper = new StrategyPaper();
		Strategy strCyclic = new StrategyCyclic();
		Strategy strAlea = new StrategyAlea();
		Player p2 = new Player(playerName,strSelect) ;
		Player p1 = new Player("Computer", strAlea) ;
		Game game = new Game(p1,p2,nbRounds) ;
		game.playGame() ;
	}
}
