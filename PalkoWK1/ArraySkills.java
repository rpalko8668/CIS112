/*
 * Program file name: 		ArraySkills.java
 * Author: 					Robert Palko
 * Date: 					2019-06-09
 * 
 * Assignment: 				WK1 - Array Operation Review & Big-O 
 * 
 * Description:				This program manipulates arrays and the data in them in various ways. 				
 */

import java.util.*;

public class ArraySkills {

   public static void main(String[] args) {
   
      // ***********************
      // For each item below you must code the solution. You may not use any of the
      //  methods found in the Arrays class or the Collections classes
      //
   
      String[] myData;
      Scanner keyboard = new Scanner(System.in);
   
      // 1. Instantiate the given array to hold 10 Strings.
      myData = new String[10];
      
      // 2. Add your name to the Array at index 0 and a friend's name to the Array at index 4
      myData[0] = "Bobby";
 
      myData[4] = "Erin";
            
      // 3. Move your friend's name to index 0 in the array and "delete" their name from index 4
      myData[0] = myData[4];
      
      myData[4] = null;
      
      // 4. Fill up all of the remaining indeces in the array with more names
      myData[1] = "Dave";
      
      myData[2] = "John";
      
      myData[3] = "Bon";
      
      myData[4] = "Mike";
      
      myData[5] = "Justin";
      
      myData[6] = "Charles";
      
      myData[7] = "Lauren";
      
      myData[8] = "Chris";
      
      myData[9] = "Josh";
      
      // 5. Swap the values at index 5 and index 1
      
      //placeholder variable
      String swap;
      
      //place index 1 data into placeholder
      swap = myData[1];
      
      //move index 5 data to index 1
      myData[1] = myData[5];
      
      //move placeholder (index 1) data to index 5
      myData[5] = swap;
      
      // 6. Print the array from beginning to end.
      for(String name: myData)
         
         System.out.println(name);
      
      // 7. Shuffle the array of strings
      Random rand = new Random();
      
      //create temporary array for shuffled Strings
      String[] temp = new String[10];
      
      for(int i = 0; i < myData.length; i++){
      
    	 //grab a random number for the next index
         int randomIndex = rand.nextInt(10);
         
         //check if the spot in the temp array is empty and fill it with data.
         if(temp[randomIndex] == null)
            
            temp[randomIndex] = myData[i];
         
         //if the spot in the temp array is taken, reset the counter and try again.    
         else i--;         
      }
      
      //copy the shuffled array to ours
      //done instead of assigning variable so 1 variable per array 
      for(int i = 0; i < myData.length; i++)
      
         myData[i] = temp[i];       
      
      // 8. Find and print the longest and shortest Strings in the array
      String shortest = myData[0];
      
      String longest = myData[0];
      
      for(String name: myData){
      
         if (shortest.length() > name.length())
            
            shortest = name;
         
         if (longest.length() < name.length())
         
            longest = name;
      }
      
      System.out.println("The shortest name is " + shortest);
      
      System.out.println("The longest name is " + longest);
      
      // 9. Add up the total number of characters in all of the strings in the array and print the answer
      
      //accumulator
      int total = 0;
      
      for(String name: myData)
      
         total += name.length();
         
      System.out.println("The total number of characters is " + total);   
   
      // 10. Prompt the user for a String and then perform a linear search of the array
      //  to see if that string is or is not in the array. Print if it is or is not found.
      System.out.print("Please enter a name to search: ");
     
      String search = keyboard.nextLine();
      
      boolean found = false;
     
      for (String name: myData){
      
         if (name.equals(search)) {
         
            found = true;
            break;
         }
      }
      
      if (found)
            
            System.out.println(search + " was found!");
         
      else
         
            System.out.println(search + " was not found.");
      
      // 11. Remove the item at index 4 of the array by shifting everything after it one spot to the left.
      // This means your array should have one empty index at the end after the shift (delete the duplicate item at the end).
      
      for (int i = 4; i < myData.length; i++){
      
    	  //shift everything left one 
         if (i < myData.length - 1)      
            myData[i] = myData[i + 1];
         
         else if (i == myData.length - 1)
            myData[i] = null;
      }
      
      // 12. Create a new array that is twice as big as the current array and copy all of the items to the new array.
      // When complete, swap references so our old array gets garbage collected and the new array is pointed to by your array variable myData.
      String[] newData = new String[(myData.length * 2)];
      
      for (int i = 0; i < myData.length; i++)
      
         newData[i] = myData[i];
         
      myData = newData;
          
      // 13. Prompt the user to enter 2 numbers within the range of the array's length. If the first is larger than the second print backwards from that index to the first.
      // If the second is larger than the first, print forward in the array from the first index to the second.
      System.out.print("Enter a number between 0 and " + myData.length + ": ");
      
      int numOne = keyboard.nextInt();
      
      System.out.print("Enter a second (different) number between 0 and " + myData.length + ": ");
      
      int numTwo = keyboard.nextInt();
      
      if(numOne > numTwo)
      
         while(numOne >= numTwo){
         
            System.out.println(myData[numOne]);
            
            numOne--;
         }
      
      else if(numOne < numTwo)
      
         while(numOne <= numTwo){
         
            System.out.println(myData[numOne]);
            
            numOne++;
         }      
   }
}
