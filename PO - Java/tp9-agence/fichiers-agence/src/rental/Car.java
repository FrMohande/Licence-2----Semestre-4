package rental;
import rental.Vehicle;
/**
 * @author : Mohand Outioua
 */

public class Car extends Vehicle{
	private int nbPlaces;
	public Car(String brand, String model, int productionYear, int dailyRentalPrice, int nbPlaces){
		super(brand,model,productionYear,dailyRentalPrice);
		this.nbPlaces = nbPlaces;
	}

	public int getNbPlaces(){
		return this.nbPlaces;
	}

	public boolean equals(Object o){
		return super.equals(o) && (((Car)o).nbPlaces == this.nbPlaces);
	}

	public String toString(){
		return super.toString() + " " + this.nbPlaces + " places";
	}
}
