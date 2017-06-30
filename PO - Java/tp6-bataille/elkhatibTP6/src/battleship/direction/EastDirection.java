package battleship.direction;
import battleship.direction.Direction;
import battleship.Position;

/**
 * @author : Mohand Outioua
 */

public class EastDirection implements Direction{
	public Position nextPosition(Position p){
		return (new Position(p.getX()+1, p.getY()));
	}
}
