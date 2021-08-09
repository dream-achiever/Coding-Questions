/*
Consider a game where a player can score 3 or 5 or 10 points in a move. Given a total score n, find the number of distinct combinations to reach the given score.

Example 1:

Input:
n = 8
Output: 1
Explanation:when n = 8,{3,5} and {5,3}
are the two possible permutations but
these represent the same cobmination.
Hence output is 1.
Example 2:

Input:
n = 20
Output: 4
Explanation:When n = 20, {10,10},
{5,5,5,5},{10,5,5} and {3,3,3,3,3,5}
are different possible permutations.
Hence output will be 4.
Your Task:
Complete count() function which takes N as an argument and returns the number of ways/combinations to reach the given score.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 ≤ n ≤ 1000
##########################################################################################Solution##################################################################
*/
//User function Template for Java

public static int count(int n, int i,int arr[], int dp[][]){
    
    if(n==0){
        return 1;
    }
    
    if(i<=0 || n<0){
        return 0;
    }
    
    if(dp[i][n]!=-1){
        return dp[i][n];
    }
    
    dp[i][n] = count(n-arr[i-1],i,arr,dp)+count(n,i-1,arr,dp);
    
    return dp[i][n];
}

//Function to find the number of distinct combinations to reach the given score.
public static int count(int n)
{
    //Your code here
    
    int arr[] = {3,5,10};
    
    int dp[][] = new int[4][n+1];
    
    for(int a[] : dp){
        Arrays.fill(a,-1);
    }
    
    return count(n,3,arr,dp);
}
