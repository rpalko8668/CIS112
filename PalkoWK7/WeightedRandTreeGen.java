/********************
 * Program name:  WeightedRandTreeGen.java
 * Author:        Robert Palko
 * Date:          2019-07-21
 *
 * Assignment:    p.496, #49
 * Description:   An application that generates random trees with integer values between 1 and 3000.
 *                   Each set has a greater chance of a value that equals 42.
 ********************/

import java.util.Random;
import support.BSTNode;
import ch07.trees.*;

public class WeightedRandTreeGen{
   
   public static void main(String[] args){
     
      ExtendedBST<Integer> tree01;
      ExtendedBST<Integer> tree02;
      ExtendedBST<Integer> tree03;
      ExtendedBST<Integer> tree04;
      ExtendedBST<Integer> tree05;
      ExtendedBST<Integer> tree06;
      ExtendedBST<Integer> tree07;
      ExtendedBST<Integer> tree08;
      ExtendedBST<Integer> tree09;
      ExtendedBST<Integer> tree10;
      
      // loop for k percentages
      for (int k = 10; k < 100; k += 10){
      
         // reset the trees
         tree01 = new ExtendedBST<>();
         tree02 = new ExtendedBST<>();
         tree03 = new ExtendedBST<>();
         tree04 = new ExtendedBST<>();
         tree05 = new ExtendedBST<>();
         tree06 = new ExtendedBST<>();
         tree07 = new ExtendedBST<>();
         tree08 = new ExtendedBST<>();
         tree09 = new ExtendedBST<>();
         tree10 = new ExtendedBST<>();

         // fill the trees
         weightedFillTree(k, tree01);
         weightedFillTree(k, tree02);
         weightedFillTree(k, tree03);
         weightedFillTree(k, tree04);
         weightedFillTree(k, tree05);
         weightedFillTree(k, tree06);
         weightedFillTree(k, tree07);
         weightedFillTree(k, tree08);
         weightedFillTree(k, tree09);
         weightedFillTree(k, tree10);
      
         // print the results
         System.out.println("---RESULTS k:" + k + "---");
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
         
         System.out.println("Average Height: " + ((tree01.publicRecHeight() 
                                                + tree02.publicRecHeight() 
                                                + tree03.publicRecHeight() 
                                                + tree04.publicRecHeight()
                                                + tree05.publicRecHeight()
                                                + tree06.publicRecHeight()
                                                + tree07.publicRecHeight()
                                                + tree08.publicRecHeight()
                                                + tree09.publicRecHeight()
                                                + tree10.publicRecHeight()) / (double)10));
                                                
         System.out.println("Average fRatio: " + ((tree01.fRatio()
                                                + tree02.fRatio() 
                                                + tree03.fRatio() 
                                                + tree04.fRatio()
                                                + tree05.fRatio()
                                                + tree06.fRatio()
                                                + tree07.fRatio()
                                                + tree08.fRatio()
                                                + tree09.fRatio()
                                                + tree10.fRatio()) / (double)10));  
                                                
         System.out.println();                                                                                        
      }                                          
   }
   
   /*******
    * weightedFillTree fills the tree with 1000 random integers.
    * Every integer has a weighted percentage to be 42.
    *
    * @param int k The percentage chance for the integer to be 42.
    * @param ExtendedBST<Integer> tree The tree to fill
    *******/       
   public static void weightedFillTree(int k, ExtendedBST<Integer> tree){
      
      Random rand = new Random();
      
      int info = 0;
      
      for (int i = 0; i < 1000; i++){
         
         info = rand.nextInt(3000) + 1;
         
         // percent chance we'll place 42 into the tree
         if (rand.nextInt(100) < k)
            info = 42;
         
         tree.add(info);
      }   
   }
}

////////////////////////////////////////////////////////////////////
//
// Optimal height is what the book refers to as the minimum.
//
// There is definitely a correlation between the chance information
// is a duplicate and the height of the tree. The height appears to be
// directly proportional to the percentage of duplicate information.
// In cases where we need to store similar values frequently, a tree 
// may not be the best solution. I suppose a decision tree, where 
// the same "check" needs to be made multiple times might be one
// reason an unbalanced tree would be used. 
//
////////////////////////////////////////////////////////////////////