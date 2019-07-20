/********************
 * Class name:    SortedLinkedCollection.java
 * Author:        Robert Palko
 * Date:          2019-07-15
 *
 * Assignment:    p.343, #31
 * Description:   A sorted LinkedCollection class.
 ********************/
 
import support.LLNode;
import ch05.collections.CollectionInterface;
import java.util.Iterator;

public class SortedLinkedCollection<T> implements CollectionInterface<T>, Iterable{
   
   protected LLNode<T> head;       // head of the linked list
   protected int numElements;      // number of elements in this collection
   protected T element;            // used in comparison methods

   protected boolean found;        // true if target found, else false
   protected LLNode<T> location;   // node containing target, if found
   protected LLNode<T> previous;   // node preceding location
    
   public SortedLinkedCollection(){
   
      numElements = 0;
      
      head = null;   
   }
   
   /*******
    * The add method adds an element to the sorted collection.
    * It uses the natural order of the elements.
    *
    * @param element The element to add.
    * @return true if the add was successful.
    *******/    
   public boolean add (T element){
   
      LLNode<T> newNode = new LLNode<>(element); 
        
      // if the list is empty, make this node the head
      if (head == null){
         
         head = newNode;  
         
         numElements++;
      }
         
      else {
         
         location = head;
         
         while (location != null){
            
            //compare the elements in the collection and advance pointers
            if (location.getInfo().toString().compareTo(element.toString()) < 0){
               
               previous = location;
               location = location.getLink();                         
            }
            
            else break;               
         }
         
         // if new node needs to be inserted in the front
         if (location == head){
            
            newNode.setLink(location);
            
            head = newNode;
         }
         
         // insert the node in line
         else{
            
            newNode.setLink(location);
               
            previous.setLink(newNode);
         }
         
         numElements++;                  
      }
      
      return true;    
   }
   
   /*******
    * The finde method finds an element and sets the found variable for other methods.
    *
    * @param element The element to find.
    *******/    
   protected void find(T target){
      
      // reset search
      found = false;
      
      Iterator<T> iter = this.iterator();
      
      element = iter.next();
      
      // walk through collection
      while(iter.hasNext()){
         
         // advance if they are not a match
         if(!element.equals(target))            
            element = iter.next();
         
         // mark as found if they are a match
         else{
            found = true;
            break;
         }                  
      }
      
      //to check the last node
      if(element.equals(target))
         found = true;
   }
   
   /*******
    * The get method returns a matching element if it's in the collection.
    *
    * @param element The element to find.
    * @return The matching element to return. Returns null if not found.
    *******/   
   public T get(T target){
      
      find(target);
      
      if(found)
         return element;
      
      else return null;
   }
   
   /*******
    * The contains method calls find.
    *
    * @param element The element to find.
    * @return T/F if the element was found.
    *******/     
   public boolean contains (T target){
      
      find(target);  
      
      return(found);
   }
   
   /*******
    * The remove method removes an instance of the element from the collection.
    *
    * @param element The element to remove.
    * @return T/F if the element was removed. If the element is not in the list this returns false.
    *******/    
   public boolean remove (T target){
   
      Iterator<T> iter = this.iterator();   
         
      element = iter.next();
      
      // walk through collection until a match is found
      while(!element.equals(target)){
         
         if(iter.hasNext())            
            element = iter.next();
         
         // if we reach the end of the list with no match
         else return false;                 
      }    
         
      iter.remove();       
     
      return true;
   }
   
   /*******
    * The isFull method determines if the collection is full.
    *
    * @return True. A Linked List collection is never full.
    *******/    
   public boolean isFull(){
      return false;
   }
   
   /*******
    * The isEmpty method determines if the collection is empty.
    *
    * @return True if empty, otherwise false
    *******/      
   public boolean isEmpty(){
      return (numElements == 0);   
   }
   
   /*******
    * The size method returns the size of the collection.
    *
    * @return The number of elements in the collection
    *******/     
   public int size(){
      return numElements;
   }
   
   /*******
    * toString method
    *
    * @return Information about the collection
    *******/    
   public String toString(){
   
      String info = "";
      
      LLNode<T> stepThru = head;
      
      //add the info in the elements
      while (stepThru != null){
         
         info += stepThru.getInfo() + " ";
         
         stepThru = stepThru.getLink();
      }
      
      return info;      
   
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