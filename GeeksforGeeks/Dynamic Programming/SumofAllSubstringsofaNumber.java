/*
Given an integer S represented as a string, the task is to get the sum of all possible sub-strings of this string.
As the answer will be large, print it modulo 10^9+7.

Example 1:

Input:
S = 1234
Output: 1670
Explanation: Sum = 1 + 2 + 3 + 4 + 12 +
23 + 34 + 123 + 234 + 1234 = 1670
Example 2:

Input:
S = 421
Output: 491
Explanation: Sum = 4 + 2 + 1 + 42 + 21
Your Task:
You only need to complete the function sumSubstrings that takes S as an argument and returns the answer modulo 1000000007.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= |S| <= 104
##########################################################################################Solution##################################################################
*/
class Solution
{
    //Function to find sum of all possible substrings of the given string.
    public static long sumSubstrings(String s)
    {
    //Your code here
    
        long prev_res = s.charAt(0)-'0';
        int mod = 1000000007;
        long res = prev_res%mod;
        
        long sub_res=0;
        int len = s.length();
        
        for(int i=1;i<len;i++){
            sub_res = ((i+1)*(s.charAt(i)-'0')+10*prev_res)%mod;
            
            res = (res + sub_res)%mod;
            
            prev_res = sub_res;
        }
        
        return res%mod;
    }
}
