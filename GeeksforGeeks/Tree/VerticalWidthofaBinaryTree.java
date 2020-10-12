/*
Given a Binary Tree of N nodes. Find the vertical width of the tree.

Example 1:

Input:
          1
       /    \
      2      3
     / \    / \
    4   5  6   7
            \   \
             8   9
Output: 6
Explanation: The width of a binary tree is
the number of vertical paths in that tree.



The above tree contains 6 vertical lines.
 

Example 2:

Input:
      1
    /  \
   2    3
Output: 3
 

Your Task:

You don't have to read input or print anything. Your task is to complete the function verticalWidth() which takes root as the only parameter, and returns the vertical width of the binary tree.

 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

 

Constraints:
1 <= Number of nodes <= 103
##############################################################################Solution##############################################################################
*/
class Tree
{
    public static int max=0,min=0;
    public static void width(Node root,int curr){
        if(root == null){
            return;
        }
        width(root.left,curr-1);
        if(min>curr){
            min=curr;
        }
        if(max<curr){
            max=curr;
        }
        width(root.right,curr+1);
    }
    public static int verticalWidth(Node root)
	{
	    // code here.
	    if(root==null){
	        return 0;
	    }
	    max=0;min=0;
	    width(root,0);
	    return (Math.abs(min)+max)+1;
	}
}
