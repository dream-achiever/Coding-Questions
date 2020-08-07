/*
Given two Singly Linked List of N and M nodes respectively. The task is to check whether two linked lists are identical or not. 
Two Linked Lists are identical when they have same data and with same arrangement too.

Example 1:

Input:
N = 6
valueN[] = {1,2,3,4,5,6}
M = 4
valueM[] = {99,59,42,20}
Output: Not identical
Explanation: 
Example 2:

Input:
N = 5
valueN[] = {1,2,3,4,5}
M = 5
valueM[] = {1,2,3,4,5}
Output: Identical
Explanation: 
Your Task:
The task is to complete the function areIdentical() which takes the head of both linked lists as arguments and returns True or False.

Constraints:
1 <= N <= 103

Expected Time Complexity : O(N)
Expected Auxilliary Space : O(1)

#################################################################Solution###########################################################################################
*/
class Solution {
    
    // Function which returns true if both linked
    // lists are identical else return false
    public boolean isIdentical (Node head1, Node head2){
        //write your code here and return true if they are identical, otherwise false
        int s1=0,s2=0;
        Node curr=head1;
        Node curr2 = head2;
        while(curr!=null){
            s1++;
            curr=curr.next;
        }
        while(curr2!=null){
            s2++;
            curr2=curr2.next;
        }
        if(s1!=s2){
            return false;
        }
        
        curr=head1;
        curr2=head2;
        while(curr!=null && curr2!=null){
            if(curr.data !=curr2.data){
                return false;
            }
            curr = curr.next;
            curr2 = curr2.next;
        }
        
        return true;
    }
