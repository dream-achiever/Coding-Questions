/*
Given a singly linked list of size N, and an integer K. You need to swap the Kth node from beginning and Kth node from the end in the linked list.
Note: You need to swap the nodes through the links and not changing the content of the nodes.

Example 1:

Input:
N = 4,  K = 1
value[] = {1,2,3,4}
Output: 1
Explanation: Here K = 1, hence after
swapping the 1st node from the beginning
and end thenew list will be 4 2 3 1.
Example 2:

Input:
N = 5,  K = 3
value[] = {1,2,3,4,5}
Output: 1
Explanation: Here k = 3, hence after
swapping the 3rd node from the beginning
and end the new list will be 1 2 3 4 5.
Your Task: 
The task is to complete the function swapkthnode(), which has arguments head, num(no of nodes), and K, and it should return a new head. The validation is done internally by the driver code to ensure that the swapping is done by changing references/pointers only.  A correct code would always cause output as 1.

Expected Time Complexity: O(n)
Expected Auxillary space Complexity: O(1)

Constraints:
1 <= N <= 103
1 <= K <= 103
#######################################################################################Solution#####################################################################
*/
class GFG
{
    // Should swap Kth node from beginning and 
    // Kth node from end in list and return new head.
    Node swapkthnode(Node head, int num, int K)
    {
        // your code here
        if (num < K) 
            return head; 
  

        if (2 * K - 1 == num) 
            return head;
        // Node prevstart = null;
        // Node start=head;
        // Node tempstart=null;
        // for(int i=1;i<K;i++){
        //     prevstart=start;
        //     start=start.next;
        // }
        // System.out.println("prevstart"+((prevstart==null)?100:prevstart.data));
        // System.out.println("start"+start.data);
        // tempstart=start.next;
        // System.out.println("tempstart"+((tempstart==null)?100:tempstart.data));
        
        // Node slow=head;
        // Node end=head;
        // Node prevend=null;
        
        // Node tempend=null;
        
        // for(int i=0;i<K;i++){
        //     if(end==null){
        //         return head;
        //     }
        //     end=end.next;
        // }
        // while(end!=null){
        //     tempend=slow;
        //     slow=slow.next;
        //     end=end.next;
        // }
        // prevend=slow.next;
        // end=slow;
        // System.out.println("prevend"+((prevend==null)?100:prevend.data));
        // System.out.println("end"+end.data);
        // System.out.println("tempend"+((tempend==null)?100:tempend.data));
        // tempend.next=start;
        // start.next=prevend;
        // if(tempend==null){
        //     start.next=prevend;
        // }
        // else {
        //     tempend.next=start;
        //     start.next=prevend;
        // }
        // if(prevstart==null){
        //     end.next=tempstart;
        //     return end;
        // }
        // else {
        //     prevstart.next=end;
        //     end.next=tempstart;
        // }
        Node start = head; 
        Node prevstart = null; 
        for (int i = 1; i < K; i++) { 
            prevstart = start; 
            start = start.next; 
        } 
        Node end = head; 
        Node prevend = null; 
        for (int i = 1; i < num - K + 1; i++) { 
            prevend = end; 
            end = end.next; 
        }
        if (prevstart != null) 
            prevstart.next = end; 
  
        if (prevend != null) 
            prevend.next = start; 
  
        Node temp = start.next; 
        start.next = end.next; 
        end.next = temp; 
  
        if (K == 1) 
            head = end; 
  
        if (K == num) 
            head = start;
        return head;
    }
}
