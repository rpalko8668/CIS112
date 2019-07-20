/********************
 * Program name:  ExtLLCollectionDriver.java
 * Author:        Robert Palko
 * Date:          2019-07-14
 *
 * Assignment:    p.343, #30
 * Description:   A test driver for the ExtendedLinkedCollection class.
 ********************/
 
 import java.util.Scanner;
 
 public class ExtLLCollectionDriver{
   
   public static void main(String[] args){
      
      int input;
      String value;
      
      ExtendedLinkedCollection<String> extLC = new ExtendedLinkedCollection<>();
      
      Scanner keyboard = new Scanner(System.in);
      
      System.out.println("Welcome to the ExtendedLinkedCollection test program!");
      
      do {
      
         System.out.print("Please select from the following options: \n\n" +
                           "1. Add an string to the collection. \n" +
                           "2. Check if the collection contains a specific string. \n" +
                           "3. Remove a string from the collection. \n" + 
                           "4. Get a string from the collection (non-removal). \n" + 
                           "5. Count how many occurrences of the string are in the collection (case sensitive). \n" + 
                           "6. Remove all of the same string from the collection. \n" +
                           "7. Combine the collection with the collection {\"alpha,\" \"beta,\" \"gamma\"}. \n" + 
                           "8. Get info about the collection. \n" + 
                           "9. Get the size of the collection. \n" + 
                           "0. Exit" + 
                           "\n\n" + 
                           "Enter the number of your choice: ");
         
         input = keyboard.nextInt();
                  
         //consume CR
         keyboard.nextLine();
         
         switch (input) {
            
            //add a string to the collection
            case 1:
               System.out.print("Enter a string to add to the collection: ");
               
               value = keyboard.nextLine();
               
               if (extLC.add(value))
                  System.out.println(value + " added to the collection.");
               
               else System.out.println("Unsuccessful add to the collection.");
            break;
            
            //check if the collection has the string
            case 2:
               System.out.print("Enter a string to search for: ");
               
               value = keyboard.nextLine();
               
               if (extLC.contains(value))
                  System.out.println(value + " is in the collection.");
               
               else System.out.println(value + " is not in the collection");
            break;
            
            //remove a matching string from the collection   
            case 3:
               System.out.print("Enter a string to remove from the collection: ");
               
               value = keyboard.nextLine();
                           
               if (extLC.remove(value))
                  System.out.println(value + " removed from the collection.");
               
               else System.out.println("Unsuccessful removal.");
               
            break;            
            
            //get a matching string from the collection
            case 4:
               System.out.print("Enter a string to search for: ");
               
               value = extLC.get(keyboard.nextLine());
               
               if (value != null)
                  System.out.println(value + " returned!");
               
               else System.out.println("Not in the collection."); 
            break;
            
            //count how many occurrences of the string
            case 5:
               int count = 0;
               
               System.out.print("Enter a string to search for: ");
               
               count = extLC.count(keyboard.nextLine());
               
               System.out.println(count + " matching string(s) in the collection.");
            break;
            
            //remove all matching strings from the collection
            case 6:
               System.out.print("Enter a string to remove from the collection: ");    
               
               value = keyboard.nextLine();
               
               extLC.removeAll(value);
               
               System.out.println("All instances of " + value + " (case sensitive) removed.");
            break;
            
            //combine collections
            case 7:
               ExtendedLinkedCollection<String> toCombine = new ExtendedLinkedCollection<>();
               
               toCombine.add("alpha");
               toCombine.add("beta");
               toCombine.add("gamma");
               
               extLC = extLC.combine(toCombine);
               
               System.out.println("Collections combined!");
            break;
            
            //print information about the collection
            case 8:
               System.out.println(extLC.toString());
            break; 
            
            //print the size of the collection            
            case 9:
               System.out.println("There are " + extLC.size() + " elements in the collection.");
            break;                                         
         }   
      }      
      while(input != 0);     
   }
 }
