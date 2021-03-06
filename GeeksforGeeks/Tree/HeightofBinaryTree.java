/*
Given a binary tree, find its height.

â€‹â€‹Example 1:

Input:
      1
    /  \
   2    3
Output: 2
Example 2:

Input:
  2
   \
    1
   /
 3
Output: 3   
Your Task:
You don't need to read input or print anything. Your task is to complete the function height() that takes root Node of the Tree as input and returns the Height of the Tree. If the Tree is empty, return 0. 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= Number of nodes <= 105
1 <= Data of a node <= 105
###################################################################################Solution#########################################################################
*/
class Tree
{
    // return the Height of the given Binary Tree
    int height(Node root) 
    {
         // Your code here
         if(root == null){
             return 0;
         }
         return 1+Math.max(height(root.left),height(root.right));
    }   
}
