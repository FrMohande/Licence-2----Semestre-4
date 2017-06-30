package rps.strategy;

/**
 * @author : Mohand Outioua
 */

import rps.Strategy;
import rps.Shape;


public class StrategyRock implements Strategy {
	/**  the player will always play  ROCK */
	public Shape chooseShape() {
		return Shape.ROCK ;
	}
}
