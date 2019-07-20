public class BidTest{
   
   public static void main(String[] args){
   
      Bid bidder = new Bid("Bobby", 25);
      
      System.out.println(bidder.getName());
      System.out.println(bidder.getAmount());
      
      bidder.setName("Erin");
      bidder.setAmount(27);
            
   }
}