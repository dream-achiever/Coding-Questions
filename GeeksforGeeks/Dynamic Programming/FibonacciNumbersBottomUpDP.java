/*
One of the rudimentary problems to understand DP is finding the nth Fibonacci number. Here, we will solve the problem using a bottom-up approach.
You are given a number N. You need to find the Nth Fibonacci number. The first two number of the series are 1 and 1.

Example 1:

Input:
N = 5
Output: 5
Example 2:

Input:
N = 7
Output: 13
Explanation: Some of the numbers of the
Fibonacci numbers are 1, 1, 2, 3, 5, 8,13
..... (N stars from 1).
Your Task:
You don't need to take any input. You have to complete the function findNthFibonacci() which takes single argument(number N) and returns the answer.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 <= N <= 92
#################################################################################Solution###########################################################################
*/
class Solution
{
    //Function to find the nth fibonacci number using bottom-up approach.
    public long findNthFibonacci(int number)
    {
        // Your Code Here
        
        long dp[] = new long[number+1];
        
        dp[0]=0L;
        dp[1]=1L;
        
        for(int i=2;i<=number;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[number];
    }

}
