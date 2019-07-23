/********************
 * Program name:  RandTreeGen.java
 * Author:        Robert Palko
 * Date:          2019-07-21
 *
 * Assignment:    p.496, #48
 * Description:   An application that generates random trees with integer values between 1 and 3000.
 ********************/

import java.util.Random;
import support.BSTNode;
import ch07.trees.*;

public class RandTreeGen {
   
   public static void main(String[] args){
   
      // create the ten trees for the application
      ExtendedBST<Integer> tree01 = new ExtendedBST<>();
      ExtendedBST<Integer> tree02 = new ExtendedBST<>();
      ExtendedBST<Integer> tree03 = new ExtendedBST<>();
      ExtendedBST<Integer> tree04 = new ExtendedBST<>();
      ExtendedBST<Integer> tree05 = new ExtendedBST<>();
      ExtendedBST<Integer> tree06 = new ExtendedBST<>();
      ExtendedBST<Integer> tree07 = new ExtendedBST<>();
      ExtendedBST<Integer> tree08 = new ExtendedBST<>();
      ExtendedBST<Integer> tree09 = new ExtendedBST<>();
      ExtendedBST<Integer> tree10 = new ExtendedBST<>();
      
      // fill the trees
      fillTree(tree01);
      fillTree(tree02);
      fillTree(tree03);
      fillTree(tree04);
      fillTree(tree05);
      fillTree(tree06);
      fillTree(tree07);
      fillTree(tree08);
      fillTree(tree09);
      fillTree(tree10);      
      
      // print the results
      System.out.println("---48 RESULTS---");
      System.out.println("Tree 01:\t Height: " + tree01.publicRecHeight() + "\t Optimal Height: " + tree01.optimalMinHeight() + "\t Ratio: " + tree01.fRatio());                                                    
      System.out.println("Tree 02:\t Height: " + tree02.publicRecHeight() + "\t Optimal Height: " + tree02.optimalMinHeight() + "\t Ratio: " + tree02.fRatio());
      System.out.println("Tree 03:\t Height: " + tree03.publicRecHeight() + "\t Optimal Height: " + tree03.optimalMinHeight() + "\t Ratio: " + tree03.fRatio());
      System.out.println("Tree 04:\t Height: " + tree04.publicRecHeight() + "\t Optimal Height: " + tree04.optimalMinHeight() + "\t Ratio: " + tree04.fRatio());
      System.out.println("Tree 05:\t Height: " + tree05.publicRecHeight() + "\t Optimal Height: " + tree05.optimalMinHeight() + "\t Ratio: " + tree05.fRatio());
      System.out.println("Tree 06:\t Height: " + tree06.publicRecHeight() + "\t Optimal Height: " + tree06.optimalMinHeight() + "\t Ratio: " + tree06.fRatio());
      System.out.println("Tree 07:\t Height: " + tree07.publicRecHeight() + "\t Optimal Height: " + tree07.optimalMinHeight() + "\t Ratio: " + tree07.fRatio());
      System.out.println("Tree 08:\t Height: " + tree08.publicRecHeight() + "\t Optimal Height: " + tree08.optimalMinHeight() + "\t Ratio: " + tree08.fRatio());
      System.out.println("Tree 09:\t Height: " + tree09.publicRecHeight() + "\t Optimal Height: " + tree09.optimalMinHeight() + "\t Ratio: " + tree09.fRatio());
      System.out.println("Tree 10:\t Height: " + tree10.publicRecHeight() + "\t Optimal Height: " + tree10.optimalMinHeight() + "\t Ratio: " + tree10.fRatio());                                                      
   }
   
   /*******
    * fillTree fills the tree with 1000 random integers
    *
    * @param ExtendedBST<Integer> tree The tree to fill
    *******/    
   public static void fillTree(ExtendedBST<Integer> tree){
      
      Random rand = new Random();
      
      int info = 0;
      
      for (int i = 0; i < 1000; i++){
         
         info = rand.nextInt(3000) + 1;
         
         tree.add(info);
      }
   }
}

////////////////////////////////////////////////////////////////////
//
// Optimal height is what the book refers to as the minimum.
//
// The height and fRatio code can be found in the ExtendedBST.java file.
// 
// The fRatio method would be useful for an application to determine when to 
//    balance the tree. If the ratio falls below a certain threshold (say 0.5
//    for example), call the balance method to optimize the tree.
//
////////////////////////////////////////////////////////////////////