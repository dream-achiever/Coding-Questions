/*
Serialization is to store a tree in an array so that it can be later restored and Deserialization is reading tree back from the array. Now your task is to complete the function serialize which stores the tree into an array A[ ] and deSerialize which deserializes the array to tree and returns it.
Note: The structure of tree must be maintained.

Example 1:

Input:
      1
    /   \
   2     3
Output: 2 1 3
Example 2:

Input:
         10
       /    \
      20    30
    /   \
   40  60
Output: 40 20 60 10 30
Your Task:
The task is to complete two function serialize which takes the root node of the tree as input andstores the tree into an array and deSerialize which deserializes the array to the original tree and returns the root of it.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= Number of nodes <= 1000
1 <= Data of a node <= 1000
###############################################################################Solution#############################################################################
*/
class Tree {
	public void serialize(Node root, ArrayList<Integer> A) {
	    if(root!=null){
	        A.add(root.data);
	        serialize(root.left,A);
	        serialize(root.right,A);
	    }
	    else {
	        A.add(-1);
	    }
	}
	int index=0;
    public Node deSerialize(ArrayList<Integer> A){
        if(index==A.size()){
            return null;
        }
        int val = A.get(index);
        index++;
        if(val==-1){
            return null;
        }
        
        Node root = new Node(val);
        root.left = deSerialize(A);
        root.right = deSerialize(A);
        
        return root;
    }
}
