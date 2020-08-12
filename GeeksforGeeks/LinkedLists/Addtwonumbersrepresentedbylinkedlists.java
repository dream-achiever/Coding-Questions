/*
Given two numbers represented by two linked lists of size N and M. The task is to return a sum list. The sum list is a linked list representation of the addition of two input numbers.

Example 1:

Input:
N = 2
valueN[] = {4,5}
M = 3
valueM[] = {3,4,5}
Output: 3 9 0  
Explanation: For the given two linked
list (4 5) and (3 4 5), after adding
the two linked list resultant linked
list will be (3 9 0).
Example 2:

Input:
N = 2
valueN[] = {6,3}
M = 1
valueM[] = {7}
Output: 7 0
Explanation: For the given two linked
list (6 3) and (7), after adding the
two linked list resultant linked list
will be (7 0).
Your Task:
The task is to complete the function addTwoLists() which has node reference of both the linked lists and returns the head of the new list.

Expected Time Complexity: O(N) + O(M)
Expected Auxiliary Space: O(N) + O(M)

Constraints:
1 <= N, M <= 5000

#################################################################################Solution###########################################################################
*/
class Solution{
    
    static Node reverse(Node head){
        Node prev = null;
        Node curr = head;
        Node next = null;
        
        while(curr != null)
        {
            next = curr.next;     
            curr.next = prev;     
            prev = curr;          
            curr = next;          
        }
        
        return prev;
    }
    
    static Node addLists(Node first, Node second){
        // code here
        // return head of sum list
        
        first=reverse(first);
        second=reverse(second);
        Node sum=null;
        int carry=0;
        while(first!=null || second!=null || carry>0){
            int newVal = carry;
            if(first!=null) newVal+=first.data;
            if(second!=null) newVal+=second.data;
            carry=newVal/10;
            newVal=newVal%10;
            Node newNode = new Node(newVal);
            newNode.next=sum;
            sum=newNode;
            if(first!=null) first=first.next;
            if(second!=null) second=second.next;
        }
        return sum;
    }
}
