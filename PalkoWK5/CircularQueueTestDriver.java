/********************
 * Program name:  CircularQueueTestDriver.java
 * Author:        Robert Palko
 * Date:          2019-07-06
 *
 * Assignment:    p.290, #22
 * Description:   A test driver for the ExtendedLinkedQueue class.
 ********************/
 
 import java.util.Scanner;
 
 public class CircularQueueTestDriver{
   
   public static void main(String[] args){
      
      int input;
      int value;
      
      CircularQueue<Integer> cirQueue = new CircularQueue<>();
      
      Scanner keyboard = new Scanner(System.in);
      
      System.out.println("Welcome to the ExtendedLinkedQueue test program!");
      
      do {
      
         System.out.print("Please select from the following options: \n\n" +
                           "1. Add an integer to the queue. \n" +
                           "2. Remove the frontmost integer from the queue. \n" + 
                           "3. Check if the queue is empty. \n" + 
                           "4. Check if the queue is full. \n" +
                           "5. Get the length of the queue. \n" + 
                           "0. Exit" + 
                           "\n\n" + 
                           "Enter the number of your choice: ");
         
         input = keyboard.nextInt();
         
         switch (input) {
            
            //add an integer to the queue
            case 1:
               System.out.print("Enter an integer to add to the queue: ");
               
               value = keyboard.nextInt();
               
               cirQueue.enqueue(value);
               
               System.out.println(value + " added to the queue.");
            break;
            
            //remove the frontmost integer from the queue   
            case 2:
               value = cirQueue.dequeue();
               
               System.out.println(value + " removed from the queue.");
            break;
            
            //check if the queue is empty
            case 3:
               if(cirQueue.isEmpty())
                  System.out.println("The queue is empty.");
                  
               else 
                  System.out.println("The queue is not empty.");
            break;
            
            //check if the queue is full
            case 4:
               if(cirQueue.isFull())
                  System.out.println("The queue is full.");
                  
               else 
                  System.out.println("The queue is not full.");
            break;
            
            //print the size of the queue
            case 5:
               System.out.println("There are " + cirQueue.size() + " elements in the queue.");
            break;          
         }   
      }      
      while(input != 0);     
   }
 }