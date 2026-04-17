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
        this.nCoffeeOunces = 100;
        this.nSugarPackets = 50;
        this.nCreams = 50;
        this.nCups = 50;
        System.out.println("You have built a cafe: ☕");
    }
    
    /**
     * Setter for nCoffeeOunces
     * @param newCoffeeOunces updated amount of coffee in cafe
     */
    public void setCoffeeOunces(int newCoffeeOunces){
        this.nCoffeeOunces = newCoffeeOunces;
    }


    /**
     * Setter for nSugarPackets
     * @param newSugarPackets updated amount of sugar packets in cafe
     */
    public void setSugarPackets(int newSugarPackets){
        this.nSugarPackets = newSugarPackets;
    }

    /**
     * Setter for nCreams
     * @param newCreams updated amount of servings of cream in cafe
     */
    public void setCreams(int newCreams){
        this.nCreams = newCreams;
    }

    /**
     * Setter for nCups
     * @param newCups updated amount of cups in cafe
     */
    public void setCups(int newCups){
        this.nCups = newCups;
    }

    /**
     * Reduces the stock of items when a cup of coffee is sold
     * @param size size in ounces of the cup of coffee sold
     * @param nSugarpackets number of sugar packets used in the cup of coffee sold
     * @param nCreams number of servings of cream used in the cup  of coffee sold
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        this.restock(nCoffeeOunces, nSugarPackets, nCreams, nCups);

        int newCoffeeOunces = nCoffeeOunces - size;
        setCoffeeOunces(newCoffeeOunces);

        int newSugarPackets = this.nSugarPackets - nSugarPackets;
        setSugarPackets(newSugarPackets);

        int newCreams = this.nCreams - nCreams;
        setCreams(newCreams);

        int newCups = this.nCups - 1;
        setCups(newCups);
    }

    /**
     * Restocks items in cafe when necessary
     * @param nCoffeeOunces
     * @param nSugarPackets
     * @param nCreams
     * @param nCups
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        if (nCoffeeOunces <= 0){   
            int newCoffeeOunces = 100;
            setCoffeeOunces(newCoffeeOunces);
        }else if(nSugarPackets <= 0){
            int newSugarPackets = 50;
            setSugarPackets(newSugarPackets);
        }else if (nCreams <= 0){
            int newCreams = 50;
            setCreams(newCreams);
        }else if(nCups <= 0){
            int newCups = 50;
            setCups(newCups);
        }
    }

    public static void main(String[] args) {
        Cafe cc = new Cafe("CC Cafe", "1 Chapin Way", 1);
        cc.sellCoffee(12, 2, 1);
        System.out.println(cc.nCoffeeOunces);
        System.out.println(cc.nSugarPackets);
        System.out.println(cc.nCreams);
        System.out.println(cc.nCups);
    }
    
}
