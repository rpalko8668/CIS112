/********************
 * Class name:    Bid.java
 * Author:        Robert Palko
 * Date:          2019-06-20
 *
 * Assignment:    p.158, #48
 *
 * Description:   This class holds information pertinent to an auction. The class variables keep track of the current high bid
 *                and maximum bid. Instances keep track of the bidder's name and their bid. 
 ********************/
 
 public class Bid{
 
   protected String name;                 //the bidder's name
   
   protected int amount = 0;              //the bid amount
   
   /*******
    * Constructor. This creates a Bid object to hold a bidder's name and their bid.
    *
    * @param String name The bidder's name
    * @param int amount The bid amount
    *******/
   public Bid(String name, int amount){
      
      this.name = name;
      
      this.amount = amount;    
   }
   
   /*******
    * Get bidder's name
    *
    * @return The bidder's name
    *******/   
   public String getName(){
   
      return name;
   }
   
   /*******
    * Get bidder's bid amount
    *
    * @return The bidder's amount
    *******/     
   public int getAmount(){
   
      return amount;
   }
   
   /*******
    * Set bidder's name
    *
    * @param The bidder's new name
    *******/   
   public void setName(String name){
   
      this.name = name;
   }    
   
   /*******
    * Set bidder's amount
    *
    * @param The bidder's new amount
    *******/   
   public void setAmount(int amount){
   
      this.amount = amount;
   } 
   
   /*******
    * toString
    *
    * @@return A string representing the Bid.
    *******/  
   public String toString(){
      
      String data = getName() + "\t\t" + getAmount();
      
      return data;  
   }            
 }