package rps;

/**
 * @author : Mohand Outioua
 */

public class Player {
	int nbPts ;
	String name ;
	Strategy strategy ;
	
	   /*Constructor */ 
	public Player(String name,Strategy s) {
		this.name = name ;
		this.strategy = s ;
	}	
	/**  add to nbPts the number in the parameters of the fonction. 
	 * @param <code>n</code> in int
	 * @return
	 */ 
	public void addPoints(int n) {
		this.nbPts += n ;
	}
	/**   
	* return the number of points of player got.
	* @return <code>int</code>
	*/
	public int getScore() {
		return this.nbPts ;
	}
	/**  return the name of the player
	* @return <code>String</code>
	*/
	public String getName() {
		return this.name; 
	}
	/**  this function will choose wich shape the player will play
	* @return <code>Shape</code> the player will play
	*/ 
	public Shape play() {
		Shape c ; 
		c = strategy.chooseShape() ;
		return c ;
	}
	public String toString() {
		return this.name ;
	}
}
