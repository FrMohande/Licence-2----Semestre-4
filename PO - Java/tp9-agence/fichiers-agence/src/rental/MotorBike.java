package rental;
import rental.Vehicle;

/**
 * @author : Mohand Outioua
 */
public class MotorBike extends Vehicle{
	private int cylinder;
	public MotorBike(String brand, String model, int productionYear, int dailyRentalPrice, int cylinder){
		super(brand,model,productionYear,dailyRentalPrice);
		this.cylinder = cylinder;
	}

	public int getCylinder(){
		return this.cylinder;
	}

	public boolean equals(Object o){
		return super.equals(o) && (((MotorBike)o).cylinder == this.cylinder);
	}

	public String toString(){
		return super.toString() + " " + this.cylinder + " cm3";
	}
}
