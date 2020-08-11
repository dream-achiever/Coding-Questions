/*
Given a singly linked list of size N. The task is to rotate the linked list counter-clockwise by k nodes, where k is a given positive integer smaller than or equal to length of the linked list.

Example 1:

Input:
N = 8
value[] = {1,2,3,4,5,6,7,8}
k = 4
Output: 5 6 7 8 1 2 3 4
Explanation:
Example 2:

Input:
N = 5
value[] = {2,4,7,8,9}
k = 3
Output: 8 9 2 4 7
Explanation:
Your Task:
The task is to complete the function rotate() which takes a head reference as the first argument and k as the second argument. The printing is done automatically by the driver code.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N <= 103
1 <= k <= 103
#################################################################################Solution###########################################################################
*/
class Rotate{
    // This function should rotate list counter-
    // clockwise by k and return head node
    
    public Node rotate(Node head, int k) {
        // add code here
        if(k==0){
            return head;
        }
        Node curr=head;
        for(int i=0;i<k-1;i++){
            curr=curr.next;
        }
        Node temp = curr.next;
        curr.next=null;
        Node res_head=temp;
        for(;temp!=null && temp.next!=null;temp=temp.next){
            
        }
        if(temp==null){
            return head;
        }
        temp.next=head;
        return res_head;
    }
}
