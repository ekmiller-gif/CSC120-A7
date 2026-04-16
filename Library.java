/* This is a stub for the Library class */

import java.util.Hashtable;

public class Library extends Builing implements LibraryRequirements{

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
        collection.put(title, true);
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

    public static void main(String[] args) {
      new Library();
    }
  
  }