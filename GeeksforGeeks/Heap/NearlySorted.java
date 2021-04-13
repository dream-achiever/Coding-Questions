/*
Given an array of n elements, where each element is at most k away from its target position, you need to sort the array optimally.

Example 1:

Input:
n = 7, k = 3
arr[] = {6,5,3,2,8,10,9}
Output: 2 3 5 6 8 9 10
Explanation: The sorted array will be
2 3 5 6 8 9 10
Example 2:

Input:
n = 5, k = 2
arr[] = {4,3,1,2,5}
Output: 1 2 3 4 5 
Note: DO NOT use STL sort() function for this question.

Your Task:
You are required to complete the method nearlySorted() which takes 3 arguments and returns the sorted array.

Expected Time Complexity : O(nlogk)
Expected Auxilliary Space : O(n)

Constraints:
1 <= n <= 106
1 <= k <= n
1 <= arri <= 107

########################################################################Solution####################################################################################
*/
class Solution
{
    //Function to return the sorted array.
    ArrayList <Integer> nearlySorted(int arr[], int num, int k)
    {
        // your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.add(arr[i]);
        }
        ArrayList<Integer> a = new ArrayList<>();
        for(int i=k;i<num;i++){
            if(arr[i]<pq.peek()){
                a.add(arr[i]);
            }
            else {
                a.add(pq.poll());
                pq.add(arr[i]);
            }
        }
        while(!pq.isEmpty()){
            a.add(pq.poll());
        }
        return a;
    }
}
