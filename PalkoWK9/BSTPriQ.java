/********************
 * Class name:    BSTPriQ.java
 * Author:        Robert Palko
 * Date:          2019-08-04
 *
 * Assignment:    p.577, #8d
 * Description:   A binary search tree implementation of the Priority Queue ADT
 ********************/

import ch07.trees.BinarySearchTree;
import ch09.priorityQueues.*;
import java.util.*;

public class BSTPriQ<T> implements PriQueueInterface<T>{

   protected BinarySearchTree<T> treeQ;      // the underlying tree

   /*******
    * Constructors. Creates a comparator if none provided.
    *******/  
   public BSTPriQ(){
      treeQ = new BinarySearchTree();
   }
   
   public BSTPriQ(Comparator<T> comp){
      treeQ = new BinarySearchTree(comp);
   }
   
   /*******
    * Enqueue adds an element to the queue.
    *
    * @param T element The element to add.
    *******/    
   public void enqueue(T element){
      treeQ.add(element);
   }
   
   /*******
    * Dequeue removes the highest priority element from the queue
    *
    * @return T The highest priority element
    *******/    
   public T dequeue(){
      
      if (!treeQ.isEmpty()){
         
         // get the highest element in the tree
         T element = treeQ.max();
         
         treeQ.remove(element);
         
         return element;
      }
      
      else
         throw new PriQUnderflowException("dequeue attempted on an empty priority queue.");
   }
   
   /*******
    * isEmpty calculates if the queue is empty
    *
    * @return True if empty, otherwise false.
    *******/      
   public boolean isEmpty(){
      return treeQ.isEmpty();
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
    * Size calculates the size of the queue
    *
    * @return int The size of the queue
    *******/       
   public int size(){
      return treeQ.size();
   }
   
   /*******
    * toString provides pertinient information aboutr the queue
    *
    * @return String The information about the queue
    *******/       
   public String toString(){
      
      String temp = "\nPriority Queue: ";
      Iterator<T> iter = treeQ.iterator();
      
      while(iter.hasNext())         
         temp += (" " + iter.next());
         
      temp = temp + "\n";
      
      return temp;
   }
}