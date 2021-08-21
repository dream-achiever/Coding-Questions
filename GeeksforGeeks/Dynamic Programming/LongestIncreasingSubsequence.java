/*
Given an array of integers, find the length of the longest (strictly) increasing subsequence from the given array.

Example 1:

Input:
N = 16
A[]={0,8,4,12,2,10,6,14,1,9,5
     13,3,11,7,15}
Output: 6
Explanation:Longest increasing subsequence
0 2 6 9 13 15, which has length 6
Example 2:

Input:
N = 6
A[] = {5,8,3,7,9,1}
Output: 3
Explanation:Longest increasing subsequence
5 7 9, with length 3
Your Task:
Complete the function longestSubsequence() which takes the input array and its size as input parameters and returns the length of the longest increasing subsequence.

Expected Time Complexity : O( N*log(N) )
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 105
0 ≤ A[i] ≤ 106
#######################################################################################Solution#####################################################################
*/
class Solution 
{
    
    static int ceil(int[] tail, int start, int end,int x){
        
        
        while(start<end) {
            
            int mid = start + (end-start)/2;
            
            if(tail[mid]>=x){
                end=mid;
            }
            else {
                start = mid+1;
            }
        }
        return end;
    }
    
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int a[])
    {
        // code here
        
        int tail[] = new int[size+1];
        tail[0] = a[0];
        
        int len = 1;
        
        for(int i=1;i<size;i++){
            
            if(a[i]>tail[len-1]){
                tail[len++]=a[i];
            }
            else {
                int c = ceil(tail,0,len-1,a[i]);
                tail[c]=a[i];
            }
            
        }
        return len;
    }
}
