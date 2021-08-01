/*
Given a value V and array coins[] of size M, the task is to make the change for V cents, given that you have an infinite supply of each of coins{coins1, coins2, ..., coinsm} valued coins. Find the minimum number of coins to make the change. If not possible to make change then return -1.


Example 1:

Input: V = 30, M = 3, coins[] = {25, 10, 5}
Output: 2
Explanation: Use one 25 cent coin
and one 5 cent coin
Example 2:
Input: V = 11, M = 4,coins[] = {9, 6, 5, 1} 
Output: 2 
Explanation: Use one 6 cent coin
and one 5 cent coin

Your Task:  
You don't need to read input or print anything. Complete the function minCoins() which takes V, M and array coins as input parameters and returns the answer.

Expected Time Complexity: O(V*M)
Expected Auxiliary Space: O(V)

Constraints:
1 ≤ V*M ≤ 106
All array elements are distinct
######################################################################################Solution######################################################################
*/
class Solution{

    int count(int coins[], int M, int sum, int dp[]){
        
        if(sum==0){
            return 0;
        }
        
        if(sum<0){
            return -1;
        }
        
        if(dp[sum]!=0){
            return dp[sum];
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<M;i++){
            if(coins[i]<=sum){
                int curr = count(coins,M,sum-coins[i],dp);
                if(curr>=0){
                    ans = Math.min(ans,curr+1);
                }
            }
        }
        
        if(ans!=Integer.MAX_VALUE){
            dp[sum]=ans;
        }
        else {
            dp[sum]=-1;
        }
        
        return dp[sum];
        
    }

	public int minCoins(int coins[], int M, int V) 
	{ 
	    // Your code goes here
	    
	    int dp[] = new int[1000000];
	    
	    if(V==0){
	        return 0;
	    }
	    
	    if(V==-1){
	        return -1;
	    }
	    
	    int c = count(coins, M, V, dp);
	    return c;
	} 
}
