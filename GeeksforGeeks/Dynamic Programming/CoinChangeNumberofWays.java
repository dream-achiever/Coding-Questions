/*
You have an infinite supply of coins, each having some value. Find out the number of ways to use the coins to sum-up to a certain required value.

Example 1:

Input:
value = 4
numberOfCoins = 3
coins[] = {1,2,3}
Output: 4
Explanation: We need to make the change
for value = 4. The denominations are
{1,2,3} Change for 4 can be made:
1+1+1+1
1+1+2
1+3
2+2
So, as it is evident, we can do this in
4 ways.
Example 2:

Input:
value = 10
numberOfCoins = 4
coins[] = {2,5,3,6}
Output: 5
Your Task:
This is a function problem where you've to complete the funcion numberOfWays (). You are given an amount denoted by value. You are also given an array of coins. The array contains the denominations of the given coins. You need to return the number of ways you can make the change for value using the coins of given denominations. Also, keep in mind that you have an infinite supply of coins.
Note:  Try not to editing the part of the code provided to you in the function. Just complete the function as it has been described.

Expected Time Complexity: O(Number of Coins * Value).
Expected Auxiliary Space: O(Value).

Constraints:
1 <= value <= 103
1 <= numberOfCoins <= 103
1 <= coinsi <= 1000
###################################################################################Solution#########################################################################
*/
class Solution
{
    
    long count(int coins[], int idx, int sum, long dp[][]){
        
        if(sum==0){
            return 1;
        }
        
        if(idx>=coins.length || sum<0){
            return 0;
        }
        
        if(dp[idx][sum]!=-1){
            return dp[idx][sum];
        }
        
        long left = count(coins,idx,sum-coins[idx],dp);
        long right = count(coins,idx+1,sum,dp);
        
        dp[idx][sum] = left + right;
        
        return dp[idx][sum];
        
    }
    
    //Function to find out the number of ways to use the coins to
    //sum up to a certain required value.
    public long numberOfWays(int coins[],int n,int value)
    {
        
        long dp[][] = new long[n][value+1];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<=value;j++){
                dp[i][j] = -1;
            }
        }
        
        long c = count(coins,0,value,dp);
        
        return c;
    }
}
