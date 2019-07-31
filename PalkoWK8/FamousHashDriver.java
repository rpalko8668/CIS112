/********************
 * Class name:    FamousHashDriver.java
 * Author:        Robert Palko
 * Date:          2019-07-27
 *
 * Assignment:    p.548, #24a-e
 * Description:   Driver for hashing the FamousPerson class. Only the hash code
                  is saved in the array. File name is passes as command line
                  argument.
 ********************/

import java.io.*;
import java.util.*;
import ch06.lists.*;

public class FamousHashDriver{
   
   public static void main(String[] args) throws IOException{
      
      // create the sorted array
      SortedABList<Integer> famousPeopleHash = new SortedABList<>();
      
      // set up the file reading
      String fileName = args[0];
      FileReader inputFile = new FileReader(fileName);
      Scanner info = new Scanner(inputFile);
      
      // delimiters are commas, line feeds
      info.useDelimiter("[,\\n]");
      
      // set up the FamousPerson
      ExtFamousPerson person;
      String firstName, lastName, fact;
      int year;
      
      // read the info from the file, hash the class, and add the hash to the array
      while (info.hasNext()){
         
         // read info from file
         firstName = info.next();
         lastName = info.next();
         year = info.nextInt();
         fact = info.next();
         
         // create the class, hash, and add to the array
         person = new ExtFamousPerson(firstName, lastName, year, fact);
         famousPeopleHash.add(person.hashCode() % 10);
      }
      
      // print the results
      System.out.println();
      
      for (int hash: famousPeopleHash)
         System.out.println(hash);
   }
}

/*************************************************************************

Output of hashes in sorted order:

2268929
69640015
405148896
429955787
430202017
552637448
572490380
911257480
1038687573
1050600967
1054383946
1082160040
1403214279
1521908857
1568748212
1801550723
1898099354
1948775966
1960658654
2019100524
2024328856
2057502244
2096033344

Output when hash % 1000:

15
17
40
212
244
279
344
354
380
448
480
524
573
654
723
787
856
857
896
929
946
966
967

Output of hash % 100:

12
15
17
23
24
29
40
44
44
46
48
54
54
56
57
66
67
73
79
80
80
87
96

Output of hash % 10:

0
0
0
2
3
3
4
4
4
4
4
5
6
6
6
6
7
7
7
7
8
9
9

//////////////////////////////////////////

Obviously, the harder we compress, the smaller our hash values become.
This increases the chances for collisions; when compressing by % 10 almost
every value collides with another! Another thing to note (which isn't as 
easily seen by looking at just the integers), different compression values
will change the sorting. For example, with no compression, our lowest value 
is 2268929. If we compress that using the % 1000, it becomes 929, which is 
one of the higher values of the list! 

*************************************************************************/