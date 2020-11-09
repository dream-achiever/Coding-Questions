/*
Given a Binary Tree. Find the Zig-Zag Level Order Traversal of the Binary Tree.

 

Example 1:

Input:
        3
      /   \
     2     1
Output: 3 1 2
 

Example 2:

Input:
           7
        /     \
       9       7
     /  \     /   
    8    8   6     
   /  \
  10   9 
Output: 7 7 9 8 8 6 9 10 
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function zigZagTraversal() which takes the root node of the Binary Tree as its input and returns a list containing the node values as they appear in the Zig-Zag Level-Order Traversal of the Tree.

 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

 

Constraints:
1 <= N <= 104
################################################################################Solution############################################################################
*/
class GFG
{
    // return an array containing the zig zag level order traversal of the given tree
	ArrayList<Integer> zigZagTraversal(Node root)
	{
	    //Add your code here.
	    ArrayList<Integer> arr = new ArrayList<>();
	    if(root==null){
	        return arr;
	    }
	    Stack<Node> st1 = new Stack<>();
	    Stack<Node> st2 = new Stack<>();
	    st1.push(root);
	    while(!st1.isEmpty() || !st2.isEmpty()){
	        while(!st1.isEmpty()){
	            Node curr = st1.pop();
	            if(curr!=null){
	                arr.add(curr.data);
	            }
	            if(curr.left!=null){
	                st2.push(curr.left);
	            }
	            if(curr.right!=null){
	                st2.push(curr.right);
	            }
	        }
	        while(!st2.isEmpty()){
	            Node curr = st2.pop();
	            if(curr!=null){
	                arr.add(curr.data);
	            }
	            if(curr.right!=null){
	                st1.push(curr.right);
	            }
	            if(curr.left!=null){
	                st1.push(curr.left);
	            }
	        }
	    }
	    return arr;
	}
}
