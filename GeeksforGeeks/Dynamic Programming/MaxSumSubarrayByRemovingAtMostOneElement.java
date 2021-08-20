/*
You are given array A of size n. You need to find the maximum-sum sub-array with the condition that you are allowed to skip at most one element.

Example 1:

Input:
n = 5
A[] = {1,2,3,-4,5}
Output: 11
Explanation: We can get maximum sum
subarray by skipping -4.
Example 2:

Input:
n = 8
A[] = {-2,-3,4,-1,-2,1,5,-3}
Output: 9
Explanation: We can get maximum sum
subarray by skipping -2 as [4,-1,1,5]
sums to 9, which is the maximum
achievable sum.
Your Task:

Your task is to complete the function maxSumSubarray that take array and size as parameters and returns the maximum sum.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= n <= 100
-103 <= Ai<= 103
#######################################################################################Solution#####################################################################
*/
class Solution
{
    //Function to return maximum sum subarray by removing at most one element.
    public static int maxSumSubarray(int A[], int n)
    {
     //add code here.
     if(n==1){
         return A[0];
     }
     
     int len = n;
     int fw[] = new int[len];
     int bw[] = new int[len];
     
     fw[0]=A[0];
     bw[len-1] = A[len-1];
     
     for(int i=1;i<len;i++){
         fw[i] = Math.max(fw[i-1]+A[i],A[i]);
     }
     
     for(int i=len-2;i>=0;i--){
         bw[i] = Math.max(bw[i+1]+A[i],A[i]);
     }
     
     int max_sum = Integer.MIN_VALUE, x, y;
     for(int i=0;i<len;i++){
         
         x = ((i==0)? 0: fw[i-1]);
         
         y = ((i==len-1)? 0 : bw[i+1]);
         
         max_sum = Math.max( max_sum , Math.max(x+y,fw[i]+bw[i]-A[i]) );
     }
     
     return max_sum;
    }
}
