/*
Given a Binary Tree, you need to find the maximum value which you can get by subtracting the value of node B from the value of node A, where A and B are two nodes of the binary tree and A is an ancestor of B. 

Example 1:

Input:
    5
 /    \
2      1
Output: 4
Explanation:The maximum difference we can
get is 4, which is bewteen 5 and 1.
Example 2:

Input:
      1
    /    \
   2      3
           \
            7
Output: -1
Explanation:The maximum difference we can
get is -1, which is between 1 and 2.
Your Task:
The task is to complete the function maxDiff() which finds the maximum difference between the node and its ancestor.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(H).
Note: H is the height of the tree.

Constraints:
1 <= Number of edges <= 104
0 <= Data of a node <= 105
###############################################################################Solution#############################################################################
*/
class Tree
{
    int res=Integer.MIN_VALUE;
    int minval(Node root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        if(root.left == null && root.right==null){
            return root.data;
        }
        int l=minval(root.left);
        int r=minval(root.right);
        
        if(l==Integer.MIN_VALUE && r==Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        if(l==Integer.MIN_VALUE){
            l=Integer.MAX_VALUE;
        }
        else if(r==Integer.MIN_VALUE){
            r=Integer.MAX_VALUE;
        }
        int min = Math.min(l,r);
        int diff = root.data - min;
        res = Math.max(res,diff);
        return Math.min(root.data,Math.min(l,r));
    }
    int maxDiff(Node root)
    {
        //your code here
        minval(root);
        return res;
    }
}
