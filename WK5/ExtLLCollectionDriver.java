/********************
 * Class name:    ExtLLCollectionDriver.java
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
      int value;
      
      ExtendedLinkedQueue<Integer> extQueue = new ExtendedLinkedQueue<>();
      
      Scanner keyboard = new Scanner(System.in);
      
      System.out.println("Welcome to the ExtendedLinkedQueue test program!");
      
      do {
      
         System.out.print("Please select from the following options: \n\n" +
                           "1. Add an integer to the queue. \n" +
                           "2. Remove the frontmost integer from the queue. \n" + 
                           "3. Remove multiple integers from the front of the queue. \n" + 
                           "4. Swap the front two integers of the queue. \n" +
                           "5. Swap the first and last integer in the queue. \n" + 
                           "6. Get info about the queue. \n" + 
                           "7. Get the length of the queue. \n" + 
                           "0. Exit" + 
                           "\n\n" + 
                           "Enter the number of your choice: ");
         
         input = keyboard.nextInt();
         
         switch (input) {
            
            //add an integer to the queue
            case 1:
               System.out.print("Enter an integer to add to the queue: ");
               
               value = keyboard.nextInt();
               
               extQueue.enqueue(value);
               
               System.out.println(value + " added to the queue.");
            break;
            
            //remove the frontmost integer from the queue   
            case 2:
               value = extQueue.dequeue();
               
               System.out.println(value + " removed from the queue.");
            break;
            
            //remove multiple integers from the front of the queue   
            case 3:
               System.out.print("How many elements do you want to remove from the queue: ");
               
               value = keyboard.nextInt();
               
               extQueue.remove(value);
               
               System.out.println(value + " item(s) removed from the queue.");
            break;
            
            //swap the front two integers in the front of the queue
            case 4:
               if (extQueue.swapStart())
                  System.out.println("First two integers have swapped places.");
               
               else
                  System.out.println("Swap not successful.");
            break;
            
            //swap the first and last integers in the queue
            case 5:
               if (extQueue.swapEnds())
                  System.out.println("First and last integers have swapped places.");
               
               else
                  System.out.println("Swap not successful.");
            break;
            
            //print information about the queue
            case 6:
               System.out.println(extQueue.toString());
            break;
            
            //print the size of the queue
            case 7:
               System.out.println("There are " + extQueue.size() + " elements in the queue.");
            break;              
         }   
      }      
      while(input != 0);     
   }
 }
