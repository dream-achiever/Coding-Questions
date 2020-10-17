/*
Given a binary tree, connect the nodes that are at same level. You'll be given an addition nextRight pointer for the same.

Initially, all the nextRight pointers point to garbage values. Your function should set these pointers to point next right for each node.
       10                       10 ------> NULL
      / \                       /      \
     3   5       =>     3 ------> 5 --------> NULL
    / \     \               /  \           \
   4   1   2          4 --> 1 -----> 2 -------> NULL

 

Example 1:

Input:
     3
   /  \
  1    2
Output:
3 1 2
1 3 2
Explanation:The connected tree is
        3 ------> NULL
     /    \
    1-----> 2 ------ NULL
Example 2:

Input:
      10
    /   \
   20   30
  /  \
 40  60
Output:
10 20 30 40 60
40 20 60 10 30
Explanation:The connected tree is
         10 ----------> NULL
       /     \
     20 ------> 30 -------> NULL
  /    \
 40 ----> 60 ----------> NULL
Your Task:
You don't have to take input. Complete the function connect() that takes root as parameter and connects the nodes at same level. The printing is done by the driver code.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= Number of nodes <= 100
1 <= Data of a node <= 1000
##################################################################################Solution##########################################################################
*/
class Tree
{
    /*
    Node class is Defined as follows:
    class Node{
        int data;
        Node left;
        Node right;
        Node nextRight;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
            nextRight = null;
        }
    }
    */
    public static void connect(Node p)
        {
            // code here.
            if(p==null){
                return;
            }
            Queue<Node> arr = new LinkedList<>();
            arr.add(p);
            while(!arr.isEmpty()){
                int count = arr.size();
                Node prev=null;
                for(int i=0;i<count;i++){
                    Node curr = arr.poll();
                    if(curr.left!=null){
                        arr.add(curr.left);
                    }
                    if(curr.right!=null){
                        arr.add(curr.right);
                    }
                    if(prev!=null){
                        prev.nextRight=curr;
                    }
                    prev=curr;
                }
            }
        }
}
