/*
Given below is a binary tree. The task is to print the top view of binary tree. Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. For the given below tree

       1
    /     \
   2       3
  /  \    /   \
4    5  6   7

Top view will be: 4 2 1 3 7
Note: Print from leftmost node to rightmost node.

Example 1:

Input:
      1
   /    \
  2      3
Output: 2 1 3

Example 2:

Input:
       10
    /      \
  20        30
 /   \    /    \
40   60  90    100
Output: 40 20 10 30 100
Your Task:
Since this is a function problem. You don't have to take input. Just complete the function printTopView() that takes root node as parameter and prints the top view. The newline is automatically appended by the driver code.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 105
1 <= Node Data <= 105

#############################################################################Solution###############################################################################
*/
class Pair{
    Node value = null;
    int hd;
    Pair(Node v, int h){
        value=v;
        hd=h;
    }
}

class View
{
    // function should print the topView of the binary tree
    static void topView(Node root)
    {
        // add your code
        
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        if(root==null){
            return;
        }
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            Node curr = p.value;
            int hd = p.hd;
            
            if(!tm.containsKey(hd)){
                tm.put(hd,curr.data);
            }
            
            if(curr.left!=null){
                q.add(new Pair(curr.left,hd-1));
            }
            
            if(curr.right!=null){
                q.add(new Pair(curr.right,hd+1));
            }
        }
        
        for(Map.Entry<Integer,Integer> p : tm.entrySet()){
            System.out.print(p.getValue()+" ");
        }
    }
}
