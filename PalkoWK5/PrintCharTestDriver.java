/********************
 * Program name:  PrintCharTestDriver.java
 * Author:        Robert Palko
 * Date:          2019-07-08
 *
 * Assignment:    p.295, #45
 * Description:   The PrintCharTestDriver showcases the PrintChar class and threads.
 *                Thoughts on the experiment at the bottom of the program.
 ********************/
 
 public class PrintCharTestDriver{
   
   public static void main(String args[]) throws InterruptedException{
      
      char charOne = 'A';
      char charTwo = 'B';
      int numTimes = 200;
      
      PrintChar charA = new PrintChar(charOne, numTimes);
      
      PrintChar charB = new PrintChar(charTwo, numTimes);
      
      Thread printA = new Thread(charA);
      
      Thread printB = new Thread(charB);
      
      printA.start();
      printA.join();
      printB.start();
      printB.join();

      
      System.out.println();
      System.out.println("A: " + charA.actualPrint());
      System.out.println("B: " + charB.actualPrint());      
   }
 }
 
//**************************************************************
// As this program currently stands, it's running sequentially.
// I've ran numerous tests with moving the join() statements, or 
// removing them all together. These threads collide in all sorts
// of different, unprediectable ways! My two favorite examples:
//
// "AA: 0
//  BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB: 0
//  ABBBBBBBBBBBBBBBAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBBBAAAAAAAAAAAAAAAAAAAAAAAAA...(rest of letters print)"
//
// "BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBA: 0
//  BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAB: 168
//  AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
//
// In the first example, the "System.out.println("A: " + charA.actualPrint());" 
// statement printed before the blank line before it, that surprised me! 
//
// In the second, the "B" characters started printing first, then "A," 
// but when it came time to print the results of the counter, A 
// (which had printed a handful) showed 0, and B (which had finished) 
// only showed a counter of 168. 
//
// Overall, it's very interesting to get a glimpse of how much overhead 
// starting a new thread may take, as well as how fast certain actions 
// happen (like getting the counter to print). I think getting threads 
// to coordinate together in an expected matter without turning it into
// a sequential program is much more difficult than it looks!
//
//**************************************************************


