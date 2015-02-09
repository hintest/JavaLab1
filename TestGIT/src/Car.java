package vehicle;

import java.util.Date;
import java.util.Scanner;

/**
 * Barneklasse av Vehicle
 * 
 */
public class Car extends VehicleFinal {
    private int power;
    private Date productionDate;
    
    //konstruktører
    public Car() {}
    public Car(String name, String color, int price, int model, String serialNr, int power, int direction) {
        super(name, color, price, model, serialNr, direction);
        this.power = power;
        this.productionDate = new Date();
    }

 

    //get
    public int getPower() { return power; }
    //set
    public void setPower(int power) { this.power = power; }
    
    public String toString() {
        String ret = super.toString();
        ret += "\nPower:\t\t" + power + "\nProdusert:\t" + productionDate; 
        return ret;
    }
 


    























 
   public void setAllFields() {
    	super.setAllFields();
        System.out.println("Power: ");
        this.power = scan.nextInt();
    }
    
        public void turnRight(int degrees) {
    	System.out.println("Car turning right: ");
    	if (degrees <= 360) {
        	direction += degrees; 
        	if (direction > 360) direction -= 360;	
    	}

    }
    public void turnLeft(int degrees) {
    	System.out.println("Car turning left: ");
       	if (degrees <= 360) {
        	direction -= degrees; 
        	if (direction < 0) direction += 360;	
    	}

    }
    @Override
    public Object clone() throws CloneNotSupportedException {
    	Car vehicleCopy = (Car)super.clone();
    	vehicleCopy.productionDate = (Date)(this.productionDate).clone();
    	return vehicleCopy;
    }

}
	