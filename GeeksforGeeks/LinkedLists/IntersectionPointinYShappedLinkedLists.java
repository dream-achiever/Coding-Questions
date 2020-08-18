/*
Given two singly linked lists of size N and M, write a program to get the point where two linked lists intersect each other.

Y ShapedLinked List
Above diagram shows an example with two linked list having 15 as intersection point.

Example 1:

Input:
LinkList1 = {10,20,5,10}
LinkList2 = {30,40,50,5,10}
Output: 5
Explanation:The point of intersection of
two linked list is 5, means both of them
get linked (intersects) with each other
at node whose value is 5.
Your Task:
The task is to complete the function intersetPoint() which finds the point of intersection of two linked list. The function should return data value of a node where two linked lists merge. If linked list do not merge at any point, then it should return -1.

Challenge : Try to solve the problem without using any extra space.

Expected Time Complexity: O(N+M)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 100
1 <= value <= 1000

##############################################################################Solution##############################################################################
*/
class Intersect
{
	int intersectPoint(Node headA, Node headB)
	{
         // code here
         int c1=0,c2=0;
         for(Node curr=headA;curr!=null;curr=curr.next){
             c1++;
         }
         for(Node curr=headB;curr!=null;curr=curr.next){
             c2++;
         }
         Node curr = null;
         if(c1>c2){
             curr=headA;
         }
         else {
             curr=headB;
         }
         for(int i=0;i<Math.abs(c1-c2);i++){
             curr=curr.next;
         }
         Node curr1=headA;
         Node curr2=headB;
         if(c1>c2){
             curr1=curr;
         }
         else {
             curr2=curr;
         }
         while(curr1!=null && curr2!=null){
             if(curr1==curr2){
                 return curr1.data;
             }
             curr1=curr1.next;
             curr2=curr2.next;
         }
        return -1;    
	}
}
