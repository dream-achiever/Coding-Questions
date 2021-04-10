/*
Given an array arr[] of N positive integers and a number K. The task is to find the kth largest element in the array.

Example 1:

Input:
N = 5, K = 3
arr[] = {3, 5, 4, 2, 9}
Output: 
4
Explanation: 
Third largest element
in the array is 4.
Example 2:

Input:
N = 5, K = 5
arr[] = {4, 3, 7, 6, 5} 
Output: 
3
Explanation: 
Fifth largest element
in the array is 3.
Your Task:
You are required to complete the method KthLargest() which takes 3 arguments and returns the Kth Largest element.

Constraints:
1 <= N <= 106
1 <= arr[i] <= 106
1 <= K <= N

Expected Time Complexity : O(NlogK)
Expected Auxilliary Space : O(K)

######################################################################Solution####################################################################################
*/
class Solution 
{
    //Function to return kth largest element from an array.
    public static int KthLargest(int arr[], int n, int k) 
    {
        // Your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.add(arr[i]);
        }
        for(int i=k;i<n;i++){
            if(arr[i]>pq.peek()){
                pq.poll();
                pq.add(arr[i]);
            }
        }
        ArrayList<Integer> a = new ArrayList<>();
        while(!pq.isEmpty()){
            a.add(pq.poll());
        }
        int s = a.size();
        return a.get(s-k);
    }
}
