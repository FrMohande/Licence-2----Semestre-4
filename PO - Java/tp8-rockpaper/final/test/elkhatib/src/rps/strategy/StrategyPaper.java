package rps.strategy;

/**
 * @author : Mohand Outioua
 */

import rps.Strategy;
import rps.Shape;


public class StrategyPaper implements Strategy {
	/**  the player will always play  PAPER */
	public Shape chooseShape() {
		return Shape.PAPER ;
	}
}
