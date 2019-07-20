/********************
 * Class name:    ExtendedArrayBoundedStack.java
 * Author:        Robert Palko
 * Date:          2019-06-16
 *
 * Assignment:    p.153, #28
 *
 * Description:   An extension of the ArrayBoundedStack with some extra methods.
 ********************/
import ch02.stacks.*;

public class ExtendedArrayBoundedStack<T> extends ArrayBoundedStack<T>{

   /*******
    * The empty constructor method. Calls the ArrayBoundedStack constructor to create the object.
    *******/ 
   public ExtendedArrayBoundedStack(){
      
      super();
   }
   /*******
    * The constructor method with a size parameter. Accepts two objects of a specified type and places them into the array.
    * 
    * @param maxSize The size of the array
    *******/ 
   public ExtendedArrayBoundedStack(int maxSize){
   
      super(maxSize);
   }
   
   /*******
    * toString method to display pertinent information about the current object
    *
    * @return A String with the length of the array, the amount of objects, and the "value" of those objects.
    *******/
   @Override
   public String toString(){
          
      String list = "The array has " + elements.length + " total spaces.\n" +
                     "There are " + (topIndex + 1) + " items currently in the array.\n" +
                     "They are:\n"; 
      
      //loop to add array values to the string only if there is infomation in the slot
      for(int i = 0; i < (topIndex + 1); i++)
      
         list += elements[i] + "\n";
         
      return list;  
   }
   
   /*******
    * The size method returns the size of the array
    *
    * @return The size of the array
    *******/   
   public int size(){
   
      return topIndex + 1;
   }
   
   /*******
    * The popSome method removes multiple elements from the top of the array
    *
    * @param count The number of elements to remove
    *******/ 
    
   public void popSome(int count){
      
      if(topIndex - 1 < count)
         throw new StackUnderflowException();
         
      else{
         for(int i = 0; i < count; i++){
      
            elements[topIndex] = null;
            topIndex--;
         }
      }
   }

   /*******
    * The swapStart method will swap the top two elements of an array if there are more than two. Otherwise it returns false.
    *
    * @return True/False based on whether the top two elements were swapped or not.
    *******/
   boolean swapStart(){
      
      if(topIndex < 1)
         return false;
      
      else{
         T temp = elements[topIndex];

         elements[topIndex] = elements[topIndex - 1];
         
         elements[topIndex-1] = temp;
         
         return true;
      }
   }
   
   /*******
    * The poptop method is the old school way of calling pop(). It removes the top element from the stack and returns it.
    *
    * @return The top element of the stack
    *******/
   public T poptop(){
   
      if(topIndex == -1)
         throw new StackUnderflowException();
      
      else{
         T topOfStack = null;

         topOfStack = elements[topIndex];
         
         elements[topIndex] = null;
         
         topIndex--;
         
         return topOfStack;
      }
   }
}