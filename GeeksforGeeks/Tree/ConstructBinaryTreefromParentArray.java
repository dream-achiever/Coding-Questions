/*
Given an array of size N that represents a Tree in such a way that array indexes are values in tree nodes and array values give the parent node of that particular index (or node). The value of the root node index would always be -1 as there is no parent for root. Construct the standard linked representation of Binary Tree from this array representation.

Example 1:

Input:
N = 7
parent[] = {-1,0,0,1,1,3,5}
Output: 0 1 2 3 4 5 6
Explanation:For the array parent[] = {-1,
0, 0, 1, 1, 3, 5}; the tree generated
will have a sturcture like 
         0
       /   \
      1     2
     / \
    3   4
   /
  5
/
6
Example 2:

Input:
N = 5
parent[] = {-1,0,0,2,2}
Output: 0 1 2 3 4
Explanation: For the array parent[] =
{-1 0 0 2 2}; the tree generated will
have a sturcture like
                 0
              /      \
             1        2
          /      \
        3        4
Your Task:
The task is to complete the function createTree() which takes 2 arguments(tree array and N) and returns the root node of the tree constructed.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 103
###################################################################################Solution#########################################################################
*/
class GfG
{
   
    public static Node createTree(int arr[], int n)
    {
        //Your code here
        ArrayList<Node> a = new ArrayList<>();
        for(int i=0;i<n;i++){
            Node temp = new Node(i);
            a.add(temp);
        }
        int root=0;
        for(int i=0;i<n;i++){
            if(arr[i]==-1){
                root=i;
            }
            if(arr[i]!=-1 && a.get(arr[i]).left==null){
                a.get(arr[i]).left=a.get(i);
            }
            else if(arr[i]!=-1 && a.get(arr[i]).right==null){
                a.get(arr[i]).right=a.get(i);
            }
        }
        return a.get(root);
    }
    
}
