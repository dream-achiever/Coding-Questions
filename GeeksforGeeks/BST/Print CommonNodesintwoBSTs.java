/*
Given two Binary Search Trees(without duplicates). Find need to print the common nodes in them. In other words, find intersection of two BSTs

Example 1:

Input:
BST1:
                  5
               /     \
             1        10
           /   \      /
          0     4    7
                      \
                       9
BST2:
                10 
              /    \
             7     20
           /   \ 
          4     9
Output: 4 7 9 10

Example 2:

Input:
BST1:
     10
    /  \
   2   11
  /  \
 1   3
BST2:
       2
     /  \
    1    3
Output: 1 2 3
Your Task:
You don't need to read input or print anything. Your task is to complete the function printCommon() that takes roots of both the BSTs as input and returns an array containing the intersection of the 2 BSTs in a sorted order. 

Expected Time Complexity: O(N1 + N2) where N1 and N2 are the sizes of the 2 BSTs.
Expected Auxiliary Space: O(H1 + H2) where H1 and H2 are the Heights of the 2 BSTs.

Constraints:
1 <= N <= 103
##############################################################################Solution########################################3######################################
*/
class BST
{
	// print a list containing the intersection of the two BSTs in a sorted order
	
	public static HashSet<Integer> in(Node root, HashSet<Integer> hs){
	    if(root!=null){
	        in(root.left,hs);
	        hs.add(root.data);
	        in(root.right,hs);
	    }
	    return hs;
	}
	public static ArrayList<Integer> search(Node root,HashSet<Integer> hs,ArrayList<Integer> arr){
	    if(root!=null){
	        search(root.left,hs,arr);
	        if(hs.contains(root.data)){
	            arr.add(root.data);
	        }
	        search(root.right,hs,arr);
	    }
	    return arr;
	}
	public static ArrayList<Integer> printCommon(Node root1,Node root2)
    {
        //add code here.
        ArrayList<Integer> arr = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();
        hs = in(root1,hs);
        arr = search(root2,hs,arr);
        return arr;
    }
}
