package rps;
/**
 * @author : Eddy El Khatib
 */
public class Game{
	private Player p1;
	private Player p2;
	private int nbRound;
	public static final int VICTORY_POINTS = 2;
	public static final int DEFEAT_POINTS = 0;
	public static final int TIE_POINTS = 1;

	public Game (Player p1, Player p2, int nbRound){
		this.p1 = p1;
		this.p2 = p2;
		this.nbRound = nbRound;
	}


	/**
	 *	Plays a round of the game, and adds points to both player depending on
	 *	the result of the said round.
	 *
	 */
	public void playOneRound(){
		Shape c1 = this.p1.play();
		Shape c2 = this.p2.play();
		System.out.println(this.p1 + " plays "+ c1);
		System.out.println(this.p2 + " plays "+ c2);
		int income = c1.compareShape(c2);
		if(income == 0){
			this.p1.addPoints(Game.TIE_POINTS);
			this.p2.addPoints(Game.TIE_POINTS);
		}else if(income > 0){
			this.p1.addPoints(Game.DEFEAT_POINTS);
			this.p2.addPoints(Game.VICTORY_POINTS);
		}else{
			this.p1.addPoints(Game.VICTORY_POINTS);
			this.p2.addPoints(Game.DEFEAT_POINTS);
		}
	}

	/**
	 *	Plays automatically nbRound rounds and display the score at each one.
	 *	Also displays the result of the game when nbRound is reached.
	 *
	 */

	public void playGame(){
		for(int i = 1; i <= nbRound; i++){
			System.out.println("----------NEW ROUND (" + i + " out of " + nbRound + ")----------");
			this.playOneRound();
			System.out.println("The score is " + this.p1 + " : "+ this.p1.getScore() +" pts | " + this.p2 + " : "+ this.p2.getScore() +" pts  ");
		}
		this.endOfGame();
	}


	/**
	 *	
	 *	Displays the winner of the game, or announcing a tie depending on the 
	 *	score of both players when the end of the game is reached.
	 *
	 */

	private void endOfGame(){
		if(this.p1.getScore() > this.p2.getScore())
			System.out.println(this.p1 + " wins the game !");
		else if(this.p1.getScore() < this.p2.getScore())
			System.out.println(this.p2 + " wins the game !");
		else
			System.out.println("The game is a tie !");
	}

}