/*
Given an array arr[] of N nodes representing preorder traversal of BST. The task is to print its postorder traversal.

Example 1:

Input:
N = 5
arr[]  = {40,30,35,80,100}
Output: 35 30 100 80 40
Explanation: PreOrder: 40 30 35 80 100
InOrder: 30 35 40 80 100
Therefore, the BST will be:
              40
           /      \
         30       80
           \        \   
           35      100
Hence, the postOrder traversal will
be: 35 30 100 80 40
Example 2:

Input:
N = 8
arr[]  = {40,30,32,35,80,90,100,120}
Output: 35 32 30 120 100 90 80 40
Your Task:
You need to complete the given function and return the root of the tree. The driver code will then use this root to print the post order traversal.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 103
1 <= arr[i] <= 104
################################################################################Solution############################################################################
*/
static int construct(int pre[], int n,int pos, Node curr, int min, int max){
    
    if(pos==n || pre[pos]<min || pre[pos]>max){
        return pos;
    }
    
    if(pre[pos]<curr.data){
        curr.left = new Node(pre[pos]);
        pos+=1;
        pos = construct(pre, n, pos,curr.left,min,curr.data-1);
    }
    
    if(pos==n || pre[pos]<min || pre[pos]>max){
        return pos;
    }
    
    if(pre[pos]>curr.data){
        curr.right = new Node(pre[pos]);
        pos+=1;
        pos = construct(pre, n, pos,curr.right,curr.data+1,max);
    }
    
    return pos;
    
}

public static Node constructTree(int pre[], int size) {
    //Your code here
    
    int n = pre.length;
    if(n==0){
        return null;
    }
    
    Node root = new Node(pre[0]);
    if(n==1){
        return root;
    }
    
    construct(pre,n,1,root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    return root;
    
} 
