/********************
 * Class name:    SortedLLPriQ.java
 * Author:        Robert Palko
 * Date:          2019-08-04
 *
 * Assignment:    p.577, #8c
 * Description:   A sorted linked list implementation of the Priority Queue ADT
 ********************/

import java.util.*;
import ch09.priorityQueues.*;
import support.LLNode;

public class SortedLLPriQ<T> implements PriQueueInterface<T>{

   protected int numElements = 0;      // counter for number of elements in the list
      
   protected LLNode<T> head;           // pointer to the front of the queue
   protected LLNode<T> rear;           // pointer to the rear of the queue
   
   protected Comparator<T> comp;       // comparator
   
   /*******
    * Constructors. Creates a comparator if none provided.
    *******/   
   public SortedLLPriQ(){
   
      head = null;
      rear = null;
      
      comp = new Comparator<T>(){
     
         public int compare(T element1, T element2){
            return ((Comparable)element1).compareTo(element2);
         }
      };         
   }
   
   public SortedLLPriQ(Comparator<T> comp){
      
      head = null;
      rear = null;
      
      this.comp = comp;
   }
   
   /*******
    * Enqueue adds an element to the queue.
    *
    * @param T element The element to add.
    *******/    
   public void enqueue(T element){
      
      // new node to add
      LLNode<T> newNode = new LLNode<T>(element);
      
      // if the list is empty, set pointers to this node
      if (isEmpty())
         head = rear = newNode;
      
      else{

         // traversal pointers for insertion
         LLNode<T> scanQ = head;   
         LLNode<T> previous = null;
         
         while (scanQ != null){
         
            // if scanQ is lower than the new node, we've reached our insertion point.
            // I'm not using "less than or equal to" so older elements are higher in the queue.
            if (comp.compare(scanQ.getInfo(), newNode.getInfo()) < 0){

               newNode.setLink(scanQ);
               
               // case for head of the queue, add the node and break the loop
               if (previous == null){
                  head = newNode;
                  break;
               }
               
               // case for the middle of the queue, add the node and break the loop
               else{
                  previous.setLink(newNode);
                  break;
               }                 
            }
            
            // reached the end of the queue without a match, add the node and break the loop
            else if (scanQ.getLink() == null){
               scanQ.setLink(newNode);
               rear = newNode;
               break;
            }
            
            // move the pointers up
             previous = scanQ;
             scanQ = scanQ.getLink();
         }
      }
      
      // increment counter     
      numElements++;
   }
   
   /*******
    * Dequeue removes the highest priority element from the queue.
    * Queue is sorted in decreasing order, so this is the front of the queue.
    *
    * @return T The highest priority element
    *******/     
   public T dequeue(){
      
      if(!isEmpty()){
         
         // grab the element from the head node
         T element = head.getInfo();
         
         // remove the nead node from the queue
         head = head.getLink();
         
         // decrement counter
         numElements--;
         
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
      return (head == null);
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
      return numElements;
   }
   
   /*******
    * toString provides pertinient information aboutr the queue
    *
    * @return String The information about the queue
    *******/    
   public String toString(){

      String temp = "\nPriority Queue: ";
      LLNode<T> info = head;
      
      while(info != null){
         temp += (" " + info.getInfo());
         info = info.getLink();
      }
      
      temp = temp + "\n";
      
      return temp;
   }     
}