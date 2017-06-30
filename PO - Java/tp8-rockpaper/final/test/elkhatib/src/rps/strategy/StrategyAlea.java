package rps.strategy;

import rps.Shape;
import rps.Strategy;

public class StrategyAlea implements Strategy {
	/**  the next Shape from a player will be choose in random */
	public Shape chooseShape() {
		return Shape.random() ;
	}
}
