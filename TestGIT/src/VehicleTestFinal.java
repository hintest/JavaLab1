package vehicle;

/**
 * Oppretter bicycle og car objekter, legger disse i et array
 * Lar bruker manipulere data i arrayet p� forskjellige m�ter
 * 
 * @author Lars Hofs�y Breivik  
 * @version 1.0\o/
 */

import java.util.*;
import java.io.*;

public class VehicleTestFinal
{

  public static void main(String[] args)
  {
    VehicleTestFinal vtest = new VehicleTestFinal();
    try {
      vtest.menuLoop();
    }
    catch(java.io.IOException e) {
      System.out.println("IO Exception!");
      System.exit(1);
    }
    catch(CloneNotSupportedException e) {
        System.out.println("CloneNotSupportedException");
        System.exit(1);
      }
  }

  private void menuLoop()
       throws java.io.IOException, CloneNotSupportedException
  {
    Scanner scan = new Scanner(System.in);
    ArrayList<VehicleFinal> arr=new ArrayList<VehicleFinal>();
    VehicleFinal vehicle;

    arr.add(new Car("Volvo","Black",85000,2010,"1010-11",163,0));
    //arr.add(new Bicycle("Diamant","yellow",4000,1993,"BC100",10,0));
    arr.add(new Car("Ferrari Testarossa","red",1200000,1996,"A112",350,0));
    //arr.add(new Bicycle("DBS","pink",5000,1994,"42",10,0));
    VehicleFinal veh1 = new Car("BMW","Red",85000,2014,"1010-1101",220,180);
	VehicleFinal v1 = (VehicleFinal)veh1.clone();
	v1.setName("Audi");
	arr.add(veh1);
	arr.add(v1);
	java.util.Collections.sort(arr);

    while(true)
      {

        System.out.println("1....................................Ny bil");
        System.out.println("2.................................Ny sykkel");
        System.out.println("3........Finn og vis kj�ret�y med gitt navn");
        System.out.println("4.................Vis data om alle kj�ret�y");
        System.out.println("5...Endre retning p� kj�ret�y med gitt navn");
	    System.out.println("6...................................Avslutt");
	    System.out.println("Valg:");

    System.out.println("Hva �nsker du?");
    int choice = scan.nextInt();

    switch (choice) {

    case 1:
        //legg til en ny bil
    	vehicle = new Car();
        vehicle.setAllFields();
        arr.add(vehicle);
        break;
    case 2:
        //legg til en ny sykkel
        //vehicle=new Bicycle();
        //vehicle.setAllFields();
        //arr.add(vehicle);
        break;
    case 3:
        //vis info om gitt kj�ret�y
        System.out.println("Skriv inn navn p� kj�ret�y du �nsker info om: ");  
        String navn = scan.next();
        for (int i=0; i<arr.size(); i++) {
        	VehicleFinal veh = (VehicleFinal)arr.get(i);
            if(veh.getName().equals(navn))
                System.out.println(veh);
            }
            
      break;
    case 4:
        // Vis alle modellnavn
        for (int i=0; i<arr.size(); i++) { 
        	VehicleFinal veh = (VehicleFinal)arr.get(i);
            System.out.println(veh + "\n");
        }
    
        break;
    case 5:
        // Finn kj�ret�y med gitt navn, sett ny pris
        System.out.println("Skriv in navn p� kj�ret�y: ");
        navn = scan.next();
        System.out.println("Skriv in ny retning [H/V]: ");
        String leftRight = scan.next();
        System.out.println("Antall grader [0-360]: ");
        int degrees = scan.nextInt();
        for (int i=0; i<arr.size(); i++) {
        	VehicleFinal veh = (VehicleFinal)arr.get(i);
            if (veh.getName().equalsIgnoreCase(navn)){
            	if(leftRight.charAt(0) == 'H') veh.turnRight(degrees);
            	else veh.turnLeft(degrees);
                System.out.println("Ny retning for " + veh.getName() + " er: " + veh.direction);
            }
       }
             
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
