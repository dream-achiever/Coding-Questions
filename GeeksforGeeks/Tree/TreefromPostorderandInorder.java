/*
Given inorder and postorder traversals of a Binary Tree in the arrays in[] and post[] respectively. The task is to construct the binary tree from these traversals.
For example, if given inorder and postorder traversals are {4, 8, 2, 5, 1, 6, 3, 7} and {8, 4, 5, 2, 6, 7, 3, 1}  respectively, then your function should construct below tree.

          1
       /      \
     2        3
   /    \     /   \
  4     5   6    7
    \
      8

Example 1:

Input:
N = 8
in[] = 4 8 2 5 1 6 3 7
post[] =8 4 5 2 6 7 3 1
Output: 1 2 4 8 5 3 6 7
Explanation: For the given postorder and
inorder traversal of tree the  resultant
binary tree will be
          1
       /    \
     2       3
   /  \    /   \
  4    5  6    7
   \
     8
Example 2:

Input:
N = 5
in[] = 9 5 2 3 4
post[] = 5 9 3 4 2
Output: 2 9 5 4 3
Explanation:  For the given postorder and
inorder traversal of tree the  resultant
binary tree will be
             2
         /      \
       9        5
     /   \
    4      3
 

Your Task:
Complete the function buildTree() which takes the inorder, postorder traversals and the number of nodes in the tree as inputs and returns the root node of the newly constructed Binary Tree. The pre order traversal of the returned node is printed by the driver's code.

Expected Time Complexity: O(N2).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 103
1 <= in[i], post[i] <= 103
################################################################################Solution############################################################################
*/
class postIndex {
    static int val;
    postIndex(int v){
        val=v;
    }
}
class GfG {
    // Complete the function
    // int postIndex=0;
    Node conv(int in[], int post[],int si, int ei, postIndex p){
        if(si>ei){
            return null;
        }
        Node root = new Node(post[postIndex.val]);
        postIndex.val-=1;
        int index=0;
        for(int i=si;i<=ei;i++){
            if(in[i]==root.data){
                index=i;
                break;
            }
        }
        // root.left=conv(in,post,index-1,si);
        // root.right=conv(in,post,ei,index+1);
    
        root.right=conv(in,post,index+1,ei,p);
        root.left=conv(in,post,si,index-1,p);
        
        return root;
    }
    Node buildTree(int in[], int post[], int n) {
        // Your code here
        //postIndex=n-1;
        postIndex p = new postIndex(n-1);
        Node r = conv(in,post,0,n-1,p);
        return r;
    }
}
