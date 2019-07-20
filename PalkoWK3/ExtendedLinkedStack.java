/********************
 * Class name:    ExtendedLinkedStack.java
 * Author:        Robert Palko
 * Date:          2019-06-20
 *
 * Assignment:    p.158, #47
 *
 * Description:   An extension of the ArrayBoundedStack with some extra methods.
 ********************/
 
import ch02.stacks.*;
import support.LLNode;

public class ExtendedLinkedStack<T> extends LinkedStack<T>{
   
   /*******
    * The empty constructor. Calls the LinkedStack constructor to create the object.
    *******/ 
   public ExtendedLinkedStack(){
      
      super();
   }
   
   /*******
    * toString method to display pertinent information about the list
    *
    * @return A String with the amount of objects in the list and the "info" in those objects.
    *******/
   @Override
   public String toString(){
      
      String list = "The stack contains the following data: \n";
      
      //pointer
      LLNode<T> currNode = top;
      
      //count variable to keep track of number of nodes in the list
      int nodeCount = 0;
      
      //loop to add node info to String. stops when there are no more nodes
      while(currNode != null){
         list += currNode.getInfo() + "\n";
         nodeCount++;
         currNode = currNode.getLink();
      }
      
      list += "Total nodes: " + nodeCount;
      
      return list;  
   }
   
   /*******
    * The size method returns the size of the list
    *
    * @return The size of the list
    *******/   
   public int size(){
   
      //pointer
      LLNode<T> currNode = top;   
      
      //counter
      int count = 0;
      
      //count how many nodes are in the list
      while(currNode != null){
         count++;
         currNode = currNode.getLink();
      }

      return count;
   }
   
   /*******
    * The popSome method removes multiple elements from the top of the array
    *
    * @param count The number of elements to remove
    *******/
   public void popSome(int count){
      
      //get size of list
      int size = size();
      
      //verify list is long enough to pop the requested amount. throw StackUnderflowException if it's not.
      if(count > size)
         throw new StackUnderflowException("Pop attempted on an empty stack.");
      
      else{
         for(int i = 0; i < count; i++)
            top = top.getLink();
      }
   }
   
  /*******
    * The swapStart method will swap the top two elements of a list if there are more than two. Otherwise it returns false.
    *
    * @return True/False based on whether the top two elements were swapped or not.
    *******/
   boolean swapStart(){
      
      int size = size();
      
      if(size < 2)
         return false;
      
      else{
      
         try{
            //create second reference to the first node
            LLNode<T> swapNode = top;
            
            //set first reference to the second node
            top = top.getLink();
            
            //set first link to match second's link
            swapNode.setLink(top.getLink());
            
            //set second's link to look at first node
            top.setLink(swapNode);
            
            //destroy duplicate reference
            swapNode = null;
            
            return true;
         }
         
         catch(Exception e){
            e.getMessage();
            return false;
         }
      } 
   }
   
   /*******
    * The poptop method is the old school way of calling pop(). It removes the top element from the stack and returns it.
    *
    * @return The top element of the stack
    *******/
   public T poptop(){
   
      if(top == null)
         throw new StackUnderflowException("Pop attempted on an empty stack.");
         
      else{
         LLNode<T> currNode = top;
         
         top = top.getLink();
         
         return currNode.getInfo();         
      }
   }
}