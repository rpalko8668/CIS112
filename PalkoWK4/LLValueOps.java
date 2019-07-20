/********************
 * Class name:    LLValueOps.java
 * Author:        Robert Palko
 * Date:          2019-06-27
 *
 * Assignment:    p.209, #16 - #17
 *
 * Description:   The LLValueOps class contains methods for operatin on a linked list of Integers.     
 ********************/
 
import support.LLNode;
 
public class LLValueOps{
   
   /*******
    * The numEvens method tallies all the even numbers in a linked list.
    *
    * @param LLNode<Integer> list a linked list of integers     
    *******/     
   public int numEvens(LLNode<Integer> list){
      
      if(list.getLink() == null){
         
         if(list.getInfo() % 2 == 0)
            return 1;
        
         else return 0;
      }
     
      else if (list.getInfo() % 2 == 0)
         return 1 + numEvens(list.getLink());
         
      else return 0 + numEvens(list.getLink());
   }
   
   /*******
    * The contains method determines if a specific value is in the linked list.
    *
    * @param int target the valie to search for
    * @param LLNode<Integer> list a linked list of integers     
    *******/     
   public boolean contains(int target, LLNode<Integer> list){
      
      if(list.getLink() == null){
         
         if (list.getInfo() == target)
            return true;
         
         else return false;
      }
      
      if(list.getInfo() == target)
         return true;
         
      else return contains(target, list.getLink());
   }     
}