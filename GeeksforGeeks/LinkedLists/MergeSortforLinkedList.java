/*
Given Pointer/Reference to the head of the linked list, the task is to Sort the given linked list using Merge Sort.
Note: If the length of linked list is odd, then the extra node should go in the first list while splitting.

Example 1:

Input:
N = 5
value[]  = {3,5,2,4,1}
Output: 1 2 3 4 5
Explanation: After sorting the given
linked list, the resultant matrix
will be 1->2->3->4->5.
Example 2:

Input:
N = 3
value[]  = {9,15,0}
Output: 0 9 15
Explanation: After sorting the given
linked list , resultant will be
0->9->15.
Your Task:
For C++ and Python: The task is to complete the function mergeSort() which sort the linked list using merge sort function.
For Java: The task is to complete the function mergeSort() and return the node which can be used to print the sorted linked list.

Expected Time Complexity: O(N*Log(N))
Expected Auxiliary Space: O(1)

Constraints:
1 <= T <= 100
1 <= N <= 105

#########################################################################################Solution###################################################################
*/
class LinkedList
{
    
    static Node getMiddle(Node head){
        if(head==null){
            return head;
        }
        
        Node slow=head,fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    
    static Node sortedMerge(Node a,Node b){
        Node result=null;
        if(a==null){
            return b;
        }
        if(b==null){
            return a;
        }
        if(a.data <= b.data){
            result = a;
            result.next=sortedMerge(a.next,b);
        }
        else {
            result=b;
            result.next=sortedMerge(a,b.next);
        }
        return result;
    }
    
    static Node mergeSort(Node head)
    {
        // add your code here
        if(head==null || head.next==null){
            return head;
        }
        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;
        middle.next=null;
        Node left = mergeSort(head);
        Node right = mergeSort(nextOfMiddle);
        Node sorted = sortedMerge(left,right);
        return sorted;
    }
}
