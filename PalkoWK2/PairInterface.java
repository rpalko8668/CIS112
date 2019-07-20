/********************
 * Class name:    PairInterface.java
 * Author:        Robert Palko
 * Date:          2019-06-16
 *
 * Assignment:    p.150, #17
 *
 * Description:   This is a simple interface for a class that holds a pair of objects of a specified type.
 ********************/

package PalkoWK2;

public interface PairInterface<T> {

    T getFirst();
    // Returns the first element of the pair

    T getSecond();
    // Returns the second element of the pair

    void setFirst(T first);
    // Sets the first element to a new object

    void setSecond(T second);
    // Sets the second element toa new object
}
