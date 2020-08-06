/*
Given a linked list of size N and a key. The task is to insert the key in the middle of the linked list.

Example 1:

Input:
N = 3
value[] = {1,2,4}
key = 3
Output: 1 2 3 4
Explanation: The new element is inserted
after the current middle element in the
linked list.
Example 2:

Input:
N = 4
value[] = {10,20,40,50}
key = 30
Output: 10 20 30 40 50
Explanation: The new element is inserted
after the current middle element in the
linked list and Hence, the output is
10 20 30 40 50.
 

Your Task:
The task is to complete the function insertInMiddle() which takes head reference and element to be inserted as the arguments. The printing is done automatically by the driver code.

Expected Time Complexity : O(N)
Expected Auxilliary Space : O(1)

Constraints:
1 <= N <= 104

#############################################################################Solution###############################################################################
*/
class Solution {
    
    public Node insertInMid(Node head, int data){
        //Insert code here, return the head of modified linked list
        
        Node slow=head;
        Node fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node temp = new Node(data);
        Node lat = slow.next;
        slow.next = temp;
        temp.next = lat;
        return head;
        
    }
}
