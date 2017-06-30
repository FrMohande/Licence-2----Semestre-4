package rental;
import rental.Criterion;
/**
 * a PriceCriterion allows to select a vehicle if its daily rental price is lower than a given price
*/
public class PriceCriterion implements Criterion {
    private float price;
    /** @param price the maximal rental price */
    public PriceCriterion(float price) {
        this.price = price;
    }
    /**  @return <code>true</code> if v's daily rental price is lower than the maximal price
     * @see Criterion#isSatisfiedBy(Vehicle) 
     */
    public boolean isSatisfiedBy(Vehicle v) {
        return this.price > v.getDailyPrice();
    }
}
