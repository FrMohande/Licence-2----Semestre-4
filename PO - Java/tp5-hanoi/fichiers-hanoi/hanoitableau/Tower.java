package hanoi.util ;
import hanoi.util.Disc ; 

/**
 * La classe Tower est la classe qui compose les tours.
 * Cette classe est la version en tableau
 * 
 * @author OUTIOUA MOHAND
 * @version 1.0
 */

public class Tower {
	// les attributs de la classe Tower
	
	/** 
	*  Le sommet permets de savoir combien 
	*/ 
	private int sommet ;

	/** 
	* Les tours
	*/ 
	private Disc[] tour ;

	//Constructeur 
	public Tower(int capacite) {
		this.tour = new Disc[capacite] ;
		this.sommet = -1 ; 
	}

	/** 
	*   Si l'objet courant celle qui apelle la fonctions ne peux plus contenir des disques alors on renvoie true 
	* sinon false ce qui veux dire que l'objet courant peux encore contenir des anneaux
	* @param 
	* @return <code>true</code> si la tour est pleine sinon <code>false</code>
	*/

	public boolean est_pleine() {
		/* Si la tour est pleine on renvoie true sinon faux */
		boolean cmp = false  ;
		if (this.getNbAnneau() == this.getCapacite() ) {
			cmp = true  ;
		}
		return cmp ;

	}

	/** 
	* Si l'objet courant peux encore contenir des disques on renvoie true sinon <code>false</code>
	* @param
	* @return <code>true</code> si la tour est vide sinon <code>false</code>
	*/

	public boolean est_vide() {
		/* Si la tour est vide on a true sinon faux */
		boolean cmp = true  ; 
		if (this.tour[this.sommet].getTaille() != 0 ) {
			cmp = false  ;
		}
		return cmp ;

	}

	/** 
	* retournes la valeur au dessus du tas de la tour
	* @param 
	* @return <code>Disc</code> 
	*/

	public Disc getTop() {
		return this.tour[this.sommet] ;
	}

	/** 
	* renvoie le nombre d'anneau que possède la tour
	* @param
	* @return <code>int</code> 
	*/
	public int getNbAnneau() { 
		return this.tour[this.sommet].getTaille() ;
	}

	/** 
	* renvoie la valeur qui est trouve à la case tour[sommet]  et décrémente le sommet
	* @param
	* @return <code>Disc</code> de la classe Disc
	*/
	public Disc depiler() {
		this.sommet-- ;
		return this.tour[this.sommet+1] ;

	}


	/** 
	*  incrémente le sommet de la tour et mets la valeur de à la tour[sommet]
	* @param <code>tour<code> de la classe Disc
	* @return 
	*/
	public void empiler(Disc tour) { 
		this.sommet++ ;
		this.tour[this.sommet] = tour ;
	}

	/** 
	* renvoie toutes les valeurs que la tour possède
	* @param 
	* @return <code>String<code>
	*/
	public String toString() {
		String temp = "" ; 
		for(int i = 0 ; i < this.getCapacite() ; i++) {
			temp += this.tour[i].toString() ;
		}
		return temp ;

	}

	/** 
	* renvoie le nombre d'anneau que une tour peux contenir
	* @param
	* @return  <code>int</code>
	*/
	public int getCapacite() {
		return this.tour.length  ;
	}

}
