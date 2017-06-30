package rental;

import rental.* ;

/**
 * @author : Mohand Outioua
 */
public class RentalMain {
	public static void main(String[] arg) {
		Client c1 = new Client("Outioua",20) ;
		Client c2 = new Client("Eddy",21) ;
		Client c3 = new Client("Amelie", 25 ) ;

		RentalAgency agence = new SuspiciousRentalAgency() ;

		//String brand, String model, int productionYear, int dailyRentalPrice, int nbPlaces
		//String brand, String model, int productionYear, int dailyRentalPrice, int cylinder
		Vehicle car = new Car("Toyota","Prius",2001,95,4) ;
		Vehicle car2 = new Car("Toyota","Aygo",2001,75,2) ;
		Vehicle car3 = new Car("Toyota","Corola",2001,250,4) ;
		Vehicle motorbike = new MotorBike("Kawasaki","Z800",2013,120,806) ;
		Vehicle motorbike2 = new MotorBike("Morini","Corsaro Veloce",2010,150,1200) ;
		Vehicle motorbike3 = new MotorBike("Mobylette","Moubilou",2010,50,50) ;
		Criterion cr = new PriceCriterion(100); 
		InterCriterion cr1 = new InterCriterion();
		cr1.addCriterion(new BrandCriterion("Toyota"));
		cr1.addCriterion(cr);

		System.out.println("**************************Question 5 et 6 de la partie TD du TP**************************\n");

		agence.addVehicle(car) ;
		agence.addVehicle(car2);
		agence.addVehicle(car3);
		agence.addVehicle(motorbike) ;
		agence.addVehicle(motorbike2) ;
		agence.addVehicle(motorbike3) ;
		System.out.println("Affichage des véhicules inférieurs à 100€ par jour\n");
		agence.displaySelection(cr);
		System.out.println();
		System.out.println("Affichage des véhicules de la marque Toyota inférieurs à 100€ par jour\n");
		agence.displaySelection(cr1);

		System.out.println("**************************Question 6 de la partie HERITAGE**************************\n");

		System.out.println("/-------------------Scénario 1 ---------------------/\n");
		System.out.println(c3.getName() +", "+ c3.getAge() + " ans loue le véhicule " + car + " au prix de " +agence.rentVehicule(c3,car) + "€");
		agence.returnVehicle(c3);
		System.out.println(c3.getName() + " rend le véhicule " + car);
		System.out.println(c1.getName() +", "+ c1.getAge() + " ans loue le véhicule " + car + " au prix de " +agence.rentVehicule(c1,car)+"€");
		agence.returnVehicle(c1);
		System.out.println(c1.getName() + " rend le véhicule " + car);
		System.out.println();

		System.out.println("/-------------------Scénario 2 ---------------------/\n");
		System.out.println(c2.getName() +", "+ c2.getAge() + " ans loue le véhicule " + motorbike + " au prix de " +agence.rentVehicule(c2,motorbike) + "€");
		agence.returnVehicle(c2);
		System.out.println(c2.getName() + " rend le véhicule " + motorbike);
		System.out.println(c1.getName() +", "+ c1.getAge() + " ans loue le véhicule " + motorbike + " au prix de " +agence.rentVehicule(c1,motorbike)+"€");
		agence.returnVehicle(c1);
		System.out.println(c1.getName() + " rend le véhicule " + motorbike);
		System.out.println();

		System.out.println("/-------------------Scénario 3 ---------------------/\n");
		System.out.println(c3.getName() +", "+ c3.getAge() + " ans loue le véhicule " + motorbike2 + " au prix de " +agence.rentVehicule(c3,motorbike2) + "€");
		agence.returnVehicle(c3);
		System.out.println(c3.getName() + " rend le véhicule " + motorbike2);
		System.out.println(c2.getName() +", "+ c2.getAge() + " ans loue le véhicule " + motorbike2 + " au prix de " +agence.rentVehicule(c2,motorbike2)+"€");
		agence.returnVehicle(c2);
		System.out.println(c2.getName() + " rend le véhicule " + motorbike2);

	}
}
