/*
Given a Binary Search Tree and a target sum. Check whether there's a pair of Nodes in the BST with value summing up to the target sum. 

Example 1:

Input:
        2
      /   \
     1     3
sum = 5
Output: 1
Example 2:

Input:
           6
          /    
         5     
        /
       3 
     /  \
    1    4
sum = 2
Output: 0
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function isPairPresent() that takes a root node and a target value as a parameter and returns 1 if there's a pair of Nodes in the BST with values summing up to the target sum, else returns 0. 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the BST).

Constraints:
1<=Number of Nodes<=100000
1<=K<=1000005

##############################################################################Solution##############################################################################
*/

class Solution
{
    // root : the root Node of the given BST
    // target : the target sum
    boolean flag=false;
    public void sum(Node root,int target,TreeSet<Integer> ts){
        if(root==null){
            return;
        }
        sum(root.left,target,ts);
        if(!ts.contains(target-root.data)){
            ts.add(root.data);
        }
        else {
            if(flag==false){
                flag =true;
            }
        }
        sum(root.right,target,ts);
    }
    
    public int isPairPresent(Node root, int target)
    {
        // Write your code here
        TreeSet<Integer> ts = new TreeSet<>();
        sum(root,target,ts);
        if(flag){
            return 1;
        }
        return 0;
    }
}
