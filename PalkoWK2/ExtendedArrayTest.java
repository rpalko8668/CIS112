/********************
 * Program name:  ExtendedArrayTest.java
 * Author:        Robert Palko
 * Date:          2019-06-16
 *
 * Assignment:    p.153, #28
 *
 * Description:   A test program for ExtendedArray.
 ********************/

public class ExtendedArrayTest {
   
   public static void main(String[] args){
      
      //create a new ExtendedArrayBoundedStack with a size of 10.
      ExtendedArrayBoundedStack<String> testStack = new ExtendedArrayBoundedStack<>(10);
      
      //add some data to the stack
      testStack.push("numOne"); 
      testStack.push("numTwo");
      testStack.push("numThree");
      testStack.push("numFour");      
      
      //call toString() to display initial information
      System.out.println(testStack);
      
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