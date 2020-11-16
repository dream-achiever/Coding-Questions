/*
Given a binary tree with a value associated with each node, we need to choose a subset of these nodes such that sum of chosen nodes is maximum under a constraint that no two chosen node in subset should be directly connected that is, if we have taken a node in our sum then we can’t take its any children in consideration and vice versa.

                                               

Example 1:

Input:
     11
    /  \
   1    2
Output: 11
Explanation: The maximum sum is sum of
node 11.
Example 2:

Input:
        1
      /   \
     2     3
    /     /  \
   4     5    6
Output: 16
Explanation: The maximum sum is sum of
nodes 1 4 5 6 , i.e 16. These nodes are
non adjacent.
Your Task:
You don't need to read input or print anything. You just have to complete function getMaxSum() which accepts root node of the tree as parameter and returns the maximum sum as described.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= N <= 1000
#####################################################################################Solution#######################################################################
*/
class Pair {
    int first;
    int second;
    Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}
class GFG
{
    
    static Pair maxsum(Node root){
        if(root == null){
            return new Pair(0,0);
        }
        Pair p1 = maxsum(root.left);
        Pair p2 = maxsum(root.right);
        Pair p = new Pair(0,0);
        p.first = p1.second+p2.second+root.data;
        p.second = Math.max(p1.first,p1.second)+Math.max(p2.first,p2.second);
        return p;
    }
    static int getMaxSum(Node root)
    {
        // add your code here
        Pair res = maxsum(root);
        return Math.max(res.first,res.second);
    }
}
