/*
You are given an array arr of size sizeOfArr. You need to find the maximum sum in the array provided that you cannot sum neighboring elements or adjacent elements.

Example 1:

Input:
sizeOfArr = 4
arr[] = {4,5,6,7,8}
Output: 18
Explanation:The given elements are 4 5 6 7 8
For 4, the maximum sum will be 4 as no
element other than 4 from index 0 to 0
For 5, the maximum sum will be 5 as we cannot
add 4 and 5(neighboring elements).
For 6, the maximum sum will be 10 as we can
add 6 and 4.
For 7, the maximum sum will be 12 as we can
add 7 and 5.
For 8, the maximum sum will be 18 as we can
add 4 and 6 and 8.
Example 2:

Input:
sizeOfArr = 5
arr[] = {-9,-8,8,3,-4}
Output: 8
Your Task:
This is a function problem. You only need to complete the function maximumSum() that takes array and sizeOfArray and returns the maximum sum of the array provided that you cannot sum neighboring elements.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= sizeOfArr <= 106
-103 <= arri <= 103
################################################################################Solution############################################################################
*/
class Solution
{
    //Function to return the maximum sum without adding adjacent elements.
    public long maximumSum(int arr[], int n)
    {
      //Your code here
      
      int dp[] = new int[n+1];
      
      dp[0]=arr[0];
      int max = dp[0];
      if(n==1){
          return max;
      }
      
      dp[1] = Math.max(arr[0],arr[1]);
      max = Math.max(max,dp[1]);
      
      
      for(int i=2;i<n;i++){
          
        if(dp[i-2]>=0){
            dp[i]=Math.max(dp[i-1],dp[i-2]+arr[i]);
        }
        else{
            dp[i]=Math.max(dp[i-1],arr[i]);
        }

        max = Math.max(max,dp[i]);
      }
      
      return max;
      
    }

}
