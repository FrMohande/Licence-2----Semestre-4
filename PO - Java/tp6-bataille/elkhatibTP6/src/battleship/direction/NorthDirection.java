package battleship.direction;
import battleship.direction.Direction;
import battleship.Position;

/**
 * @author : Mohand Outioua
 */

public class NorthDirection implements Direction{
	public Position nextPosition(Position p){
		return (new Position(p.getX(), p.getY() -1));
	}
}
