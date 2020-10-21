/*
Given a binary tree, check if the tree can be folded or not. A tree can be folded if left and right subtrees of the tree are structure wise same. An empty tree is considered as foldable.
Consider the below trees:
(a) and (b) can be folded.
(c) and (d) cannot be folded.


(a)
       10
     /    \
    7      15
     \    /
      9  11
(b)
        10
       /  \
      7    15
     /      \
    9       11
(c)
        10
       /  \
      7   15
     /    /
    5   11
(d)
         10
       /   \
      7     15
    /  \    /
   9   10  12
 
Example 1:

Input:
     10
    /    \
   7     15
 /  \   /  \
N   9  11   N
Output:Yes
Example 2:

Input:
      10
    /    \
   7     15
 /  \   /  \
5   N  11   N
Output: No

Your Task:
The task is to complete the function isFoldable() that takes root of the tree as input and returns true or false depending upon whether the tree is foldable or not.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= n <= 103
1 <= data of node <= 104
###############################################################################Solution#############################################################################
*/
class Tree {
    boolean IsFold(Node root1,Node root2) 
	{ 
		// your code 
		if(root1==null && root2==null){
		    return true;
		}
		return (root1!=null && root2!=null) && IsFold(root1.left,root2.right) && IsFold(root1.right,root2.left);
	}
    boolean IsFoldable(Node node) 
	{ 
		// your code 
		if(node==null){
		    return true;
		}
		return IsFold(node.left,node.right);
	} 
}
