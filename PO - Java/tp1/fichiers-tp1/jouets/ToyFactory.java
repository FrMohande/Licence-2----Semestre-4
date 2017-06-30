 
/**
 * (Documentation should be in english...)
 * la classe Usine définit des fabriques de jouets
 * 
 * @author jc 
 * @version 1.0
 */ 
 

public class ToyFactory {
    // constructeurs de la classe ToyFactory
    /**
     * construit une usine sans marque spécifique ("generic")
     */
    public ToyFactory() {
    	this.brand = "generic";     // ou : this("generic");
    }
    public ToyFactory(String brand) {
        this.brand = brand;
    }
    
    // les attributs de la classe ToyFactory    
    /** la marque des jouets de l'usine
     * par defaut  la marque est "generique"
     */ 
    private String brand;
    
    // les methodes de la classe ToyFactory
    /** fabrique un nouveau jouet de la marque
     * @return le nouveau jouet fabrique
     */
    public Toy produce() {
        // creation d'un nouvel objet
        Toy toy = new Toy(brand);
        // on a la reference on peut donc acceder a son interface publique
        toy.display();
        // on peut renvoyer la reference de l'objet
        return toy;
    }
}
