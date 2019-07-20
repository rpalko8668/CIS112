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

   Iterator<T> iter;
             
   public ExtendedLinkedCollection(){
      super();
   }
     
   @Override
   public String toString(){
   
      //Add the number of elements to the return String   
      String info = "There are " + numElements + " elements in the list. They are:\n";
      
      LLNode<T> stepThru = head;
      
      //add the info in the elements
      while (stepThru != null){
         
         info += "\t" + stepThru.getInfo() + "\n";
         
         stepThru = stepThru.getLink();
      }
      
      return info;
   }
   
   /*******
    * The count method counts the number of an element contained in the collection.
    *
    * @param element The element to count.
    * @return The number of times the element is in the collection
    *******/    
   public int count(T target){
      
      //reset counter
      int counter = 0;
      
      LLNode<T> stepThru = head;
      
      //walk through the collection     
      while(stepThru != null){      
         
         //increase counter if a match
         if(stepThru.getInfo().equals(target))
            counter++;
            
         stepThru = stepThru.getLink();
      }
      
      return counter;
   }

   /*******
    * The removeAll method removes all instances of an element contained in the collection.
    *
    * @param element The element to remove.
    *******/   
   public void removeAll(T target){
      
      //iterator to walk through the collection  
      iter = this.iterator();
         
      T toCompare;
      
      while(iter.hasNext()){
      
         toCompare = iter.next();
         
         //remove if its a match
         if(toCompare.equals(target)){
               
            iter.remove();
         }
      }
   }
   
   /*******
    * The combine method combines this collection with another of the same type.
    *
    * @param other The other collection to add.
    * @return The combined collection
    *******/   
   public ExtendedLinkedCollection<T> combine(ExtendedLinkedCollection<T> other){
   
      //iterators for each collection
      iter = this.iterator();
      Iterator<T> otherIter = other.iterator();
      
      //if this collection is null, return the other
      if(this.head == null)
         return other;

      //if the other collection is null, return this one
      else if(!otherIter.hasNext())
         return this;
      
      //combine them   
      else{
         ExtendedLinkedCollection<T> both = new ExtendedLinkedCollection<T>();
         
         //walk through the other collection and add to the new combined one
         while(otherIter.hasNext()){
            
            T toAdd = (otherIter.next());
            
            LLNode<T> newNode = new LLNode<T>(toAdd);
            
            newNode.setLink(both.head);
            
            both.head = newNode;
            
            both.numElements++;
         }
         
         //walk through this collection and add to the new combined one
         while(iter.hasNext()){
            
            T toAdd = (iter.next());
            
            LLNode<T> newNode = new LLNode<T>(toAdd);
            
            newNode.setLink(both.head);
            
            both.head = newNode;
            
            both.numElements++;
         }
                  
         return both;
      }      
   }
 
   //anonymous inner class - Iterator  
   public Iterator<T> iterator(){
      
      return new Iterator<T>(){
         
         private LLNode<T> prevNode = null;
         
         private LLNode<T> currNode = null;
         
         private LLNode<T> nextNode = head;
         
         public boolean hasNext(){
            return (nextNode != null);
         }
         
         public T next(){
         
            if(!hasNext())
               throw new IndexOutOfBoundsException("Nothing next to return.");
            
            //the element we'll return   
            T element = nextNode.getInfo();
            
            //only move prevNode up if remove() was not called
            if (currNode != null)
               prevNode = currNode;
            
            //move currNode pointer up
            currNode = nextNode;
            
            //move nextNode pointer up
            nextNode = nextNode.getLink();
            
            return element;            
         }
         
         public void remove(){
            
            //if the current node doesn't exist to remove
            if (currNode == null)
               return;
            
            //if we're removing the front
            else if (prevNode == null) {
                  
               head = nextNode;
                  
               currNode = null;
                                
               numElements--;   
            }
            
            //removing from anywhere else in the list
            else {
               
               prevNode.setLink(nextNode);
               
               currNode = null;
               
               numElements--;
            } 
         }
      };
   }
}
 
 
