/*
Given a Binary Tree, find the In-Order Traversal of it.

Example 1:

Input:
       1
     /  \
    3    2
Output: 3 1 2

Example 2:

Input:
        10
     /      \ 
    20       30 
  /    \    /
 40    60  50
Output: 40 20 60 10 50 30

Your Task:
You don't need to read input or print anything. Your task is to complete the function inOrder() that takes root node of the tree as input and returns a list containing the In-Order Traversal of the given Binary Tree.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= Number of nodes <= 105
1 <= Data of a node <= 105
################################################################################Solution############################################################################
*/
class Tree
{
    // Return a list containing the inorder traversal of the given tree
    
    void intraversal(Node root,ArrayList<Integer> arr){
        if(root!=null){
            intraversal(root.left,arr);
            arr.add(root.data);
            intraversal(root.right,arr);
        }
    }
    
    ArrayList<Integer> inOrder(Node root)
    {
        // Code
        ArrayList<Integer> arr = new ArrayList<>();
        intraversal(root,arr);
        return arr;
    }
}
