/*
Given a singly linked list consisting of N nodes. The task is to remove duplicates (nodes with duplicate values) from the given list (if exists).
Note: Try not to use extra space. Expected time complexity is O(N). The nodes are arranged in a sorted way.

Example 1:

Input:
N = 4
value[] = {2,2,4,5}
Output: 2 4 5
Explanation: In the given linked list 
2 ->2 -> 4-> 5, only 2 occurs more 
than 1 time.
Example 2:

Input:
N = 5
value[] = {2,2,2,2,2}
Output: 2
Explanation: In the given linked list 
2 ->2 ->2 ->2 ->2, 2 is the only element
and is repeated 5 times.
Your Task:
The task is to complete the function removeDuplicates() which should remove the duplicates from linked list. 

Expected Time Complexity : O(N)
Expected Auxilliary Space : O(1)

Constraints:
1 <= N <= 104
#########################################################################Solution###################################################################################
*/
class GfG
{
    // head: head node
    Node removeDuplicates(Node root)
    {
	// Your code here
	    Node slow = root;
	    Node fast = root.next;
	    while(fast!=null){
	        if(slow.data==fast.data){
	            Node temp = fast.next;
	            slow.next=temp;
	            fast=temp;
	        }
	        else {
	            slow=slow.next;
	        }
	    }
	    return root;
    }
}
