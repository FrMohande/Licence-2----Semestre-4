package hanoi ;
import hanoi.util.Disc ;
import hanoi.util.Tower ;


/**
 * 
 * la classe Plateau permets de crée le nombre de tour et de faire des déplacements.
 *
 * @author OUTIOUA MOHAND
 * @version 1.0
 */

	public class Plateau {
		// les attributs de la classe Plateau
	
		/** 
		* permets de crée le nombre de tours
		*/ 
		private Tower[] tour ; 

		//Constructeur 
		public Plateau(int nbAnneau) {
			this.tour = new Tower[nbAnneau] ;

			for(int i = nbAnneau ; i < 0 ; i--) {
				this.tour[0] = new Tower(nbAnneau) ;
			}

		}

		/** 
		*  permet de déplacer la valeur de la tour de départ dans la tour d'arrivée 
		* @param <code>a<code> et <code>b</code> qui sont tous les deux du type int 
		* @return 
		*/
		public void deplacer(int d,int a) {
			/* valeur de d dans a */
			this.tour[a] = this.tour[d] ;

		}
		/** 
		* Renvoie true si on peux la valeur de l'objet courant est déplaçable dans la tour  sinon false
		* @param <code>tour<code> de la classe Tour 
		* @return <code>true</code> si la tour n'est pas pleine alors on peux déplacer sinon false 
		*/
		public boolean est_deplaçable(Tower tour) {
			boolean cmp = false ;
			if(tour.est_pleine() != true ) {
					cmp = true ;

			}
			return cmp ;
		}




}