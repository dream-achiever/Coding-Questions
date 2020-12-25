/*
Given a Binary Tree, find the vertical traversal of it starting from the leftmost level to the rightmost level.
If there are multiple nodes passing through a vertical line, then they should be printed as they appear in level order traversal of the tree.

Example 1:

Input:
     2
      \
       3
      /
     4
Output: 2 4 3

Example 2:

Input:
       1
    /    \
   2      3
 /   \      \
4     5      6
Output: 4 2 1 5 3 6

Your Task:
You don't need to read input or print anything. Your task is to complete the function verticalOrder() which takes the root node as input and returns an array containing the vertical order traversal of the tree from the leftmost to the rightmost level. If 2 nodes lie in the same vertical level, they should be printed in the order they appear in the level order traversal of the tree.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= Number of nodes <= 5000

####################################################################################Solution########################################################################
*/
class Pair{
    int count;
    Node val=null;
    Pair(Node v,int c){
        val = v;
        count = c;
    }
}

class BinaryTree
{
    static ArrayList <Integer> verticalOrder(Node root)
    {
        // add your code here
        if(root == null){
            return new ArrayList<>();
        }
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, ArrayList<Integer>> tm = new TreeMap<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            int count = q.size();
            
                Pair p = q.poll();
                Node curr = p.val;
                
                if(!tm.containsKey(p.count)){
                    ArrayList<Integer> arr= new ArrayList<>();
                    arr.add(curr.data);
                    tm.put(p.count,arr);
                }
                else {
                 tm.get(p.count).add(curr.data);   
                }
                
                if(curr.left!=null){
                    q.add(new Pair(curr.left,p.count-1));
                }
                
                if(curr.right!=null){
                    q.add(new Pair(curr.right,p.count+1));
                }
                
            
        }
        
        ArrayList<Integer> a = new ArrayList<>();
        for(Map.Entry<Integer, ArrayList<Integer>> p : tm.entrySet()){
            ArrayList<Integer> ar = p.getValue();
            for(int x : ar){
                a.add(x);
            }
        }
        return a;
    }
}
