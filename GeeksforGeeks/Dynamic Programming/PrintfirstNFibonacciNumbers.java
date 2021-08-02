/*
Given a number N, find the first N Fibonacci numbers. The first two number of the series are 1 and 1.

Example 1:

Input:
N = 5
Output: 1 1 2 3 5
Example 2:

Input:
N = 7
Output: 1 1 2 3 5 8 13
Your Task:
Your task is to complete printFibb() which takes single argument N and returns a list of first N Fibonacci numbers.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).
Note: This space is used to store and return the answer for printing purpose.

Constraints:
1<= N <=84
################################################################################Solution############################################################################
*/
class Solution
{
    
   public static long fibo(int n,long dp[]){
        
        if(n==0 || n==1){
            return dp[n];
        }
        
        if(dp[n]!=-1){
            return dp[n];
        }
        
        dp[n] = fibo(n-1,dp)+fibo(n-2,dp);
        
        return dp[n];
    }
    
    //Function to return list containing first n fibonacci numbers.
    public static long[] printFibb(int n) 
    {
        //Your code here
        
        long memo[] = new long[n];
        
        Arrays.fill(memo,-1);
        
        memo[0]=1;
        if(n==1){
            return memo;
        }
        memo[1]=1;
        
        fibo(n-1,memo);
        
        return memo;
    }
}
