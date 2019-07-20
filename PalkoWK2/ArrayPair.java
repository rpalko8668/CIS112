/********************
 * Class name:    ArrayPair.java
 * Author:        Robert Palko
 * Date:          2019-06-16
 *
 * Assignment:    p.150, #17
 *
 * Description:   ArrayPair uses the "blueprint" of the PairInterface to create an array that holds two objects
 *                of a specified type.
 ********************/

package PalkoWK2;

public class ArrayPair<T> implements PairInterface<T> {

   protected T[] pair = (T[]) new Object[2];    //create a generic array with two spots

   /*******
    * The constructor method. Accepts two objects of a specified type and places them into the array.
    * 
    * @param first The first object for the array
    * @param second The second object for the array.
    *
    *******/  
   public ArrayPair(T first, T second){

      pair[0] = first;

      pair[1] = second;
   }

   /*******
    * Get the first object.
    *
    * @return the specified object from its array slot 
    *******/
   public T getFirst() {

      return pair[0];
   }

   /*******
    * Get the second object.
    *
    * @return the specified object from its array slot 
    *******/
   public T getSecond() {

      return pair[1];
   }

   /*******
    * Set the first object. 
    *
    * @param first replaces the first object in the array
    *******/
   public void setFirst(T first) {

      pair[0] = first;
   }

   /*******
    * Set the second object. 
    *
    * @param second replaces the second object in the array
    *******/
   public void setSecond(T second) {

      pair[1] = second;
   }  
}