/********************
 * Program name:  SortedLLCollectionDriver.java
 * Author:        Robert Palko
 * Date:          2019-07-15
 *
 * Assignment:    p.343, #31
 * Description:   A test driver for the SortedLinkedCollection class.
 ********************/
 
public class SortedLLCollectionDriver{
   
   public static void main(String[] args){
   
      SortedLinkedCollection<String> slc = new SortedLinkedCollection<>();
      
      System.out.println("Size expected: 0. Actual: " + slc.size());
      System.out.println("isEmpty() expected: true. Actual: " + slc.isEmpty());
      
      slc.add("alpha");
      slc.add("gamma");
      slc.add("beta");
      slc.add("delta");
      
      System.out.println("Added items in order \"alpha, gamma, beta, delta.\" Expected: alpha beta delta gamma. Actual: " + slc.toString());
      
      System.out.println("Finding \"theta.\" Expected: false. Actual: " + slc.contains("theta"));
      System.out.println("Finding \"gamma.\" Expected: true. Actual: " + slc.contains("gamma"));
      System.out.println("Finding \"beta.\" Expected: true. Actual: " + slc.contains("beta"));
      
      System.out.println("Calling get() for beta. Expected: beta. Actual: " + slc.get("beta"));
      System.out.println("Verifying non removal. Expected: alpha beta delta gamma. Actual: " + slc.toString());
      
      System.out.println("Size expected: 4. Actual: " + slc.size());
      System.out.println("isEmpty() expected: false. Actual " + slc.isEmpty());          
      System.out.println("isFull() expected: false. Actual " + slc.isFull());
        
      System.out.println("Removing alpha. Expected: true, beta delta gamma. Actual: " + slc.remove("alpha") + ", " + slc.toString());
      System.out.println("Removing theta. Expected: false, beta delta gamma. Actual: " + slc.remove("theta") + ", " + slc.toString());
      
      System.out.println("Adding alpha. Expected: true, alpha beta delta gamma. Actual: " + slc.add("alpha") + ", " + slc.toString());
   }   
}