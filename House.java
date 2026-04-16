/* This is a stub for the House class */

import java.util.ArrayList;

public class House extends Building implements HouseRequirements{

  //house attributes
  private boolean hasDiningRoom;
  private ArrayList<Student> residents;

  /**
     * House constructor
     * @param hasDiningRoom Does the House have a dining room?
     * @param residents students in house
     */
    public House(String name, String address, int nFloors, boolean hasDiningRoom){
        super(name, address, nFloors);
        this.hasDiningRoom = hasDiningRoom;
        this.residents = new ArrayList<Student>();
        System.out.println("You have built a house: 🏠");
  }
    


  /**
  * Accessor for hasDiningRoom
  * @return hasDiningRoom() true/false if house has a dining room
  */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  /**
  * Accessor for residents
  * @return residents.size() number of residents in house
  */
  public int nResidents(){
    return residents.size();
  }

  /**
  * Adds a student to the list of residents
  */
  public void moveIn(Student s){
    if (residents.contains(s)){
      throw new RuntimeException("This student already lives here!");
    }
    else{
      residents.add(s);
    }
  }

  /**
  * Removes a student from the list of residents and returns the student removed
  * @return s student that has moved out
  */
  public Student moveOut(Student s){
    if (residents.contains(s)){
      residents.remove(s);
    }
    else{
      throw new RuntimeException("This student doesn't live here!");
    }
    return s;
  }

  /**
  * Indicates if a student lives in the house
  * @return boolean true/false if student is a resident of the house
  */
  public boolean isResident(Student s){
    if (residents.contains(s)){
      return true;
    }
    else{
      return false;
    }
  }
  
  

    

  public static void main(String[] args) {
    House gardiner = new House("Gardiner", "1 Paradise Rd", 4, false);
    Student em = new Student("emmarie", "999", 2026);
    Student de = new Student("devin", "997", 2026);
    gardiner.moveIn(em);
    gardiner.moveIn(de);
    System.out.println(gardiner.residents.contains(de));
  }


}