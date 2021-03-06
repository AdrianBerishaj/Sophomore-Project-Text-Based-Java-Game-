
package randomsorttree;

public class RandomSortTree {
   
   
      static TreeNode root;  
   
   
      static class TreeNode {
                 // An object of type TreeNode represents one node
                 // in a binary tree of real numbers
          double item;      // The data in this node
          TreeNode left;    // Pointer to left subtree
          TreeNode right;   // Pointer to right subtree
          TreeNode(double x) {
                 // Constructor.  Make a node containing x
             item = x;
          }
      } // end class TreeNode
   
   
      static void treeInsert(double x) {
               // Add x to the binary sort tree to which the
               // global variable "root" refers
         if ( root == null ) {
                 // The tree is empty.  Set root to point to a new node 
                 // containing the new item
             root = new TreeNode( x );
             return;
          }
          TreeNode runner; // Runs down the tree to find a place for newItem
          runner = root;   // Start at the root
          while (true) {
             if ( x < runner.item ) {
                      
                if ( runner.left == null ) {
                   runner.left = new TreeNode( x );
                   return;  // New item has been added to the tree
                }
                else
                   runner = runner.left;
             }
             else {
                     
                if ( runner.right == null ) {
                   runner.right = new TreeNode( x );
                   return;  // New item has been added to the tree.
                }
                else
                   runner = runner.right;
              }
          } // end while
      }  // end treeInsert()
   
   
      static int countLeaves(TreeNode node) {
             // Return the number of leaves in the tree to which node points.
          if (node == null)
             return 0;
          else if (node.left == null && node.right == null)
             return 1;  // Node is a leaf
          else
             return countLeaves(node.left) + countLeaves(node.right);
      } // end countNodes()
      
      
      static int sumOfLeafDepths( TreeNode node, int depth ) {
             
          if ( node == null ) {
                // Since the tree is empty and there are no leaves,
                // the sum is zero.
             return 0;
          }
          else if ( node.left == null && node.right == null) {
                // The node is a leaf, and there are no subtrees of node, so
                // the sum of the leaf depth is just the depths of this node
             return depth;
          }
          else {
                // The node is not a leaf.  Return the sum of the
                // the depths of the leaves in the subtrees
             return sumOfLeafDepths(node.left, depth + 1) 
                         + sumOfLeafDepths(node.right, depth + 1);
          }
      } // end sumOfLeafDepth()
      
      
      static int maximumLeafDepth( TreeNode node, int depth ) {
             
          if ( node == null ) {
               // The tree is empty Return 0
             return 0;
          }
          else if ( node.left == null && node.right == null) {
                // The node is a leaf, so the maximum depth in this
                // subtree is the depth of this node (the only leaf 
                // that it contains)
             return depth;
          }
          else {
                // Get the maximum depths for the two subtrees of this
                // node.  Return the larger of the two values, which
                // represents the maximum in the tree overall
             int leftMax = maximumLeafDepth(node.left, depth + 1);
             int rightMax =  maximumLeafDepth(node.right, depth + 1);
             if (leftMax > rightMax)
                return leftMax;
             else
                return rightMax;
          }
      } // end sumOfLeafDepth()
      
      
      public static void main(String[] args) {
            // The main routine makes the random tree and prints
            // the statistics.
            
         root = null;  // Start with an empty tree.  Root is a global
                       // variable, defined at the top of the class
            
            
         for (int i = 0; i < 2; i++)
             treeInsert(Math.random()); 
             
      
             
         int leafCount = countLeaves(root);
         int depthSum = sumOfLeafDepths(root,0);
         int depthMax = maximumLeafDepth(root,0);
         double averageDepth = ((double)depthSum) / leafCount;
         
         // Display results
         
         System.out.println("Number of leaves:         " + leafCount);
         System.out.println("Average depth of leaves:  " + averageDepth);
         System.out.println("Maximum depth of leaves:  " + depthMax);
   
      }  // end main()
   
   
   } // end class RandomSortTree

