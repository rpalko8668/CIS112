/********************
 * Class name:    ExtendedLinkedCollection.java
 * Author:        Robert Palko
 * Date:          2019-07-14
 *
 * Assignment:    p.343, #30
 * Description:   An extension of the LinkedCollection class.
 ********************/
 
import ch05.collections.*;
import support.LLNode;
import java.util.Iterator;
 
public class ExtendedLinkedCollection<T> extends LinkedCollection<T> implements Iterable{
   
   public ExtendedLinkedCollection(){
      super();
   }
   
     
   @Override
   public String toString(){
   
      //Add the number of elements to the return String   
      String info = "There are " + numElements + " elements in the queue. They are:\n";
      
      LLNode<T> stepThru = head;
      
      //add the info in the elements
      while (stepThru != null){
         
         info += "\t" + stepThru.getInfo() + "\n";
         
         stepThru = stepThru.getLink();
      }
      
      return info;
   }
   
   public int count(T target){
      
      int targetCount = 0;
      
      LLNode<T> stepThru = head;
           
      while(stepThru != null){      
         
         if(stepThru.getInfo().equals(target))
            targetCount++;
            
         stepThru = stepThru.getLink();
      }
      
      return targetCount;
   }
   
   public void removeAll(T target){
   
      Iterator<T> iterator = new Iterator<>();
      
      while(iterator.hasNext()){
         
         iterator.next();
      }
      /* pre iterator code
      
      LLNode<T> stepThru = head;
      
      LLNode<T> prevNode = head;
      
      while(stepThru != null){       
         
         if(stepThru.getInfo().equals(target)){
            prevNode.setLink(stepThru.getLink());         
         }
                   
         stepThru = stepThru.getLink();
      }
      */               
   }
   
   public LinkedCollection<T> combine(LinkedCollection<T> other){
      
      if(this.head == null)
         return other;
         
      else if(other.head == null)
         return this;
         
      else{
         LinkedCollection<T> both = this;
         
         return both;
      }      
   }
   
   public Iterator<T> iterator(){
      
      return new Iterator<T>(){
         
         private LLNode<T> location = head;
         
         private LLNode<T> previous = location;
         
         public boolean hasNext(){
            return (location.getLink() != null);
         }
         
         public T next(){
         
            if(!hasNext())
               return null;
            
            else {
            
               previous = location; 
               
               location = location.getLink();
               
               return location.getInfo();
            }
         }
      };
   }
}
 
 
