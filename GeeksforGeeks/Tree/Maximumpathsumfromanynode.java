/*
Given a binary tree, the task is to find the maximum path sum. The path may start and end at any node in the tree.

Example 1:

Input:
     10
    /  \
   2   -25
  / \  /  \
 20 1  3  4
Output: 32
Explanation: Path in the given tree goes
like 10 , 2 , 20 which gives the max
sum as 32.
Example 2:

Input:
     10
   /    \
  2      5
          \
          -2
Output: 17
Explanation: Path in the given tree goes
like 2 , 10 , 5 which gives the max sum
as 17.
Your Task:
You don't need to take input or print anything. Your task is to complete the function findMaxSum() that takes root as input and returns max sum between any two nodes in the given Binary Tree.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= Number of nodes <= 103
1 <= |Data on node| <= 104
###############################################################################Solution#############################################################################
*/
class Tree
{
    // This function should returns sum of
    // maximum sum path from any node in
    // a tree rooted with given root.
    int res = Integer.MIN_VALUE;
    int maxpath(Node root){
        if(root == null){
            return 0;
        }
        int l = maxpath(root.left);
        int r = maxpath(root.right);
        int maxsingle = Math.max(root.data, root.data+Math.max(l,r));
        int maxpath = Math.max(maxsingle,root.data+l+r);
        res = Math.max(res,maxpath);
        return maxsingle;
    }
    int findMaxSum(Node node)
    {
        //your code goes here
        maxpath(node);
        return res;
    }
}
