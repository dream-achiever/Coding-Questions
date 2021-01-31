/*
Given two BSTs, return elements of both BSTs in sorted form.

Example 1:

Input:
BST1:
       5
     /   \
    3     6
   / \
  2   4  
BST2:
        2
      /   \
     1     3
            \
             7
            /
           6
Output: 1 2 2 3 3 4 5 6 6 7
Explanation: 
After merging and sorting the
two BST we get 1 2 2 3 3 4 5 6 6 7.
Example 2:

Input:
BST1:
       12
     /   
    9
   / \    
  6   11
    
BST2:
      8
    /  \
   5    10
  /
 2
Output: 2 5 6 8 9 10 11 12
Explanation: 
After merging and sorting the
two BST we get 2 5 6 8 9 10 11 12.
Your Task:
You don't need to read input or print anything. Your task is to complete the function merge() which takes roots of both the BSTs as its input and returns an array of integers denoting the node values of both the BSTs in a sorted order.

Expected Time Complexity: O(M+N) where M and N are the sizes if the two BSTs.
Expected Auxiliary Space: O(Height of BST1 + Height of BST2).

Constraints:
1 <= Number of Nodes <= 100000
#############################################################################Solution###############################################################################
*/
class Solution{
    // Return a integer of integers having all the nodes in both the BSTs in a sorted order.
    
    public void in(Node root, List<Integer> arr){
        if(root!=null){
            in(root.left,arr);
            arr.add(root.data);
            in(root.right,arr);
            
        }
    }
    
    public List<Integer> merge(Node root1,Node root2)
    {
        // Write your code here
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        in(root1,arr1);
        in(root2,arr2);
        int m = arr1.size();
        int n = arr2.size();
        List<Integer> arr3 = new ArrayList<>();
        int i=0,j=0;
        while(i<m && j<n){
            int num1 = arr1.get(i);
            int num2 = arr2.get(j);
            if(num1>num2){
                arr3.add(num2);
                j++;
            }
            else if(num1<num2){
               arr3.add(num1);
               i++;
            }
            else {
               arr3.add(num1);
               arr3.add(num2);
               i++;
               j++;
            }
        }
        while(i<m){
            int num1 = arr1.get(i);
            arr3.add(num1);
            i++;
        }
        while(j<n){
            int num2 = arr2.get(j);
            arr3.add(num2);
            j++;
        }
        return arr3;
        
    }
}
