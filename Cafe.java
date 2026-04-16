/* This is a stub for the Cafe class */
public class Cafe extends Building implements CafeRequirements{

    private int nCoffeeOunces; 
    private int nSugarPackets; 
    private int nCreams; 
    private int nCups; 

    /** 
     * @param name name of cafe
     * @param address address of cafe
     * @param nFloors number of floors in cafe
     * @param nCoffeeOunces ounces of coffee in inventory
     * @param nSugarPackets number of sugar packets in inventory
     * @param nCreams number of servings of cream in inventory
     * @param nCups number of cups in inventory
    */
    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }
    
    public static void main(String[] args) {
        Cafe cc = new Cafe("CC Cafe", "1 Chapin Way", 1);
    }
    
}
