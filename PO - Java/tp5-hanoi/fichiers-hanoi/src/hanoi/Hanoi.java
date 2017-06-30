package hanoi;
import hanoi.Plateau;
import hanoi.util.*;
import io.HanoiInput;

/**
 * Hanoi class : permits user to play with towers or resolve hanoi automatically (by recursion or iteration)
 * 
 * @author : Eddy El Khatib
 */

public class Hanoi {
	private Plateau plateauHanoi ;
	private int nbDiscs ;

	public static void main (String[] args){
		if(args.length >= 2){
			int n = Integer.parseInt(args[0]);
			if(n > 0){
				Hanoi jeu = new Hanoi(n);
				switch (args[1]){
					case "iterative" :
						System.out.println("Début de la résolution itérative\n");
						jeu.resolutionIterative();
						System.out.println("Fin de la résolution itérative");
						break;

					case "interactive" :
						System.out.println("Début de la résolution Interactive, bonne chance ;)\n");
						jeu.resolutionInteractive();
						break;

					case "recursive" :
						System.out.println("Début de la résolution récursive\n");
						jeu.resolutionRecursive();
						System.out.println("Fin de la résolution récursive");
						break;

					default :
				}
			}
		}
	}
	/**
	 * Hanoi object constructor
	 * 
	 */

	public Hanoi(int nbDiscs){
		this.plateauHanoi = new Plateau(nbDiscs);
		this.nbDiscs = nbDiscs;
	}

	/**
	 * resolves hanoi towers iteratively
	 *
	 */
	public void resolutionIterative(){
		int a=(int)Math.pow(2,this.nbDiscs);
		this.affichage();
		if((nbDiscs % 2) == 0){
			for(int i=1;i<=((a-1)/3);i++){
				/*déplacement de tour 1 vers tour 2 si possible, sinon inverse*/
				if(this.plateauHanoi.canMove(0,1))
					this.plateauHanoi.move(0,1);
				else
					this.plateauHanoi.move(1,0);
				this.affichage();
				/*déplacement de tour 1 vers tour 3 si possible, sinon iRverse*/
				if(this.plateauHanoi.canMove(0,2))
					this.plateauHanoi.move(0,2);
				else
					this.plateauHanoi.move(2,0);
				this.affichage();
				/*déplacement de tour 2 vers tour 3 si possible, sinon inverse*/
				if(this.plateauHanoi.canMove(1,2))
					this.plateauHanoi.move(1,2);
				else
					this.plateauHanoi.move(2,1);
				this.affichage();
			}
		}else{
			for(int i=1;i<=((a-2)/3);i++){
				/*déplacement de tour 1 vers tour 3 si possible, sinon inverse*/
				if(this.plateauHanoi.canMove(0,2))
					this.plateauHanoi.move(0,2);
				else
					this.plateauHanoi.move(2,0);
				this.affichage();
				/*déplacement de tour 1 vers tour 2 si possible, sinon inverse*/
				if(this.plateauHanoi.canMove(0,1))
					this.plateauHanoi.move(0,1);
				else
					this.plateauHanoi.move(1,0);
				this.affichage();
				/*déplacement de tour 2 vers tour 3 si possible, sinon inverse*/
				if(this.plateauHanoi.canMove(1,2))
					this.plateauHanoi.move(1,2);
				else
					this.plateauHanoi.move(2,1);
				this.affichage();
			}
			/*déplacement de la tour 1 vers la tour 3*/
			this.plateauHanoi.move(0,2);
			this.affichage();
			
		}
	}

	/**
	 * resolves hanoi towers recursively by calling private method hanoiRecursif with the appropriate parameters
	 *
	 */
	public void resolutionRecursive(){
		
		this.affichage();
		this.hanoiRecursif(this.nbDiscs, 0, 2, 1);
	}

	/**
	 * resolves hanoi towers with <code>n</code> discs recursively 
	 *
	 */

	private void hanoiRecursif(int n, int dep, int arr, int inter){
		if(n>0){
			hanoiRecursif(n-1, dep, inter, arr);
			this.plateauHanoi.move(dep,arr);
			this.affichage();
			hanoiRecursif(n-1, inter, arr, dep);
		}
	}

	private void affichage(){
		System.out.println(this.plateauHanoi);
	}

	public void resolutionInteractive(){
		HanoiInput hanInput = new HanoiInput();
		this.affichage();
		hanInput.readInput();
		while(hanInput.isMove()){
			if(this.plateauHanoi.canMove(hanInput.getFrom(), hanInput.getTo())){
				this.plateauHanoi.move(hanInput.getFrom(), hanInput.getTo());
				this.affichage();
			}
			else
				System.out.println("	!");
			hanInput.readInput();
		}

	}
}