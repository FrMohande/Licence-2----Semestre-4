
/**
 * Write a description of class Stock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stock
{
    private int quantity;
    
    public Stock() {
        this.quantity = 0 ;
    }
    
    
    /**
     * Cette méthode renvoie la quantité en stock
     * @return Quantité en stock
     */
    public int getQuantity() {
        return this.quantity ;
    }
    
    /**
     * 
     */
    public void add(int prmQuantity) {
        quantity += prmQuantity;
    }
    
    
    public int remove(int prmQuantity) {
        int valRet = 0;
        if(prmQuantity > quantity) {
            valRet = quantity;
            quantity = 0;
            
        } else {
            quantity -= prmQuantity;
            valRet = prmQuantity;
        }
        
        return valRet ;
    }
}
