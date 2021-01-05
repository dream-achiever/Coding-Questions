/*
Given a binary tree. Check whether it is a BST or not.

Example 1:

Input:
    2
 /    \
1      3
Output: 1
Example 2:

Input:
  2
   \
    7
     \
      6
       \
        5
         \
          9
           \
            2
             \
              6
Output: 0
Your Task:
You don't need to read input or print anything. Your task is to complete the function isBST() which takes the root of the tree as a parameter and returns true if the given binary tree is BST, else returns false. The printing is done by the driver's code.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the BST).

Constraints:
0 <= Number of edges <= 100000

#################################################################################Solution#########################################################################
*/
public class Tree
{
    // return true if the given tree is a BST, else return false
    int prev = Integer.MIN_VALUE;
    boolean isBST(Node root)
        {
            // code here.
            if(root == null){
                return true;
            }
            
            if(isBST(root.left)==false){
                return false;
            }
            if(root.data<=prev){
                return false;
            }
            prev = root.data;
            
            return isBST(root.right);
        }
}
