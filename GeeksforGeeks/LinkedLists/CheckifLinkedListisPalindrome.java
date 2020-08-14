/*
Given a singly linked list of size N of integers. The task is to check if the given linked list is palindrome or not.

Example 1:

Input:
N = 3
value[] = {1,2,1}
Output: 1
Explanation: The given linked list is
1 2 1 , which is a palindrome and
Hence, the output is 1.
Example 2:

Input:
N = 4
value[] = {1,2,3,4}
Output: 0
Explanation: The given linked list
is 1 2 3 4 , which is not a palindrome
and Hence, the output is 0.
Your Task:
The task is to complete the function isPalindrome() which takes head as reference as the only parameter and returns true or false if linked list is palindrome or not respectively.

Expected Time Complexity: O(N)
Expected Auxialliary Space Usage: O(1)  (ie, you should not use the recursive stack space as well)

Constraints:
1 <= N <= 50

#################################################################################Solution###########################################################################
*/
class Palindrome
{
    // Function to check if linked list is palindrome
    static Node reverse(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node curr = head.next;
        Node prev = null;
        head.next=prev;
        prev=head;
        while(curr!=null){
            Node temp = curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
    boolean isPalindrome(Node head) 
    {
        //Your code here
        // Node head1=reverse(head);
        // //System.out.println(head1.next.data);
        // for(Node curr = head,temp=head1;curr!=null && temp!=null;curr=curr.next,temp=temp.next){
        //     System.out.println("curr "+curr.data+" "+"temp "+temp.data);
        //     if(curr.data!=temp.data){
        //         return false;
        //     }
        // }
        // return true;
        if(head==null && head.next==null){
            return true;
        }
        int count=0;
        for(Node curr = head;curr!=null;curr=curr.next){
            count++;
        }
        Node curr = head;
        for(int i=0;i<count/2;i++){
            curr=curr.next;
        }
        Node newhead = reverse(curr);
        int i=0;
        for(Node temp1=head,temp2=newhead;i<count/2;temp1=temp1.next,temp2=temp2.next,i++){
            if(temp1.data!=temp2.data){
                return false;
            }
        }
        return true;
    }    
}
