/********************
 * Program name:  PriQueueDriver.java
 * Author:        Robert Palko
 * Date:          2019-08-04
 *
 * Assignment:    p.577, #8a-d
 * Description:   Driver for the implementations of the Priority Queue ADT
 ********************/

public class PriQueueDriver{
   
   public static void main(String[] args){
      
      // implementations of Priority Queue
      UnsortArrayPriQ<String> unsortArray = new UnsortArrayPriQ<String>();
      UnsortLLPriQ<String> unsortLL = new UnsortLLPriQ<String>();
      SortedLLPriQ<String> sortLL = new SortedLLPriQ<String>();
      BSTPriQ<String> tree = new BSTPriQ<String>();
      
      // Unsorted Array
      System.out.println("-----STARTING UNSORTED ARRAY TEST-----");
      // zero elements
      System.out.println("Size: \t Expected: 0 \t Actual: " + unsortArray.size());
      System.out.println("Empty: \t Expected: true \t Actual: " + unsortArray.isEmpty());
      System.out.println(unsortArray.toString());
      // one element
      System.out.println("Add \'D\'");
      unsortArray.enqueue("D");      
      System.out.println("Size: \t Expected: 1 \t Actual: " + unsortArray.size());
      System.out.println("Empty: \t Expected: false \t Actual: " + unsortArray.isEmpty());
      System.out.println(unsortArray.toString());   
      // two elements   
      System.out.println("Add \'R\'");
      unsortArray.enqueue("R");      
      System.out.println("Size: \t Expected: 2 \t Actual: " + unsortArray.size());
      System.out.println(unsortArray.toString());    
      // multiple elements    
      System.out.println("Add \'U\'");
      unsortArray.enqueue("U");      
      System.out.println("Add \'M\'");
      unsortArray.enqueue("M");  
      System.out.println("Add \'S\'");
      unsortArray.enqueue("S");              
      System.out.println("Size: \t Expected: 5 \t Actual: " + unsortArray.size());
      System.out.println(unsortArray.toString()); 
      // remove elements and add one in between
      System.out.println("Remove: \t Expected: U \t Actual: " + unsortArray.dequeue());
      System.out.println("Add \'A\'");
      unsortArray.enqueue("A");
      System.out.println("Remove: \t Expected: S \t Actual: " + unsortArray.dequeue());
      System.out.println("Size: \t Expected: 4 \t Actual: " + unsortArray.size());      
      System.out.println(unsortArray.toString());
      System.out.println("-----END UNSORTED ARRAY TEST-----");     
      
      System.out.println();
      
      // Unsorted Linked List
      System.out.println("-----STARTING UNSORTED LINKED LIST TEST-----");
      // zero elements
      System.out.println("Size: \t Expected: 0 \t Actual: " + unsortLL.size());
      System.out.println("Empty: \t Expected: true \t Actual: " + unsortLL.isEmpty());
      System.out.println(unsortLL.toString());
      // one element
      System.out.println("Add \'D\'");
      unsortLL.enqueue("D");      
      System.out.println("Size: \t Expected: 1 \t Actual: " + unsortLL.size());
      System.out.println("Empty: \t Expected: false \t Actual: " + unsortLL.isEmpty());
      System.out.println(unsortLL.toString());   
      // two elements   
      System.out.println("Add \'R\'");
      unsortLL.enqueue("R");      
      System.out.println("Size: \t Expected: 2 \t Actual: " + unsortLL.size());
      System.out.println(unsortLL.toString());    
      // multiple elements    
      System.out.println("Add \'U\'");
      unsortLL.enqueue("U");      
      System.out.println("Add \'M\'");
      unsortLL.enqueue("M");  
      System.out.println("Add \'S\'");
      unsortLL.enqueue("S");              
      System.out.println("Size: \t Expected: 5 \t Actual: " + unsortLL.size());
      System.out.println(unsortLL.toString()); 
      // remove elements and add one in between
      System.out.println("Remove: \t Expected: U \t Actual: " + unsortLL.dequeue());
      System.out.println("Add \'A\'");
      unsortLL.enqueue("A");
      System.out.println("Remove: \t Expected: S \t Actual: " + unsortLL.dequeue());
      System.out.println("Size: \t Expected: 4 \t Actual: " + unsortLL.size());      
      System.out.println(unsortLL.toString());  
      System.out.println("-----END UNSORTED LINKED LIST TEST-----");
      
      System.out.println();
      
      // Sorted Linked List
      System.out.println("-----STARTING SORTED LINKED LIST TEST-----");
      // zero elements
      System.out.println("Size: \t Expected: 0 \t Actual: " + sortLL.size());
      System.out.println("Empty: \t Expected: true \t Actual: " + sortLL.isEmpty());
      System.out.println(sortLL.toString());
      // one element
      System.out.println("Add \'D\'");
      sortLL.enqueue("D");      
      System.out.println("Size: \t Expected: 1 \t Actual: " + sortLL.size());
      System.out.println("Empty: \t Expected: false \t Actual: " + sortLL.isEmpty());
      System.out.println(sortLL.toString());   
      // two elements   
      System.out.println("Add \'R\'");
      sortLL.enqueue("R");      
      System.out.println("Size: \t Expected: 2 \t Actual: " + sortLL.size());
      System.out.println(sortLL.toString());    
      // multiple elements    
      System.out.println("Add \'U\'");
      sortLL.enqueue("U");      
      System.out.println("Add \'M\'");
      sortLL.enqueue("M");  
      System.out.println("Add \'S\'");
      sortLL.enqueue("S");              
      System.out.println("Size: \t Expected: 5 \t Actual: " + sortLL.size());
      System.out.println(sortLL.toString()); 
      // remove elements and add one in between
      System.out.println("Remove: \t Expected: U \t Actual: " + sortLL.dequeue());
      System.out.println("Add \'A\'");
      sortLL.enqueue("A");
      System.out.println("Remove: \t Expected: S \t Actual: " + sortLL.dequeue());
      System.out.println("Size: \t Expected: 4 \t Actual: " + sortLL.size());      
      System.out.println(sortLL.toString());  
      System.out.println("-----END SORTED LINKED LIST TEST-----");    
      
      System.out.println();
      
      // Binary Search Tree
      System.out.println("-----STARTING BINARY SEARCH TREE TEST-----");
      // zero elements
      System.out.println("Size: \t Expected: 0 \t Actual: " + tree.size());
      System.out.println("Empty: \t Expected: true \t Actual: " + tree.isEmpty());
      System.out.println(tree.toString());
      // one element
      System.out.println("Add \'D\'");
      tree.enqueue("D");      
      System.out.println("Size: \t Expected: 1 \t Actual: " + tree.size());
      System.out.println("Empty: \t Expected: false \t Actual: " + tree.isEmpty());
      System.out.println(tree.toString());   
      // two elements   
      System.out.println("Add \'R\'");
      tree.enqueue("R");      
      System.out.println("Size: \t Expected: 2 \t Actual: " + tree.size());
      System.out.println(tree.toString());    
      // multiple elements    
      System.out.println("Add \'U\'");
      tree.enqueue("U");      
      System.out.println("Add \'M\'");
      tree.enqueue("M");  
      System.out.println("Add \'S\'");
      tree.enqueue("S");              
      System.out.println("Size: \t Expected: 5 \t Actual: " + tree.size());
      System.out.println(tree.toString()); 
      // remove elements and add one in between
      System.out.println("Remove: \t Expected: U \t Actual: " + tree.dequeue());
      System.out.println("Add \'A\'");
      tree.enqueue("A");
      System.out.println("Remove: \t Expected: S \t Actual: " + tree.dequeue());
      System.out.println("Size: \t Expected: 4 \t Actual: " + tree.size());      
      System.out.println(tree.toString());  
      System.out.println("-----END BINARY SEARCH TREE TEST-----");                          
   }
}