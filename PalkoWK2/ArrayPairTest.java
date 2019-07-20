/********************
 * Program name:  ArrayPairTest.java
 * Author:        Robert Palko
 * Date:          2019-06-16
 *
 * Assignment:    p.150, #17
 *
 * Description:   A test program to showcase ArrayPair and PairInterface
 ********************/

package PalkoWK2;

public class ArrayPairTest {

   public static void main(String[] args){

      //Create a new String ArrayPair and load it with two strings   
      PairInterface<String> stringPair = new ArrayPair<>("chocolate", "vanilla");

      //Use getFirst() and getSecond() to print the array contents
      System.out.println(stringPair.getFirst() + " " + stringPair.getSecond());

      //Change the value of the second array slot
      stringPair.setSecond("Strawberry");

      //Print the updated array contents
      System.out.println(stringPair.getFirst() + " " + stringPair.getSecond());


      //Create a new Integer ArrayPair and load it with two ints
      PairInterface<Integer> intPair = new BasicPair<>(100, 255);

      //Show array contents
      System.out.println(intPair.getFirst() + " " + intPair.getSecond());

      //Change the value of the first array slot
      intPair.setFirst(8);

      //Show updated array contents
      System.out.println(intPair.getFirst() + " " + intPair.getSecond());
   }
}
