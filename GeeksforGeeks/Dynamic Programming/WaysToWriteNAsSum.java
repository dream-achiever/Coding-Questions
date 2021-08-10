/*
Given a positive integer N, the task is to find the number of different ways in which N can be written as a sum of two or more positive integers.

Example 1:

Input:
N = 5
Output: 6
Explanation: 
1+1+1+1+1
1+1+1+2
1+1+3
1+4
2+1+2
2+3
So, a total of 6 ways.
Example 2:

Input:
N = 3
Output: 2
Your Task:
Your task is to complete the function countWays() which takes 1 argument(N) and returns the answer%(10^9 + 7).

Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N)

Constraints:
1 <= N <= 103
######################################################################################Solution######################################################################
*/
class Solution
{
    // function to count ways in which n can be
    // expressed as the sum of two or more integers
    int countWays(int n)
    {
         // your code here
         
         int dp[] = new int[n+1];
         dp[0]=1;
         int mod = 1000000007;
         
         for(int i=1;i<n;i++){
             for(int j=i;j<=n;j++){
                 dp[j] = (dp[j]%mod + dp[j-i]%mod)%mod;
             }
         }
         
         return dp[n]%mod;
    }
}
