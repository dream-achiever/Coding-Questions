/*
Given Pointer/Reference to the head of a doubly linked list of N nodes, the task is to Sort the given doubly linked list using Merge Sort in both non-decreasing and non-increasing order.

Example 1:

Input:
N = 8
value[] = {7,3,5,2,6,4,1,8}
Output:
1 2 3 4 5 6 7 8
8 7 6 5 4 3 2 1
Explanation: After sorting the given
linked list in both ways, resultant
matrix will be as given in the first
two line of output, where first line
is the output for non-decreasing
order and next line is for non-
increasing order.
Example 2:

Input:
N = 5
value[] = {9,15,0,-1,0}
Output:
-1 0 0 9 15
15 9 0 0 -1
Explanation: After sorting the given
linked list in both ways, the
resultant list will be -1 0 0 9 15
in non-decreasing order and 
15 9 0 0 -1 in non-increasing order.
Your Task:
The task is to complete the function sortDoubly() which sorts the doubly linked list. The printing is done automatically by the driver code.

Constraints:
1 <= N <= 105

##############################################################################Solution##############################################################################
*/
class LinkedList
{
    
    static Node getMiddle(Node head){
        if(head == null){
            return head;
        }
        Node slow =head,fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    
    static Node mergeSort(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node middle = getMiddle(head);
        Node nextofmiddle = middle.next;
        middle.next=null;
        nextofmiddle.prev=null;
        Node left = mergeSort(head);
        Node right = mergeSort(nextofmiddle);
        Node sorted = sortedMerge(left,right);
        return sorted;
    }
    
    static Node sortedMerge(Node a,Node b){
        Node res=null;
        if(a==null){
            return b;
        }
        if(b==null){
            return a;
        }
        if(a.data<=b.data){
            res = a;
            Node sorted=sortedMerge(a.next,b);
            res.next=sorted;
        
            sorted.prev=res;
            
        }
        else {
            res=b;
            Node sorted=sortedMerge(a,b.next);
            res.next=sorted;
            sorted.prev=res;
        
            
        }
        return res;
    }
    
    static Node sortDoubly(Node head)
    {
        // add your code here
        return mergeSort(head);
    }
}
