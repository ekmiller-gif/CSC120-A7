/* This is a stub for the Library class */

import java.util.Collection;
import java.util.Hashtable;
import java.util.Objects;
import java.util.function.BiConsumer;

public class Library extends Building implements LibraryRequirements{

    private Hashtable<String, Boolean> collection; // stores inventory of books and whther they are available or not
    /**
     * Constructor for Library
     * @param name \name of library
     * @param address \address of library
     * @param nFloors \floors in library
     */
    public Library(String name, String address, int nFloors) {
      super(name, address, nFloors);
      this.collection = new Hashtable<String, Boolean>();
      System.out.println("You have built a library: 📖");
    }

    /**
     * Adds a book to the library's collection
     * @param title title of book to be added to collection
     */
    public void addTitle(String title){
      if (collection.containsKey(title)){
        throw new RuntimeException("This title is already in the library's collection!");
      }
      else{
        collection.put(title, Boolean.TRUE);
      }
      
    }

    /**
     * Removes a book from the libary's collection
     * @param title title of book to be removed from collection
     */
    public String removeTitle(String title){
      if (collection.containsKey(title)){
        collection.remove(title);
      }
      else{
        throw new RuntimeException("This title is not in the libary's collection!");
      }
      return title;
    } 

    /**
     * Updates the status of a book when it is checked out
     */
    public void checkOut(String title){
      if (containsTitle(title) == true){
          if (collection.get(title).equals(Boolean.TRUE)){
              collection.replace(title, Boolean.TRUE, Boolean.FALSE);
          } else{
            throw new RuntimeException("Sorry, this title is unavailable.");
          }
      }else{
        throw new RuntimeException("Sorry, the library doesn't have this title.");
      }
    }

    /**
     * Updates the status of a book when it is returned.
     */
    public void returnBook(String title){
      if (containsTitle(title) == true){
          if (collection.get(title).equals(Boolean.FALSE)){
              collection.replace(title, Boolean.FALSE, Boolean.TRUE);
          } else{
            throw new RuntimeException("This title has already been returned.");
          }
      }else{
          throw new RuntimeException("This book does not belong to this library!");
      }
      
      // if (collection.contains(title)){
      //   Boolean status = collection.get(title);
      //   if (status.equals(Boolean.FALSE)){
      //     collection.replace(title, Boolean.FALSE, Boolean.TRUE);
      //   } else{
      //     throw new RuntimeException("This title has alreasy been returned.");
      //   }
      // }
      // else{
      //   throw new RuntimeException("This book does not belong to this library.");
      // }
    }

    /**
     * Tells whether a book is in the library's collection
     * @param title title of book
     * @return boolean true if the title appears as a key in the Libary's collection, false otherwise
     */
    public boolean containsTitle(String title){
      if (collection.containsKey(title)){
        return true;
      } else{
        return false;
      }
    }

    /**
     * Tells whether a book in the library is available
     * @param title title of book
     * @return boolean true if the title is currently available, false otherwise
     */
    public boolean isAvailable(String title){
      Boolean status = collection.get(title);

      if (collection.get(title).equals(Boolean.FALSE)){
          return false;
      } else{
          return true;
      }
    } 

    /**
     * Prints the entire collection of a library by title and checkout status
     */
    public void printCollection(){
      

      collection.forEach((title, value) -> { 
        String availability;
        if (collection.get(title).equals(Boolean.TRUE)){
          availability = "available";
        } else{
          availability = "unavailable";
        }
        System.out.println(title + ":" + availability); }); 
      }
    

    public static void main(String[] args) {
      Library neilson = new Library("Neilson Library", "1 Neilson Dr", 4);
        neilson.addTitle("Martyr!");
        neilson.addTitle("A Thousand Splendid Suns");
        neilson.addTitle("The Picture of Dorian Gray");
        neilson.addTitle("Crime and Punishment");
        neilson.addTitle("Their Eyes Were Watching God");

      System.out.println(String.valueOf(neilson.containsTitle("Martyr!")));
      System.out.println(String.valueOf(neilson.containsTitle("Crime and Punishment")));
      System.out.println(String.valueOf(neilson.isAvailable("Crime and Punishment")));

      // neilson.removeTitle("The Picture of Dorian Gray");
      // System.out.println(String.valueOf(neilson.containsTitle("The Picture of Dorian Gray")));

      neilson.checkOut("A Thousand Splendid Suns");
      System.out.println(String.valueOf(neilson.isAvailable("A Thousand Splendid Suns")));

      // neilson.returnBook("A Thousand Splendid Suns");
      // System.out.println(String.valueOf(neilson.isAvailable("A Thousand Splendid Suns")));

      // neilson.returnBook("Little Women");
      // neilson.returnBook("A Thousand Splendid Suns");

      neilson.printCollection();
      
    }
  }
  
  