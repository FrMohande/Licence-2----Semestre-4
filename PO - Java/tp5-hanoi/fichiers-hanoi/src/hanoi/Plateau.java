/**
 * Plateau class : methods on plateaux (tp hanoi)
 * 
 * @author : Eddy El Khatib
 */

package hanoi;
import hanoi.util.*;

public class Plateau {
	private Tower[] towers;

	/**
	 * Plateau object constructor. Instancing 3 towers of nbDiscs capacity with for the first tower nbDics discs
	 * initialized from nbDiscs to 1.
	 */
	public Plateau(int nbDiscs){
		towers = new Tower[3];
		for(int i = 0 ; i < 3 ; i++){
			towers[i] = new Tower(nbDiscs);
		}
		for(int j = nbDiscs ; j >=1 ; j--){
			towers[0].pileUp(new Disc(j));
		}
	}


	/**
	 *
	 * Moves a disc from this plateau tower at index <code>dep</code> to tower at index <code>arr</code>.
	 *
	 * @param dep
	 *		the tower index from which the disc will be moved
	 * @param arr
	 *		the tower index to which the disc will be moved		
	 */
	public void move(int dep, int arr){
		this.towers[arr].pileUp(this.towers[dep].pileDown());
	}

	/**
	 *
	 * returns <code>true</code> if the top disc of tower at index <code>dep</code> can be moved to
	 * tower at index <code>arr</code>
	 * @param dep
	 *		the tower index from which the function verifies if its top disc can move to the <code>arr</code> index tower
	 * @param arr
	 *		the tower index from which the function if it is possible or not to move the disc <code>dep</code> on it
	 *
	 * @return <code>true</code>if the top disc of <code>dep</code> can move to <code>arr</code>
	 */

	public boolean canMove(int dep, int arr){
		boolean valRet = false;
		if(!this.towers[dep].isEmpty()){
			if(this.towers[arr].isEmpty())
				valRet = true;
			else
				valRet = towers[dep].getTop().estPlusPetit(towers[arr].getTop());
		}
		return valRet;
	}

	public String toString(){
		int cpct = this.towers[0].getCapacity();
		int t1 = this.towers[0].getNbDiscs();
		int t2 = this.towers[1].getNbDiscs();
		int t3 = this.towers[2].getNbDiscs();
		Disc top1 = this.towers[0].getTop(); 
		Disc top2 = this.towers[1].getTop(); 
		Disc top3 = this.towers[2].getTop(); 
		String aff = "";
		
		for(int i=cpct;i>=1;i--){
			if(t1 >= i && top1 != null){
				if(top1.getTaille() < cpct){
					String tmp = this.genereSpace(cpct - top1.getTaille());
					aff += (tmp + (top1.toString()) + tmp);
				}else{
					aff += top1.toString();
				}
				top1 = top1.getDessous();
			}else{
				aff += this.genereLigneVide(cpct);
			}

			if(t2 >= i && top2 != null){
				if(top2.getTaille() < cpct){
					String tmp = this.genereSpace(cpct - top2.getTaille());
					aff += (tmp + (top2.toString()) + tmp);
				}else{
					aff += top2.toString();
				}
				top2 = top2.getDessous();
			}else{
				aff += this.genereLigneVide(cpct);
			}

			if(t3 >= i && top3 != null){
				if(top3.getTaille() < cpct){
					String tmp = this.genereSpace(cpct - top3.getTaille());
					aff += (tmp + (top3.toString()) + tmp);
				}else{
					aff += top3.toString();
				}
				top3 = top3.getDessous();
			}else{
				aff += this.genereLigneVide(cpct);
			}
			aff += "\n";
		}
		return aff;
	}

	private String genereSpace(int n){
		String tmp = "";
		for(int i = 1 ; i <= n ; i++){
			tmp += " ";
		}
		return tmp;
	}

	private String genereLigneVide(int n){
		String tmp = "";
		for(int i = 1 ; i <= n ; i++){
			tmp += " ";
		}
		tmp += "|";
		for(int i = 1 ; i <= n ; i++){
			tmp += " ";
		}
		return tmp;
	}
}