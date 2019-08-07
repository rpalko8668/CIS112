/********************
 * Class name:    UnsortArrayPriQ.java
 * Author:        Robert Palko
 * Date:          2019-08-04
 *
 * Assignment:    p.577, #8a
 * Description:   An unsorted array implementation of the Priority Queue ADT
 ********************/

import java.util.*;
import ch09.priorityQueues.*;

public class UnsortArrayPriQ<T> implements PriQueueInterface<T>{
   
   protected T[] elements;             // the uynderlying array structure
   protected final int DEFCAP = 100;   // default capacity for the array
   
   protected int numElements = 0;      // counter for number of elements in the array

   protected Comparator<T> comp;       // comparator

   /*******
    * Constructors. Builds the underlying array and a comparator if none provided.
    *******/    
   public UnsortArrayPriQ(){ 
   
      elements = (T[]) new Object[DEFCAP];
     
      comp = new Comparator<T>(){
     
         public int compare(T element1, T element2){
        
            return ((Comparable)element1).compareTo(element2);
         }
      };
   }

   /*******
    * Constructors
    *
    * @param Comparator<T> comp A user definied comparator
    *******/ 
   public UnsortArrayPriQ(Comparator<T> comp){
    
      elements = (T[]) new Object[DEFCAP];
     
      this.comp = comp;
   }
   
   /*******
    * Enlarge creates a larger array if needed to keep the queue unbounded.
    *******/    
   protected void enlarge(){
   
      // Create the larger array.
      T[] larger = (T[]) new Object[elements.length + DEFCAP];
    
      // Copy the contents from the smaller array into the larger array.
      for (int i = 0; i < numElements; i++)
         larger[i] = elements[i];
    
      // Reassign priority queue reference.
      elements = larger;
   }
  
   /*******
    * Enqueue adds an element to the queue.
    *
    * @param T element The element to add.
    *******/   
   public void enqueue(T element){
      
      // enlarge the array if needed
      if (numElements == elements.length)
         enlarge();

      // add elemenbt to the end of the array
      elements[numElements] = element;
     
      // increase counter     
      numElements++;  
   }
   
   /*******
    * Dequeue removes the highest priority element from the queue
    *
    * @return T The highest priority element
    *******/    
   public T dequeue(){
   
      if (!isEmpty()){
      
         // variables to hold information about the highest element
         T toReturn = elements[0];
         int location = 0;  
         
         // walk through the array      
         for (int i = 0; i < numElements; i++){
         
            T nextElement = elements[i];
            
            // if nextElement is greter in value than toReturn, update toReturn and its location
            if (comp.compare(toReturn, nextElement) < 0){
               toReturn = nextElement;
               location = i;
            }
         }
         
         // shift everything down the array after removal
         for (int i = location; i < numElements; i++)
            elements[i] = elements[i+1];
        
         // decerment counter
         numElements--;
         
         return toReturn;
      }
      else
         throw new PriQUnderflowException("dequeue attempted on an empty priority queue.");
   }

   /*******
    * Size calculates the size of the queue
    *
    * @return int The size of the queue
    *******/    
   public int size(){
      return numElements;
   }

   /*******
    * isEmpty calculates if the queue is empty
    *
    * @return True if empty, otherwise false.
    *******/ 
   public boolean isEmpty(){
      return (numElements == 0);  
   }

   /*******
    * isFull calculates if the queue is full
    *
    * @return False - this queue is unbounded.
    *******/ 
   public boolean isFull(){
      return false;
   }

   /*******
    * toString provides pertinient information aboutr the queue
    *
    * @return String The information about the queue
    *******/ 
   public String toString(){
   
      String temp = "\nPriority Queue: ";
      
      for (int i = 0; i < numElements; i++)
         temp = temp + "  " + elements[i];
      
      temp = temp + "\n";
      
      return temp;
  }      
}