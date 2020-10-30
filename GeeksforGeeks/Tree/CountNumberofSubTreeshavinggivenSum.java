/*
Given a binary tree and an integer X. Your task is to complete the function countSubtreesWithSumX() that returns the count of the number of subtress having total node’s data sum equal to the value X.
Example: For the tree given below:            

              5
            /    \
        -10     3
        /    \    /  \
      9     8  -4 7

Subtree with sum 7:
             -10
            /      \
          9        8

and one node 7.

Example 1:

Input:
       5
    /    \
  -10     3
 /   \   /  \
 9   8 -4    7
X = 7
Output: 2
Explanation: Subtrees with sum 7 are
[9, 8, -10] and [7] (refer the example
in the problem description).
Example 2:

Input:
    1
  /  \
 2    3
X = 5
Output: 0
Explanation: No subtree has sum equal
to 5.
Your Task:
You don't need to read input or print anything. Your task is to complete the function countSubtreesWithSumX() which takes the root node and an integer X as inputs and returns the number of subtrees of the given Binary Tree having sum exactly equal to X.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= N <= 103
-103 <= Node Value <= 103
#################################################################################Solution###########################################################################
*/
class Tree
{
    int count=0;
    int countsum(Node root,int x){
        
        if(root == null){
            return 0;
        }
        int l=countsum(root.left,x);
        int r= countsum(root.right,x);
        if(root.data+l+r==x){
            count++;
            return x;
        }
        return root.data+l+r;
    }
    
    int countSubtreesWithSumX(Node root, int X)
    {
	//Add your code here.
	    int a=countsum(root,X);
	    return count;
    }
}
