/********************
 * Program name:  RecursiveMath.java
 * Author:        Robert Palko
 * Date:          2019-06-27
 *
 * Assignment:    p.202, #02
 *
 * Description:   This program calculates some basic math functions in a recursive manner. 
 ********************/
 
 import java.util.Scanner;
 
 public class RecursiveMath{
 
   public static void main(String[] args){
   
      Scanner keyboard = new Scanner(System.in);
      int value;
      final String EXIT = "X";
      String retry = "";
      
      // Welcome text for the program
      System.out.println("Hello! I will compute the following for you, based on a number of your choosing: \n" +
                        "1. The sum of all positive numbers up to your number. \n" +
                        "2. 2 to the \"number\" power (i.e 2 to the 3rd power). \n" +
                        "3. Your number times 5.");
      
      // Loop to run while the user wishes to continue. Once the user enters X (case sensitive) the program exits.
      while(!retry.equals(EXIT)){
      
         System.out.print("Please enter a positive integer: ");

         value = keyboard.nextInt();
         keyboard.nextLine();
      
         System.out.println("----------");
         System.out.println("-RESULTS-");
         System.out.println("----------");
         System.out.println();
         
         // Call the sum method and print the result
         System.out.println("Sum: " + sum(value));
         
         // Call the biPower method and print the result
         System.out.println("Powered: " + biPower(value));
         
         // Call the timesFive method and print the result
         System.out.println("Times 5: " + timesFive(value));
         
         // Ask to contiunue the loop or to quit
         System.out.print("Press enter to try again, or X to quit: ");
         
         retry = keyboard.nextLine();     
      }               
   }
      
   /*******
    * The sum method adds up all the positive integers up to the number input by the user.
    *
    * @param int value The number to add up to
    *
    * Preconditions: The value must be greater than or equal to zero.     
    *******/   
   public static int sum(int value){
      
      if(value == 0)
         return 0;      
      
      else
         return value + sum(value - 1);
   }
   
   /*******
    * The biPower method calculates 2 to the nth power, where n is the number input by the user.
    *
    * @param int value The number power to raise 2 to
    *
    * Preconditions: The value must be greater than or equal to 0, and less than or equal to 30 (otherwise an overflow will occur).   
    *******/    
   public static int biPower(int value){
   
      if(value == 0)
         return 1;
      
      else
         return 2 * biPower(value - 1);
   }
   
   /*******
    * The timesFive method multiples the number input by the user by 5.
    *
    * @param int value The number to multiply by 5
    *
    * Preconditions: The value must be greater than or equal to 0.     
    *******/    
   public static int timesFive(int value){
   
      if(value == 0)
         return 0;
         
      else
         return 5 + timesFive(value - 1);
   }
 }