/********************
 * Program name:  ExtendedLinkTest.java
 * Author:        Robert Palko
 * Date:          2019-06-20
 *
 * Assignment:    p.158, #47
 *
 * Description:   A test program for ExtendedLink.
 ********************/

public class ExtendedLinkTest {
   
   public static void main(String[] args){
      
      //create a new ExtendedLinkedStack
      ExtendedLinkedStack<String> testStack = new ExtendedLinkedStack<>();
      
      //add some data to the stack
      testStack.push("numOne"); 
      testStack.push("numTwo");
      testStack.push("numThree");
      testStack.push("numFour");      
      
      //call toString() to display initial information
      System.out.println(testStack);
      
      System.out.println(testStack.size());
      
      //call popSome(), popping the top 2.
      testStack.popSome(2);
      
      //put a couple more values on the stack
      testStack.push("numFive");
      testStack.push("numSix");   
      
      //call swapStart, swapping numFive and numSix
      testStack.swapStart();
      
      //remove the top element (numFive) and display it
      System.out.println(testStack.poptop());
      
      //final toString call to show the end result
      System.out.println(testStack);      
   }
}