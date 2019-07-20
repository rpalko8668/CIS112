/********************
 * Program name:  RecursiveLLDriver.java
 * Author:        Robert Palko
 * Date:          2019-06-27
 *
 * Assignment:    p.209, #16 - #17
 *
 * Description:   The RecursiveLLDriver program is the driver for the LLValueOps class. 
 ********************/

import support.LLNode;

public class RecursiveLLDriver{
   
   public static void main(String[] args){
      
      // Create the predetermined linked list (I originally thought of a stack implementation, 
      // but could not think of a way to safely create a stack without using multiple references to the stack).
      LLNode<Integer> values = new LLNode<>(20);
      values = doNewNode(values, 19);
      values = doNewNode(values, 18);
      values = doNewNode(values, 15);
      values = doNewNode(values, 12);
      values = doNewNode(values, 9);
      values = doNewNode(values, 6);
      values = doNewNode(values, 6);
      values = doNewNode(values, 3);
      
      // Create LLValueOps to call recursive methods.
      // While a static call to the call would probably make more sense, this was my initial implementation.
      LLValueOps workList = new LLValueOps();
      
      int evenNumbers = workList.numEvens(values);
      
      boolean found = workList.contains(15, values);
   }
   
   /*******
    * The doNewNode method adds a new node to the front of the linked list.
    *
    * @param int the Integer value contained in the node
    * @param LLNode<Integer> list a linked list of Integers 
    *
    * @return the new linked list with the added node.    
    *******/    
   public static LLNode<Integer> doNewNode(LLNode<Integer> list, int num){
      
      // Create the new node
      LLNode<Integer> newNode = new LLNode<>(num);
      
      // Set the link of the new node to the front of the list
      newNode.setLink(list);
      
      // Move the previously used pointer to the front of the list
      // (This could be ommitted in theory and return newNode instead). 
      list = newNode;
      
      return list;
   }
      
}