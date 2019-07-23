/********************
 * Class name:    ExtendedBST.java
 * Author:        Robert Palko
 * Date:          2019-07-21
 *
 * Assignment:    p.493, #32
 * Description:   An extension of the BinarySearchTree class.
 ********************/

import ch07.trees.BinarySearchTree;
import java.util.Iterator;
import java.util.Comparator;
import support.BSTNode;
import ch04.queues.*;


public class ExtendedBST<T> extends BinarySearchTree<T>{

   /*******
    * Constructors. Call the BinarySearchTree constructors. 
    *******/
   public ExtendedBST(){
      super();
   }
   
   public ExtendedBST(Comparator<T> comp){
      super(comp);
   }
   
   /*******
    * publicRecHeight calls the recHeight method. 
    * It helps keep the protected variables hidden.
    *
    * @retun An int of the results from recHeight.
    *******/   
   public int publicRecHeight(){
      return recHeight(root);
   }

   /*******
    * recHeight recursively determines the height of the tree.
    *
    * @return An int that is the height of the tree
    *******/
   private int recHeight(BSTNode<T> node){
   
      //base case when we reach the end of a branch
      if (node == null)
         return 0;
      
      // Use Java's Math class to determine which side is greater, "left" or "right".
      // This is added to 1 (since this node is not null) and passed back up recursively.
      // Therefore, the greater of the two numbers (the deepest path) is always passed up.
      else return 1 + Math.max(recHeight(node.getLeft()), recHeight(node.getRight()));
   }
   
   /*******
    * The height method determines the height of the tree without recursion.
    * It utilizes two queues to keep track of the current row and the next. 
    *
    * @return An int that is the height of the tree
    *******/   
   public int height(){
   
      int counter = 0;
      
      BSTNode<T> node = root;
      
      // empty tree
      if (node == null)
         return 0;
         
      else{
         
         // queue of nodes in the current row to process
         LinkedQueue<BSTNode> toProcessQ = new LinkedQueue<>();
         
         // temporary hold for child nodes
         LinkedQueue<BSTNode> childQ = new LinkedQueue<>();
         
         // add root to processing queue
         toProcessQ.enqueue(node);
         
         // while theres more of the tree
         while (!toProcessQ.isEmpty()){
         
            // while theres more to process in this row
            while (!toProcessQ.isEmpty()){
               
               // get the next node
               node = toProcessQ.dequeue();
               
               // add children to child queue if they exist
               if (node.getLeft() != null)
                  childQ.enqueue(node.getLeft());
               
               if (node.getRight() != null)
                  childQ.enqueue(node.getRight());             
            }
            
            // if there are child nodes       
            while (!childQ.isEmpty()){
               
               // move elements from child queue to processing queue
               toProcessQ.enqueue(childQ.dequeue());
            }        
            
            // row processed, increment depth counter
            counter++;            
         }
         
         return counter;
      } 
   }
 
/*
This code is not needed, and a misunderstanding of the "minimum height" as described by the text.

It also doesn't work properly.
   
   public int publicMinHeight(){
      return recMinHeight(root);
   }
   
   private int recMinHeight(BSTNode<T> node){
      
      // end of branch
      if (node == null)
         return 0;
      
      // cases for only one child
      if (node.getLeft() == null)
         return 1 + recMinHeight(node.getRight());
      
      else if (node.getRight() == null)
         return 1 + recMinHeight(node.getLeft());         
      
      // two children
      else return 1 + Math.min(recMinHeight(node.getLeft()), recMinHeight(node.getRight()));
   }
*/
   
   /*******
    * The optimalMinHeight method determines the smallest height the tree can be
    *
    * @return An int that is the optimized height of the tree
    *******/      
   public int optimalMinHeight(){
      return (int) Math.round(Math.log(size())/Math.log(2));
   }
   
   /*******
    * The fRatio method calculates how out of balance a tree is.
    * A value of 1.0 is balanced; the lower it gets, the more unbalanced the tree.
    *
    * @return A float that is the ratio of the tree heights
    *******/    
   public float fRatio(){
      return ((float)optimalMinHeight()/recHeight(root));
   }
}