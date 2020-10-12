/*
Given a Binary Tree, print Left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from Left side. The task is to complete the function leftView(), which accepts root of the tree as argument.

Left view of following tree is 1 2 4 8.

          1
       /     \
     2        3
   /     \    /    \
  4     5   6    7
   \
     8   

Example 1:

Input:
   1
 /  \
3    2
Output: 1 3

Example 2:

Input:

Output: 10 20 40
Your Task:
You just have to complete the function leftView() that prints the left view. The newline is automatically appended by the driver code.
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
1 <= Number of nodes <= 100
1 <= Data of a node <= 1000
###############################################################################Solution#############################################################################
*/
class Tree
{
    int maxlevel=0;
    void leftview(Node root,int level,ArrayList<Integer> arr){
        if(root==null){
            return;
        }
        if(maxlevel<level){
            arr.add(root.data);
            maxlevel=level;
        }
        leftview(root.left,level+1,arr);
        leftview(root.right,level+1,arr);
    }
    ArrayList<Integer> leftView(Node root)
    {
        // Your code here
        ArrayList<Integer> arr = new ArrayList<>();
        leftview(root,1,arr);
        return arr;
    }
}
