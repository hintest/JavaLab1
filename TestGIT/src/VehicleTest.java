package vehicle;

import java.util.*;
import java.io.*;

/**
 *
 * Klasse som tester funksjonaliteten til programmet.
 *
 */

public class VehicleTest
{

  public static void main(String[] args)
  {
    VehicleTest vtest = new VehicleTest();
    try {
      vtest.menuLoop();
    }
    catch(java.io.IOException e) {
      System.out.println("IO Exception!");
      System.exit(1);
    }
  }

  private void menuLoop()
       throws java.io.IOException
  {
    Scanner scan = new Scanner(System.in);
    ArrayList<Vehicle> arr=new ArrayList<Vehicle>();
    Vehicle vehicle;

    // Legger til endel testkj�ret�y som en basis
    arr.add(new Car("Volvo 740","blue",85000,1985,"1010-11",120,0));
    arr.add(new Car("Ferrari Testarossa","red",1200000,1996,"A112",350,0));
    arr.add(new Bicycle("Monark 1","yellow",4000,1993,"BC100",10,0));
    arr.add(new Bicycle("DBS 2","pink",5000,1994,"42",10,0));

    while(true)
    {
        System.out.println("1....................................Ny bil");
        System.out.println("2.................................Ny sykkel");
        System.out.println("3........Finn og vis kj�ret�y med gitt navn");
        System.out.println("4.................Vis data om alle kj�ret�y");
        System.out.println("5...Endre retning p� kj�ret�y med gitt navn");
	    System.out.println("6...................................Avslutt");
	    System.out.println("Valg:");
	
		int choice=scan.nextInt();
	
		switch (choice){
	
		case 1:
		  System.out.println("Oppgi verdier for bilen.");
		  vehicle=new Car();
		  vehicle.setAllFields(); // m� v�re overridet
		  arr.add(vehicle);
		  break;
		case 2:
		  System.out.println("Oppgi verdier for sykkelen.");
		  vehicle=new Bicycle();
		  vehicle.setAllFields(); // m� v�re overridet
		  arr.add(vehicle);
		  break;
		case 3:
			// bruker skal kunne oppgi et navn p� et kj�ret�y og f� listet alle opplysninger
		  break;
		case 4:
		  // Vis alle modellnavn
		  break;
		case 5:
		  // Finn kj�ret�y med gitt navn, sett ny retning
		  break;
		case 6:
		  scan.close();
		  System.exit(0);
		default:
		  System.out.println("Feil inntasting!");
		}
    }
  }

}

