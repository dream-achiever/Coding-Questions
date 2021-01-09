/*
Given an array of size N containing level order traversal of a BST. The task is to complete the function constructBst(), that construct the BST (Binary Search Tree) from its given level order traversal.

Example 1:

Input:
N = 9
BST[] = {7,4,12,3,6,8,1,5,10}
Output: 7 4 3 1 6 5 12 8 10
Explanation: After constructing BST, the
preorder traversal of BST is
7 4 3 1 6 5 12 8 10.
Example 2:

Input:
N = 6
BST[] = {1,3,4,6,7,8}
Output: 1 3 4 6 7 8
Explanation: After constructing BST, the
preorder traversal of BST is 1 3 4 6 7 8.
Your Task:
Your task is to complete the function constructBst() which has two arguments, first as the array containing level order traversal of BST and next argument as the length of array which return the root of the newly constructed BST. The preorder traversal of the tree is printed by the driver's code.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 103
################################################################################Solution############################################################################
*/
class NodeDetails{
    Node node = null;
    int min,max;
    NodeDetails(Node n, int mn,int mx){
        node = n;
        min = mn;
        max = mx;
    }
}

class GFG {
    
    public Node constructBST(int[] arr){
        //Write your code here and return the root of the constructed BST
        
        Queue<NodeDetails> q = new LinkedList<>();
        int i=1;
        int n = arr.length;
        Node root = new Node(arr[0]);
        NodeDetails detail = new NodeDetails(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
        q.add(detail);
        while(i<n){
            NodeDetails temp = q.poll();
            
                if(arr[i]<temp.node.data && arr[i]>temp.min){
                    temp.node.left = new Node(arr[i++]);
                    NodeDetails element = new NodeDetails(temp.node.left,temp.min,temp.node.data);
                    q.add(element);
                }
                if(i<n && arr[i]>temp.node.data && arr[i]<temp.max){
                    temp.node.right = new Node(arr[i++]);
                    NodeDetails element = new NodeDetails(temp.node.right,temp.node.data,temp.max);
                    q.add(element);
                }
            
        }
        return root;
    }
}
