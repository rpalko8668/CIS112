/********************
 * Class name:    PrintChar.java
 * Author:        Robert Palko
 * Date:          2019-07-08
 *
 * Assignment:    p.295, #45
 * Description:   The PrintChar class prints a requested character a certain amount of times.
 ********************/
 
 public class PrintChar implements Runnable{
   
   char toPrint;
   int numTimes;
   int timesPrinted = 0;
     
   /*******
    * Constructor. Loads instance variables.
    *
    * @param toPrint The character to print
    * @param numTimes The amount of times to print the character
    *******/     
   public PrintChar(char toPrint, int numTimes){
      
      this.toPrint = toPrint;
      
      this.numTimes = numTimes;
   }
   
   /*******
    * The run method. Prints the character in the toPrint variable
    * the number of times stated by the numTimes variable.
    *******/      
   public void run(){
      
      for(int i = 0; i < numTimes; i++){
         
         System.out.print(toPrint);
         
         timesPrinted++;
      }
   }
   
   public int actualPrint(){
      return timesPrinted;
   }
 }