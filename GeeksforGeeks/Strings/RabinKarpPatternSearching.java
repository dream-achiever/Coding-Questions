/*
Given a string S and a pattern P of lowercase characters. The task is to check if the pattern is present in string or not.

Input:
The first line of input contains the number of test cases T. For each testcase, the first line of input contains string S and the next line contains pattern P.

Output:
For each testcase, print "Yes" if the pattern is found in the string else print "No".

Your Task:
This is a function problem. You need to complete the function search which takes 3 arguments(S, P and prime q) and returns true if the pattern is found else returns false.

Expected Time Complexity: O(N + M).
Expected Auxiliary Space: O(1).
Note: N = |S|, M = |P|.

Constraints:
1 <= T <= 100
1 <= |S|, |P| <= 104

Example:
Input:
2
aabaacaadaabaaba
aaba
aabaacaadaabaaba
asdfa
Output:
Yes
No

Explanation:
Testcase 1: You can find the patter at starting at index 12.
Testcase 2: Pattern doesn't exist in the given string S.
#############################################################################Solution###############################################################################
*/
class match
{
    static int d= 256;
    
    static boolean search(String pat, String txt, int q)
    {
            // Your code here
            int m=txt.length();
        	int n=pat.length();
        	int i,j;
        	int h=1;
        	for(i=0;i<n-1;i++){
        	    h=(h*d)%q;
        	}
        	int p=0,t=0;
        	for(i=0;i<n;i++){
        	    p=(p*d+pat.charAt(i))%q;
        	    t=(t*d+txt.charAt(i))%q;
        	}
        	for(i=0;i<=m-n;i++){
        	    if(p==t){
        	        for(j=0;j<n;j++){
        	            if(txt.charAt(i+j)!=pat.charAt(j)){
        	                break;
        	            }
        	        }
        	        if(j == n){
        	            return true;
        	        }
        	    }
        	    if(i<m-n){
        	        t=(d*(t-txt.charAt(i)*h)+txt.charAt(i+n))%q;
        	        if(t<0){
        	            t=t+q;
        	        }
        	    }
        	}
        	return false;
    }
}
