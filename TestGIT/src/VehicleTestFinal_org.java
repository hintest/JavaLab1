package vehicle;

/**
 * Oppretter bicycle og car objekter, legger disse i et array
 * Lar bruker manipulere data i arrayet pï¿½ forskjellige mï¿½ter
 * 
 * @author Lars Hofsï¿½y Breivik  
 * @version 1.0\o/
 */

import java.util.*;
import java.io.*;
//  import cs1.keyboard.*;

public class VehicleTestFinal_org
{

  public static void main(String[] args)
  {
    VehicleTestFinal_org vtest = new VehicleTestFinal_org();
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

    // Legger til endel testkjï¿½retï¿½y som en basis
    arr.add(new Car("Volvo","blue",85000,1985,"1010-11",120,0));
    arr.add(new Bicycle("Fiat","yellow",4000,1993,"BC100",10,0));
    arr.add(new Car("Ferrari Testarossa","red",1200000,1996,"A112",350,0));
    arr.add(new Bicycle("DBS 2","pink",5000,1994,"42",10,0));

    while(true)
      {

        System.out.println("1....................................Ny bil");
        System.out.println("2.................................Ny sykkel");
        System.out.println("3........Finn og vis kjøretøy med gitt navn");
        System.out.println("4.................Vis data om alle kjøretøy");
        System.out.println("5...Endre retning på kjøretøy med gitt navn");
	    System.out.println("6...................................Avslutt");
	    System.out.println("Valg:");

    System.out.println("Hva ï¿½nsker du?");
    int choice = scan.nextInt();
    // int choice = Keyboard.readInt("");

    switch (choice) {

    case 1:
        //legg til en ny bil
    	vehicle = new Car();
        vehicle.setAllFields();
        arr.add(vehicle);
        break;
    case 2:
        //legg til en ny sykkel
        vehicle=new Bicycle();
        vehicle.setAllFields();
        arr.add(vehicle);
        break;
    case 3:
        //vis info om gitt kjøretøy
        System.out.println("Skriv inn navn på kjøretøy du ønsker info om: ");  
        String navn = scan.next();
        for (int i=0; i<arr.size(); i++) {
            Vehicle veh = (Vehicle)arr.get(i);
            if(veh.getName().equals(navn))
                System.out.println(veh);
            }
            
      break;
    case 4:
        // Vis alle modellnavn
        for (int i=0; i<arr.size(); i++) { 
            Vehicle veh = (Vehicle)arr.get(i);
            System.out.println("navn: " + veh.getName() + "\n");
        }
    
        break;
    case 5:
        // Finn kjøretøy med gitt navn, sett ny pris
        System.out.println("Skriv in navn på kjøretøy:");
        String navn = scan.next();
        System.out.println("Skriv in ny retning:");
        //price = scan.nextInt();
        //Finner objekt med riktig verdi pï¿½ instansvariabelen navn, og setter prisen etter brukers ï¿½nske
        for (int i=0; i<arr.size(); i++) {
            Vehicle veh = (Vehicle)arr.get(i);
            if (veh.getName().equals(navn))
                veh.accelerate();
        }
             
        break;
    case 6:
        
        // Sorter pï¿½ navn - OBS bruk funksjonalitet som finnes!
        // Oppretter nytt array med instansvariablen name hentet fra objektene i arraylisten arr.
        // arrayet sorteres sï¿½ vha metoden sort   
        String[] names = new String[arr.size()];
        for(int i=0; i<arr.size(); i++) {
            names[i] = ((Vehicle)arr.get(i)).getName(); 
        }
        java.util.Arrays.sort(names);
        //Printer toString for alle objekter i arraylisten arr i stigende alfabetisk rekkefï¿½lge
        for (int i=0; i<arr.size(); i++) 
            for (int j=0; j<arr.size(); j++) {
                if(((Vehicle)arr.get(j)).getName().equals(names[i])) {
                                System.out.println((Vehicle)arr.get(j) + "\n\n"); 
                            }
           }
        
                // fikk ikke denne metoden til ï¿½ funke...
//           int min;
//                     
//           for(int i=0; i<arr.size(); i++) {
//               min = i;
//              for (int j=i+1; i<arr.size(); j++) {
//                 Vehicle veh1 = (Vehicle)arr.get(j);
//                 Vehicle veh2 = (Vehicle)arr.get(min);
//                 String name1 = veh1.getName();
//                 String name2 = veh2.getName();
//                 if (name1.compareTo(name2) > 0)
//                      min = j;
//              }
//                       
//              Object temp = arr.get(min);
//              arr.set(i, arr.get(min));
//              arr.set(min, arr.get(i));
//        }
    break;
    case 7:
        // Serialiser til fil
        String file = "vehicleNFO.txt";
        
        FileWriter fw = new FileWriter (file);
        BufferedWriter bw = new BufferedWriter (fw);
        PrintWriter outFile = new PrintWriter (bw);
        // sjekker om kjï¿½retï¿½yet er en bil eller sykkel printer sï¿½ riktig overskrift
        for (int i=0; i<arr.size(); i++) {
            if(arr.get(i) instanceof Car) { 
                outFile.println();
                outFile.println("---\t BIL: \t---");
            }
            if(arr.get(i) instanceof Bicycle) {    
                outFile.println();
                outFile.println("---\t SYKKEL: \t---");
            }
                
            Vehicle veh = (Vehicle)arr.get(i);
            outFile.println(veh);
        }
        outFile.close();
        System.out.println("Fil med info om samtlige kjï¿½retï¿½yer har blitt opprettet: " + file);
   
    break;     
    case 8:
        // leser fra fil
        try {
            File inputFile = new File("vehicleNFO.txt");
            FileReader in = new FileReader(inputFile); 
            int ch;
            char c;
            while ((ch = in.read()) != -1) {
                c = (char)ch;
                System.out.print(c);
            }
            in.close();
        }
        catch (Exception e) {
           System.out.println(e.getMessage());
        }
    break;  
    case 9:
      System.exit(0);
    default:
      System.out.println("Feil inntasting!");
    }
      }
  }

}
