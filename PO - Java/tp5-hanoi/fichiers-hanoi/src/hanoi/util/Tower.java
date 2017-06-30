package hanoi.util;


/**
 * Tower class : Methods on Towers
 * 
 * @author : Eddy El Khatib
 */



public class Tower {
	private int capacity ;
	private Disc top;
	private int nbDiscs ;

	/**
	 * Tower objects constructor
	 */
	public Tower(int capacity){
		this.capacity = capacity;
		this.top = null;
		this.nbDiscs = 0;
	}

	/**
	 * returns <code>true</code> if this Tower object is Empty.
	 *
	 * @return <code>true</code> if this Tower number of Discs is equal to 0. 
	 *
	 */
	public boolean isEmpty(){
		return this.nbDiscs == 0;
	}


	/**
	 * returns <code>true</code> if this Tower object is Full.
	 *
	 * @return <code>true</code> if this Tower number of Discs (nbDiscs value) is equal to its capacity attribute value. 
	 *
	 */
	public boolean isFull(){
		return this.nbDiscs == this.capacity;
	}


	/**
	 * returns the Top of the Tower.
	 *
	 * @return this Tower top attribute value. 
	 *
	 */
	public Disc getTop(){
		return this.top;
	}

	/**
	 * returns <code>true</code> if this Tower object is Empty.
	 *
	 * @return <code>true</code> if this Tower number of Discs is equal to 0. 
	 *
	 */

	public int getNbDiscs(){
		return this.nbDiscs;
	}


	/**
	 * Piles up the <code>d</code> Disc parameter on this Tower
	 *
	 * @param d
	 *		The Disc to be piled up on this Tower.
	 *
	 */

	public void pileUp(Disc d){
		if(nbDiscs > 0){
			d.setDessous(top);
		}
		this.top = d;
		this.nbDiscs++;
	}

	/**
	 * Piles down the top Disc of the tower. The 
	 *
	 * @return A <code>Disc</code> object, which is in fact the last top of the tower. 
	 *
	 */

	public Disc pileDown() {
		Disc tmp = this.top;
		this.top = this.top.getDessous();
		this.nbDiscs--;
		tmp.setDessous(null);
		return tmp;
	}


	/**
	 * Returns this tower capacity.
	 *
	 * @return this tower capacity attribute value
	 */
	public int getCapacity() {
		return this.capacity;
	}

	/**
	 *	returns this tower String representation of the Discs piled up on it.
	 *  example : if the discs are positionned like this on the tower : {Disc of size 1, Disc 2,....,5}
	 *  the String representation will be as follows : "5,4,3,2,1"
	 *
	 *  @return the string representation of the disc positionned on the selected tower
	 */
/*
	public String toString() {
		Disc tmp = this.top;
		String myString = "";
		String sreturn = "";
		if(nbDiscs > 0){
			for(int i = 1 ; i <= nbDiscs; i++){
				myString += ("," + tmp.toString());
				tmp = tmp.getDessous();
			}

			for(int j = (myString.length() -1); j >=1; j--){
				sreturn += myString.charAt(j);
			}
		}
		return sreturn;
	}*/
}
