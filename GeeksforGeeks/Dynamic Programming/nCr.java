/*
Find nCr for given n and r.

Example 1:

Input:
n = 3, r = 2
Output: 3
Example 2:

Input:
n = 4, r = 2
Output: 6
Your Task:
Complete the function nCrModp() which takes two integers n and r as input parameters and returns the nCr mod 109+7.
Note: nCr does not exist when r > n. Hence, return 0 in that case.

Expected Time Complexity : O(N*R)
Expected Auxiliary Space: O(N)

Constraints:
1<= n <= 103
1<= r <= 103
####################################################################################Solution########################################################################
*/
class Solution
{
    
    public static int cUtil(int n, int r,int dp[][],int mod){
        
        if(n==r){
            dp[n][r]=1;
            return dp[n][r];
        }
        
        if(dp[n][r]!=-1){
            
            return dp[n][r];
        }
        
        dp[n][r]=(cUtil(n-1,r-1,dp,mod)%mod + cUtil(n-1,r,dp,mod)%mod)%mod;
        return dp[n][r];
    }
    
    //Function to return nCr mod 10^9+7 for given n and r.
    public static int nCrModp(int n, int r)
    {
        // your code here
        
        if(r>n) {
          return 0;
        }
        
        if(r==0||n==r){
            return 1;
        }
        
        int dp[][] = new int[n+1][r+1];
        for(int arr[] : dp){
            Arrays.fill(arr,-1);
        }
        
        for(int j=0;j<=r;j++){
            dp[0][j]=0;
        }
        
        for(int i=1;i<=n;i++){
            dp[i][0]=1;
        }
        
        int mod = 1000000007;
        
        return cUtil(n,r,dp,mod);
      
    }
}
