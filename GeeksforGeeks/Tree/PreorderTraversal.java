/*
Given a binary tree, find its preorder traversal.

Example 1:

Input:
        1      
      /          
    4    
  /    \   
4       2
Output: 1 4 4 2 
Example 2:

Input:
       6
     /   \
    3     2
     \   / 
      1 2
Output: 6 3 1 2 2 

Your Task:
You just have to complete the function preorder() which takes the root node of the tree as input and returns an array containing the preorder traversal of the tree.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= Number of nodes <= 104
1 <= Data of a node <= 105
#################################################################Solution###########################################################################################
*/
class BinaryTree
{
    /* Computes the number of nodes in a tree. */
    public static void pre(Node root, ArrayList<Integer> arr ){
        if(root == null){
            return;
        }
            arr.add(root.data);
            pre(root.left,arr);
            pre(root.right,arr);
    }
    static ArrayList<Integer> preorder(Node root)
    {
        ArrayList<Integer> arr = new ArrayList<>();
        pre(root,arr);
        
        return arr;
    }

}
