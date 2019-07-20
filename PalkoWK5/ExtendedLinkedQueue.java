/********************
 * Class name:    ExtendedLinkedQueue.java
 * Author:        Robert Palko
 * Date:          2019-07-06
 *
 * Assignment:    p.290, #22
 * Description:   An extension of the LinkedQueue class.
 ********************/
 
import ch04.queues.*;
import support.LLNode;

public class ExtendedLinkedQueue<T> extends LinkedQueue<T>{
   
   /*******
    * The empty constructor. Calls the LinkedQueue constructor to create the object.
    *******/ 
   public ExtendedLinkedQueue(){
      
      super();
   }
   
   /*******
    * toString method to display pertinent information about the queue
    *
    * @return A String with the amount of elements in the list and the "info" in those elements.
    *******/
   @Override
   public String toString(){
   
      //Add the number of elements to the return String   
      String info = "There are " + numElements + " elements in the queue. They are:\n";
      
      LLNode<T> stepThru = front;
      
      //add the info in the elements
      while (stepThru != null){
         
         info += "\t" + stepThru.getInfo() + "\n";
         
         stepThru = stepThru.getLink();
      }
               
      return info; 
   }
   
   /*******
    * The remove method removes the front elements from the queue
    *
    * @param count The number of elements to remove
    *******/   
   public void remove(int count){
   
      if (count > numElements)
         throw new QueueUnderflowException("Dequeue attempted on empty queue.");
      
      else{

         for(int i = 0; i < count; i++){
            
            front = front.getLink();
            
            numElements--;
         }  
      }                 
   }
   
   
  /*******
    * The swapStart method will swap the top two elements of the queue if there are more than two. Otherwise it returns false.
    *
    * @return True/False based on whether the top two elements were swapped or not.
    *******/
   boolean swapStart(){
      
      if(numElements < 2)
         return false;
      
      else{
         try{
            //create second reference to the first node
            LLNode<T> swapNode = front;
            
            //set front reference to the second node
            front = front.getLink();
            
            //set first link to match second's link
            swapNode.setLink(front.getLink());
            
            //set second's link to look at first node
            front.setLink(swapNode);
               
            //sets the rear pointer if there are only two elements in the queue
            if(numElements == 2)
               rear = swapNode;
            
            return true;
         }
         
         catch(Exception e){
            e.getMessage();
            return false;
         }    
      }      
   }
   
   /*******
    * The swapEnds method will swap the first and last elements of the queue if there are more than two. Otherwise it returns false.
    *
    * @return True/False based on whether the end elements were swapped or not.
    *******/
   boolean swapEnds(){
   
      if(numElements < 2)
         return false;
         
      else{
         try{
         /*
            //create a temp node of front
            LLNode<T> temp = front;
            
            //
            front = front.getLink();
            
            temp.setLink(null);
            
            rear.setLink(temp);
            
                                    
            return true;
            */
            
            T temp = front.getInfo();
            
            front.setInfo(rear.getInfo());
            
            rear.setInfo(temp);
            
            return true;
         }
         
         catch(Exception e){
            e.getMessage();
            return false;
         }
      }      
   }   
}