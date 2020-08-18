/*
Given K sorted linked lists of different sizes. The task is to merge them in such a way that after merging they will be a single sorted linked list.

Example 1:

Input:
K = 4
value = {{1,2,3},{4 5},{5 6},{7,8}}
Output: 1 2 3 4 5 5 6 7 8
Explanation:
The test case has 4 sorted linked 
list of size 3, 2, 2, 2
1st    list     1 -> 2-> 3
2nd   list      4->5
3rd    list      5->6
4th    list      7->8
The merged list will be
1->2->3->4->5->5->6->7->8.
Example 2:

Input:
K = 3
value = {{1,3},{4,5,6},{8}}
Output: 1 3 4 5 6 8
Explanation:
The test case has 3 sorted linked
list of size 2, 3, 1.
1st list 1 -> 3
2nd list 4 -> 5 -> 6
3rd list 8
The merged list will be
1->3->4->5->6->8.
Your Task:
The task is to complete the function mergeKList() which merges the K given lists into a sorted one. The printing is done automatically by the driver code.

Expected Time Complexity: O(nk Logk)
Expected Auxiliary Space: O(k)
Note: n is the maximum size of all the k link list

Constraints
1 <= K <= 103
##############################################################################Solution##############################################################################
*/
class Merge
{
    
    Node sortedMerge(Node a,Node b){
        Node res=null;
        if(a==null){
            return b;
        }
        if(b==null){
            return a;
        }
        if(a.data<=b.data){
            res=a;
            res.next=sortedMerge(a.next,b);
        }
        else {
            res=b;
            res.next=sortedMerge(a,b.next);
        }
        return res;
    }
    
    Node mergeKList(Node[]a,int N)
    {
        //Add your code here.
        if(a.length==0){
            return null;
        }
        if(a.length==1){
            return a[0];
        }
        Node head=null;
        int i=1;
        for(;i<N;i+=2){
            Node head1=sortedMerge(a[i-1],a[i]);
            head=sortedMerge(head,head1);
        }
        if(i==N){
            head=sortedMerge(head,a[i-1]);
        }
        return head;
    }
}
