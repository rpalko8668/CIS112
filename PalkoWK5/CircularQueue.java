/********************
 * Class name:    CircularQueue.java
 * Author:        Robert Palko
 * Date:          2019-07-07
 *
 * Assignment:    p.290, #25
 * Description:   A circular implementation of the Queue interface.
 ********************/

import support.LLNode;
import ch04.queues.*;
 
public class CircularQueue<T> implements QueueInterface<T>{
   
   protected LLNode<T> rear;        //reference to the rear of the queue. For some reason thinks there needs to be two variables; changing to "rearrr" removes the second. 
   protected int numElements = 0;   //number of elements in this queue   
   
   public CircularQueue(){
      
      rear = null;
   }
   
   /*******
    * The enqueue method adds an element to the queue.
    *
    * @param element The element to be added to the queue.
    *******/   
   public void enqueue(T element){
      
      LLNode<T> newNode = new LLNode<T>(element);
      
      if (rear == null){
         
         rear = newNode;
         
         rear.setLink(rear);
      }
         

      else{
      
         newNode.setLink(rear.getLink());      
         
         rear.setLink(newNode);
                  
         rear = newNode;
      }
      
      numElements++;
   }

   /*******
    * The dequeue method removes an element from the queue.
    * Throws QueueUnderflowException if the queue is empty.
    *
    * @return The element that was removed from the queue.
    *******/    
   public T dequeue(){

      if (isEmpty())
         throw new QueueUnderflowException("Dequeue attempted on empty queue.");
         
      else{
         
         T element;

         LLNode<T> front = rear.getLink();
         
         element = front.getInfo();
         
         rear.setLink(front.getLink());
         
         if (rear == front)
            rear = null;
            
         numElements--;
         
      return element;
      }
   }
   
   /*******
    * The isEmpty method determines if the queue is empty.
    *
    * @return True if empty, otherwise False.
    *******/    
   public boolean isEmpty(){
              
      return (rear == null);
  }

   /*******
    * The isFull method determines if the queue is full.
    * A LinkedList queue is never full; this is to comply with the interface.
    *
    * @return False. A linked queue is never full.
    *******/     
   public boolean isFull(){
              
      return false;
   }
   
   /*******
    * The size method determines the number of elements in the queue
    *
    * @return The number of elements in the queue. 
    *******/     
   public int size(){

      return numElements;
   }            
}