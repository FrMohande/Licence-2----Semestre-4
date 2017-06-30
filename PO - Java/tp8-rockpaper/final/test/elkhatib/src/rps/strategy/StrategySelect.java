package rps.strategy;

/**
 * @author : Eddy El Khatib
 */

import rps.Strategy;
import rps.Shape;
import util.Input;

public class StrategySelect implements Strategy {
	/**   the player can choose which shape he want to play */
	public Shape chooseShape() {
		System.out.println("Choose one shape : r (rock) / p (paper) / s (scissors)");
		String chaineLue = Input.readString();
		while(true){
			switch(chaineLue){
				case "r" :
					return Shape.ROCK;

				case "p" :
					return Shape.PAPER;

				case "s" :
					return Shape.SCISSORS;

				default :
					System.out.println("Choose one shape : r (for rock) / p (for paper) / s (for scissors)");
					chaineLue = Input.readString();

			}
		}
	}
}
