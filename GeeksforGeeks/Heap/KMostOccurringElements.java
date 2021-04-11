/*
Given an array arr[] of N integers in which elements may be repeating several times. Also, a positive number K is given and the task is to find sum of total frequencies of K most occurring elements

Note: The value of K is guaranteed to be less than or equal to the number of distinct elements in arr.

Example 1:

Input:
N = 8
arr[] = {3,1,4,4,5,2,6,1}
K = 2
Output: 4
Explanation: Since, 4 and 1 are 2 most
occurring elements in the array with
their frequencies as 2, 2. So total
frequency is 2 + 2 = 4.
Example 2:

Input:
N = 8
arr[] = {3,3,3,4,1,1,6,1}
K = 2
Output: 6
Explanation: Since, 3 and 1 are most
occurring elements in the array with
frequencies 3, 3 respectively. So,
total frequency is 6.
Your Task:
Complete the function kMostFrequent() whic returns the frequencies of K most occuring elements.

Constraints:
1 <= N <= 107
1 <= K <= N
1 <= arr[i] <= 106

Expected Time Complexity : O(N)
Expected Auxilliary Space: O(N)
##########################################################################Solution##################################################################################
*/
class Solution
{
    //Function to print the sum of frequencies of k numbers
    //with most occurrences in an array.
    void kMostFrequent(int arr[], int n, int k){
        // your code here
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer,Integer> hs = new HashMap<>();
        int sum=0;
        for(int i=0;i<n;i++){
            if(hs.containsKey(arr[i])){
                hs.put(arr[i],hs.get(arr[i])+1);
            }
            else {
                hs.put(arr[i],1);
            }
        }
        for(int i=0;i<n;i++){
            if(hs.containsKey(arr[i])){
                pq.add(hs.remove(arr[i]));
            }
        }
        for(int i=0;i<k;i++){
            sum+=pq.poll();
        }
        System.out.println(sum);
    }
}
