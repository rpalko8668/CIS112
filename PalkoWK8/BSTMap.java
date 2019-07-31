/********************
 * Class name:    BSTMap.java
 * Author:        Robert Palko
 * Date:          2019-07-24
 *
 * Assignment:    p.546, #10d
 * Description:   A Binary Search Tree implementation of a Map
 ********************/
 
 import ch08.maps.*;
 import ch07.trees.*;
 import java.util.*;
 
 public class BSTMap<K, V> implements MapInterface<K, V>{
 
   protected BinarySearchTree<MapEntry<K, V>> map;
   
   /*******
    * Constructor
    *******/   
   public BSTMap(){
      map = new BinarySearchTree<MapEntry<K, V>>();
   }

   /******* 
    * The put method adds a key/value pair to the map. If a key 
    * already exists, the old value is removed and returned.
    *
    * @param K k The key
    * @param V v The value.
    *
    * @return The old value if it existed, otherwise null.
    *******/
   public V put(K k, V v){
   
      // null key check
      if (k == null)
         throw new IllegalArgumentException("Maps do not allow null keys.");
         
      MapEntry<K, V> entry = new MapEntry<K, V>(k, v);
      
      // gets old value if it exists, will be null if not
      MapEntry<K, V> oldValue = map.get(entry);
      
      
      // if it exists, remove it
      if (oldValue != null)
         map.remove(oldValue);
         
      map.add(entry);
      
      // if the old value did not exist, return null
      if (oldValue == null)
         return null;
      
      return oldValue.getValue();           
   }
   
   /*******
    * The get method returns the value assocatied with the passed in key.
    *
    * @param K k The key to search for.
    *
    * @return The value associated with the key if it exists,
    *          otherwise null.
    *******/   
   public V get(K k){
   
      // null key check
      if (k == null)
         throw new IllegalArgumentException("Maps do not allow null keys.");
      
      // create entry with only the key to check against
      MapEntry<K, V> entry = new MapEntry<K, V>(k, null);
      
      entry = map.get(entry);
      
      // if the old value did not exist, return null
      if (entry == null)
         return null; 
              
      return entry.getValue();
   }
   
   /*******
    * The remove method removes the key/value pair associated with the
    *    key that is passed in. 
    *
    * @param K k The key associated with the key/value pair to remove.
    *
    * @return The value associated with the key if it exists,
    *          otherwise null.
    *******/      
   public V remove(K k){
   
      // null key check
      if (k == null)
         throw new IllegalArgumentException("Maps do not allow null keys.");
        
      MapEntry<K, V> toRemove = new MapEntry<K, V>(k, null);
         
      // get the value associated with the key
      toRemove = map.get(toRemove);
      
      // if the old value did not exist, return null
      if (toRemove == null)
         return null;      
         
      // remove it from the tree
      map.remove(toRemove);
               
      return toRemove.getValue();
   }
   
   /*******
    * The contains method checks the map for the key passed in.
    *
    * @param K k The key associated with the key/value pair to check.
    *
    * @return T/F based on the existence of the key.
    *******/     
   public boolean contains(K k){
      
      if (k == null)
         throw new IllegalArgumentException("Maps do not allow null keys.");
      
      //create an entry of just key to compare with
      MapEntry<K, V> entry = new MapEntry<K, V>(k, null);
      
      return map.contains(entry);   
   }
   
   /*******
    * The isEmpty method calls the isEmpty method of the underlying
    *  structure.
    *
    * @return True if empty, otherwise fales
    *******/     
   public boolean isEmpty(){
      return map.isEmpty();
   }
   
   /*******
    * The isFull method checks if the map is full
    *
    * @return False - BSTs are never full
    *******/    
   public boolean isFull(){
      return false;
   }
   
   /*******
    * The size method calls the size method of the underlying structure.
    *
    * @return An int corresponding to how many elements are in the map.
    *******/    
   public int size(){
      return map.size();
   }
   
   /*******
    * The iterator method calls the iterator from the underlying
    *  structure. 
    *
    * @return The iterator from the BST.
    *******/    
   public Iterator<MapEntry<K, V>> iterator(){
      return map.iterator();
   }
 }
 