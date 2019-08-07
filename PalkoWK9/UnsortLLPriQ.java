/********************
 * Class name:    UnsortLLPriQ.java
 * Author:        Robert Palko
 * Date:          2019-08-04
 *
 * Assignment:    p.577, #8b
 * Description:   An unsorted linked list implementation of the Priority Queue ADT
 ********************/
import java.util.*;
import ch09.priorityQueues.*;
import support.LLNode;

public class UnsortLLPriQ<T> implements PriQueueInterface<T>{

   protected int numElements = 0;      // counter for number of elements in the list
   
   protected LLNode<T> head;           // pointer to the front of the queue
   protected LLNode<T> rear;           // pointer to the rear of the queue

   protected Comparator<T> comp;       // comparator
   

   /*******
    * Constructors. Creates a comparator if none provided.
    *******/    
   public UnsortLLPriQ(){
      
      head = null;
      rear = null;
      
      comp = new Comparator<T>(){
     
         public int compare(T element1, T element2){
            return ((Comparable)element1).compareTo(element2);
         }
      };
   }
   
   public UnsortLLPriQ(Comparator<T> comp){
      
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
      LLNode newNode = new LLNode(element);
      
      // if queue is empty make this the new head(and rear)
      if(isEmpty())
         head = rear = newNode;
      
      // otherwise add it to the rear
      else {
         rear.setLink(newNode);
         rear = newNode;
      }
      
      // increment counter
      numElements++;
   }
   
   /*******
    * Dequeue removes the highest priority element from the queue
    *
    * @return T The highest priority element
    *******/      
   public T dequeue(){
   
      if(!isEmpty()){
      
         // pointer to the highest priority node
         LLNode<T> highest = head;
         
         // pointer to the node right before highest in the list, used for easy removal
         LLNode<T> beforeHighest = null;
         
         // pointer to traverse ths list
         LLNode<T> scanQ = head;
         
         // pointer for the previous node scanned, used to set beforeHighest when highest gets updated
         LLNode<T> previous = null;
         
         // traverse the list
         while(scanQ != null){
            
            // if scanQ is greater than highest, update the highest pointers
            if (comp.compare(scanQ.getInfo(), highest.getInfo()) > 0){
               highest = scanQ;
               beforeHighest = previous;   
            }
            
            // increase traversal pointers              
            previous = scanQ;
            scanQ = scanQ.getLink();
         }
         
         // grab the info
         T element = highest.getInfo();
         
         // remove the highest from the queue
         beforeHighest.setLink(highest.getLink());
         
         // decrement counter
         numElements--;
         
         return element;
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