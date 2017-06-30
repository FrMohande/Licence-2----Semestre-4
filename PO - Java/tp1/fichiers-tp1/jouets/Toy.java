
/**
 * (Documentation should be in english...)
 * la classe Jouet definit ... des jouets
 * 
 * @author jc 
 * @version 1.0
 */
 

public class Toy {
    // constructeurs d'objets de la classe Toy
	
    /** constuit un jouet de la marque spécifiée
     * @param brand la maruqe du jouet
     */
    public Toy(String brand) {
        this.brand = brand;
    }
    /**
    
    // les attributs de la classe Toy
    /** la marque du jouet */
    private String brand;
    
    // les methodes de la classe Toy
    public void display() {
        System.out.println(this.toString());
    }
    
    public String toString() {
    	return "I am a toy of brand" + this.brand;
    }
}
