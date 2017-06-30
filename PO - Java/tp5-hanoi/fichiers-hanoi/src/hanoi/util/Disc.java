package hanoi.util ; 

/**
 * 
 * Le disc est le nombre de disque que possède une tour, on se capable de mettre ou enlever des disques  sur une des tours.
 * 
 * 
 * @author OUTIOUA MOHAND
 * @version 1.0
 */

public class Disc {
	// les attributs de la classe Disc
	
	/** 
	* Le nombre d'anneau que possède le jeu
	*/ 
	private int taille ; 

	/** 
	* donnes le dessous de la classe disque
	*/ 

	private Disc dessous ; 

	// Constructeur 

	public Disc(int taille) {
		this.taille = taille ; 
		dessous = null ;
	}


	/** 
	* retournes le dessous de la pile de disque
	* @param
	* @return <code>dessous<code>
	*/
	public Disc getDessous() {
		return this.dessous;
	}
	
	/** 
	* permets d'ajouter un disque
	* @param <code>sous<code> de la classe Disc
	* @return 
	*/
	public void setDessous(Disc sous) {
			this.dessous = sous ; 
	}


	/** 
	* retournes le nombre d'anneau que possède la disque
	* @param
	* @return <code>int<code>
	*/
	public int getTaille() {
		return this.taille;
	}
	/**
	* Si la valeur de l'objet qui apelle la fonction est plus grande que la valeur de l'objet autre alors on renvoie true sinon false 
	* @param <code>autre<code> de la classe Disc 
	* @return <code>true<code> sila valeur de l'objet courant est plus petit que l'objet  autre sinon on renvoie <code>false<code>
	*/
	public boolean estPlusPetit(Disc autre) {
		boolean cmp = false  ;
		if ( this.getTaille() < autre.getTaille() ) {
			cmp = true ;
		}
		return cmp;
	}


	/**
	* retourne la représentation graphique du disc en String
	* @param
	* @return <code>taille<code> 
	*/
	public String toString() {
		String discString = "";
		for(int i = 1;i<=this.taille;i++){
			discString += "_";
		}
		discString += "|";
		for(int i = 1;i<=this.taille;i++){
			discString += "_";
		}
		return discString;
	}


}
