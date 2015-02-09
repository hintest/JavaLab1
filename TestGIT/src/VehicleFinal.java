package vehicle;

import java.util.Scanner;

/**
 * Farklasse til bil og sykkel
 */
public abstract class VehicleFinal implements Cloneable, Driveable, Comparable<VehicleFinal>{
    private String color, name, serialNr;
    private int model, price;
    protected int direction;
    Scanner scan = new Scanner(System.in);
    
    //konstruktører
    //public VehicleFinal() {}
    public VehicleFinal (String name, String color, int price, int model, String serialNr, int direction) {
        this.color = color;
        this.name = name;
        this.model = model;
        this.price = price;
        this.serialNr = serialNr;
        this.direction = direction;
    }
    
   public void setAllFields() {

        System.out.println("Navn:");
        this.name = scan.next();
        System.out.println("Farge:");
        this.color = scan.next();
        System.out.println("pris:");
        this.price = scan.nextInt();
        System.out.println("model:");
        this.model = scan.nextInt();
        System.out.println("serie nr:");
        this.serialNr = scan.next();

    }
    
    //Get metoder
    public String getName() { return name; }
    
    //Set metoder
    public void setName(String name) { this.name = name; }
    
    public String toString() {
        return "Navn:\t\t" + name + "\nModel:\t\t" + model + "\nSerie nummer:\t" + serialNr + "\nFarge:\t\t" + color + "\nPris:\t\t" + price 
        		+"\nRetning:\t" + direction;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
    	VehicleFinal vehicleCopy = (VehicleFinal)super.clone();
    	vehicleCopy.color = new String(this.color);
    	vehicleCopy.name = new String(this.name);
    	vehicleCopy.serialNr = new String(this.serialNr);
    	return vehicleCopy;
    }
    
    public abstract void turnLeft(int degrees);
    public abstract void turnRight(int degrees);
	public abstract void drive();
	public abstract void accelerate(int factor);
	public abstract void stop();
	public abstract void breaks(int factor);
	
	public int compareTo(VehicleFinal v){
		if(price > v.price) return 1;
		else if(price<v.price) return -1;
		else return 0;
	}

}
    
    
    
        
    