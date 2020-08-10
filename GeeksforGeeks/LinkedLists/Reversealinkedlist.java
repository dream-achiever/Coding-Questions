/*
Given a linked list of N nodes. The task is to reverse this list.

Example 1:

Input:
N = 6
value[] = {1,2,3,4,5,6}
Output: 6 5 4 3 2 1
Explanation: After reversing the list, 
elements are 6->5->4->3->2->1.
Example 2:

Input:
N = 5
value[] = {2,7,8,9,10}
Output: 10 9 8 7 2
Explanation: After reversing the list,
elements are 10->9->8->7->2.
Your Task:
The task is to complete the function reverseList() with head reference as the only argument and should return new head after reversing the list.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 104

#################################################################################Solution###########################################################################
*/
class ReverseLL
{
    // This function should reverse linked list and return
    // head of the modified linked list.
    Node reverse(Node prev,Node curr){
        
        if(curr==null){
            return prev;
        }
        Node temp=curr.next;
        curr.next=prev;
        prev = curr;
        curr = temp;
        
        return reverse(prev,curr);
    }
    Node reverseList(Node head)
    {
        // code here
        Node prev = null;
        return reverse (prev,head);
    }
}
