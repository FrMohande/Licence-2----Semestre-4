package battleship;
/** a cell in the battleship game, it can contains a ship... or not and can have been shot... or not
 */
public class Cell {
    private Ship ship;
    private boolean shot;
    public static char EMPTY = '~';
    public static char UNKNOWN = '.';
    public static char HIT = '*';
    public static char SHIP = 'B';

    /** creates an empty cell never shot
     */
    public Cell() {
        this.ship = null;
        this.shot = false;
    }
    
    /** provides the ship in this cell (<code>null</code> if none)
     * @return the ship in this cell (<code>null</code> if none)
     */
    public Ship getShip() {
        return this.ship;
    }

    /** sets a ship in this case
     * @param ship the ship
     */
    public void setShip(Ship ship) {
        this.ship = ship;
    }

    /** tells whether this cell has already been shot or not
     * @return <code>true</code> iff the cell has already been shot
     */
    public boolean hasBeenShot() {
        return this.shot;
    }

    /** this cell is shot, then if there is a ship it is hit
     */
    public void shot() {
        this.shot = true;
        if (this.ship != null) {
        	this.ship.hitted();
        }
    }
	
	
    /** provides a character depending of the cell's state : empty, with a hit ship, a safe ship or unknown 
     * @return a charcter depending on the cell's state 
     */
    public char getCharacter(boolean defender) {
        if(defender){
            if(this.ship == null){
                return EMPTY;
            }else {
                if(this.shot)
                    return HIT;
                else
                    return SHIP;
            }
        }else {
            if(this.shot){
                if(this.ship == null)
                    return EMPTY;
                else
                    return HIT;
            }else {
                return UNKNOWN;
            }
        }
    }
}
