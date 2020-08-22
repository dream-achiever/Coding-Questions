/*
Given two numbers represented by two linked lists, write a function that returns Sum list. The sum list is linked list representation of addition of two input numbers.

Example 1:

Input:
S1 = 3, S2 = 3
ValueS1 = {2,3,4}
ValueS2 = {3,4,5}
Output: 5 7 9
Explanation: After adding the 2 numbers
the resultant number is 5 7 9.
Example 2:

Input:
S1 = 1, S2 = 2
ValueS1 = {9}
ValueS2 = {8,7}
Output: 9 6
Explanation: Add 9 and 7 we get 16.
1 is carry here and is added to 8.
So the answer is 9 6
Your Task:
The task is to complete the function addSameSize() addCarryToRemaining().

Constraints:
1 <= S1, S2 <= 100
##############################################################################Solution##############################################################################
*/
class GfG {

    Node cur; // Dont change the variable name, its used in main function
    int carry; // Dont change the variable name, its used in main function
    int sum;
    
    Node reverse(Node prev, Node curr){
        if(curr==null){
            return prev;
        }
        while(curr!=null){
            Node temp = curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return reverse(prev,curr);
    }
    
    void addCarryToRemaining(Node head, LinkedList res)  { 
        // Write code here
        if(head != cur ){
            addCarryToRemaining(head.next,res);
            sum = (head.data + carry)%10;
            carry = (head.data + carry)/10;
            res.push(sum);
        }
    } 
    
	void addSameSize(Node head1, Node head2, LinkedList res) { 
	    // Write code here
	    head1=reverse(null,head1);
	    head2=reverse(null,head2);
	    Node curr1=head1;
	    Node curr2=head2;
	    while(curr1!=null && curr2!=null){
	        sum =(curr1.data+curr2.data+carry)%10;
	        carry=(curr1.data+curr2.data+carry)/10;
	        res.push(sum);
	        curr1=curr1.next;
	        curr2=curr2.next;
	    }
    }
}
