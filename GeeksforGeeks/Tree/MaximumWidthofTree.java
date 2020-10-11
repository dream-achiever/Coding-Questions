/*
Given a Binary Tree, find the maximum width of it. Maximum width is defined as the maximum number of nodes in any level.
For example, maximum width of following tree is 4 as there are 4 nodes at 3rd level.

          1
       /     \
     2        3
   /    \    /    \
  4    5   6    7
    \
      8

Example 1:

Input:
       1
     /    \
    2      3
Output: 2
Example 2:

Input:
        10
      /     \
    20      30
   /    \
  40    60
Output: 2
Your Task:
You don't have to read any input. Just complete the function getMaxWidth() that takes node as parameter and returns the maximum width. The printing is done by the driver code.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= edges <= 1000
1 <= nodes values <= 105
#######################################################################################Solution#####################################################################
*/
class Tree
{
    // /* Function to get the maximum width of a binary tree*/
    int getMaxWidth(Node root)
    {
        // Your code here
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return 1;
        }
        int res=0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int count = q.size();
            res=Math.max(res,count);
            for(int i=0;i<count;i++){
                Node curr = q.poll();
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }
        return res;
    }		
}
