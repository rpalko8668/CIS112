/********************
 * Class name:    EBayCLI.java
 * Author:        Robert Palko
 * Date:          2019-06-20
 *
 * Assignment:    p.158, #48
 *
 * Description:   This class mimics the aution process and is the program used for our LinkedLists. 
 ********************/
 
 import java.util.Scanner;
 import support.LLNode;
 
 public class EBayCLI{
 
  static Scanner keyboard = new Scanner(System.in);
   
  static ExtendedLinkedStack<Bid> bidStack = new ExtendedLinkedStack<>();
   
   public static void main(String[] args){
      
      String name = null;        //the bidder's name
      
      String highBidder = null;  //current high bidder
      
      final String QUIT = "X";   //indicates end of auction
      
      int amount;                //amount of the bid
      
      int highBid = 0;           //current high bid
      
      int maxBid = 0;            //current max bid
      
      int result = 0;            //bid result flag
      
      
      System.out.print("Please enter your name, or X to close bidding: ");

      name = keyboard.nextLine();
      
      //loop for the auction process
      while(!QUIT.equals(name)){           

         System.out.print("How much (in whole dollars) would you like to bid, " + name + "? ");
         
         amount = keyboard.nextInt();
            
         keyboard.nextLine();
         
         //new high bidder
         if(amount > maxBid){
         
            //record current high bidder
            highBidder = name;
            
            //set current high bid to old max bid + 1
            highBid = maxBid + 1;
            
            //set current max bid to amount
            maxBid = amount;
            
            result = 3;
            
            setBid(highBidder, highBid);
         }
         
         //high bid increased
         else if(amount > highBid){
            
            //set the high bid to the new amount
            highBid = amount;
            
            setBid(highBidder, highBid);
            
            result = 2;
         }
         
         //no change
         else result = 1;
         
         //process the results
         results(result);
         
         System.out.print("Please enter the next name, or X to close bidding: "); 
         
         name = keyboard.nextLine();     
      }
      
      bidResults();
   }
   
   /*******
    * The results method prints the results of the previous bid.
    *
    * @param result An integer corresponding to the result of the bid.
    *******/    
   public static void results(int result){
   
      switch(result){
         
         case 1: System.out.println("No change.");
            break;
         
         case 2: System.out.println("High bid increased!");
            break;
            
         case 3: System.out.println("New high bidder!!");
            break;
      }
   }
   
   /*******
    * The setBid method creates a Bid object for historical tracking
    *
    * @param name The name of the current high bidder
    * @param amount the amount of the curent high bid
    *******/    
   public static void setBid(String name, int amount){
      
      Bid newBid = new Bid(name, amount);
      
      bidStack.push(newBid);   
   }
   
   /*******
    * The bidResults method prints the results of the auction once it has concluded
    *******/     
   public static void bidResults(){
      
      System.out.println();
      System.out.println("-------------------");
      System.out.println("------RESULTS------");
      System.out.println("-------------------");
      System.out.println();
      System.out.println("Name" + "\t\t" + "Amount");
      
      Bid bid = null;
      
      while(!bidStack.isEmpty()){
         bid = bidStack.poptop();
         System.out.println(bid);
      }
   }
   
   
}