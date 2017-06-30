package rental;

import static org.junit.Assert.*;
import rental.InterCriterion;
import org.junit.Test;
import org.junit.Before;

public class InterCriterionTest {
	private InterCriterion intercriterion;

	@Before
	public void before() {
		this.intercriterion = new InterCriterion() ;
	}
	@Test
	public void isSatisfiedBy() {
		Vehicle v1 = new Vehicle("Timoléon","model1",2015,150);
		Vehicle v2 = new Vehicle("Timoléon","model2",2000,200);
		Vehicle v3 = new Vehicle("brand3","model3",2000,100);

		this.intercriterion.addCriterion(new PriceCriterion(180)) ;
		this.intercriterion.addCriterion(new BrandCriterion("Timoléon")) ;

		assertTrue(this.intercriterion.isSatisfiedBy(v1));
		assertFalse(this.intercriterion.isSatisfiedBy(v2));
		assertFalse(this.intercriterion.isSatisfiedBy(v3));
	}
    
    // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
	return new junit.framework.JUnit4TestAdapter(rental.InterCriterionTest.class);
    }

}
