class Node<T>{
   
   public T info;
   Node left;
   Node right;
   
   public Node(T info){
      
      this.info = info;
      left = null;
      right = null;
   }
   
   public void setLeft(Node node){
      left = node;
   }
   
   public void setRight(Node node){
      right = node;
   }
   
   public Node getLeft(){
      return left;
   }
   
   public Node getRight(){
      return right;
   }
}

class BSTtoDLL{

   static Node previous = null;
   static Node current = null;
   
   public static void main(String[] args){
      
      // make tree
      Node<Integer> root = new Node<Integer>(4);
      root.setLeft(new Node<Integer>(2));
      root.setRight(new Node<Integer>(6));
      root.getLeft().setLeft(new Node<Integer>(1));
      root.getLeft().setRight(new Node<Integer>(3));
      root.getRight().setLeft(new Node<Integer>(5));
      root.getRight().setRight(new Node<Integer>(7));
      
      // traverse is an inOrder iterator    
      traverse(root);
      
      // setPointer moves the pointer to the leftmost node, which is the head of the list
      root = setPointer(root);
      
      // print the resulting list
      printDLL(root);
   }
   
   public static void traverse(Node root){
      
      if (root != null){
         
         traverse(root.getLeft());
         convert(root);
         traverse(root.getRight());
      }
   }
   
   public static void convert(Node root){
      
      previous = current;
      current = root;
      current.setLeft(previous);

      if (previous != null)
         previous.setRight(current); 
   }
   
   public static Node setPointer(Node node){
      
      while (node.getLeft() != null)
         node = node.getLeft();
         
      return node;
   }
   
   public static void printDLL(Node node){
      
      if (node != null){
         System.out.print(node.info + "\t");
         printDLL(node.getRight());
      }
   }  
}