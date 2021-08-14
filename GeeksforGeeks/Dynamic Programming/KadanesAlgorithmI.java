/*
Kadane's algorithm comes into picture when we want to find the maximum possible sum in an array when summing the contiguous elements of the array.

You are given an array. Find the maximum possible sum of contiguous elements of the array ending at each position in the array. Also, return the overall maximum that we can achieve.

 

Example 1:

Input:
N = 6
arr[] = {5,-2,-3,32,-5,65}
Output: 5 3 0 32 27 92
        92
Explanation: Maximum sum at each index is
5, 3, 0, 32, 27, 92. And, maximum sum for
contiguous array is 92.

Example 2:

Input:
N = 5
arr[] = {-9,-8,8,3,-4}
Output: -9 -8 8 11 7
         11

Your Task:
This is a function problem. You don't need to take any input. Just complete the function maximumSum() that takes the integer array and its size as inputs and prints the maximum contiguous subarray sum ending at each position in the array. Also, return the overall maximum.


Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).


Constraints:
1 <= sizeOfArray <= 106
-103 <= Ai <= 103
#####################################################################################Solution#######################################################################
*/
class Solution
{
    //Function to print the maximum contiguous subarray sum ending at each 
    //position in the array and return the overall maximum.
    public long maximumSum(int arr[], int n)
    {
       //code here
       
       int dp[] = new int[n+1];
       
       dp[0]=arr[0];
       
       long max = arr[0];
       
       System.out.print(dp[0]+" ");
       
       for(int i=1;i<n;i++){
       
            dp[i] = Math.max(dp[i-1]+arr[i],arr[i]);
            max = Math.max(max,dp[i]);
            System.out.print(dp[i]+" ");
       }
       System.out.println();
       
       return max;
    }

}
