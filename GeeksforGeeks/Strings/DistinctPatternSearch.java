/*
Given a string S and a pattern P (of distinct characters) consisting of lowercase characters. The task is to check if pattern P exists in the given string S or not.
Note : Pattern has distinct characters. There might be repetitions in text.

Input:
First line of input contains number of testcases T. For each testcase, first line of input contains string S and next line contains pattern P.

Output:
For each testcase, print "Yes" if pattern is found in the given string, else print "No".

User Task:
The task is to complete the function search() which finds for the pattern with distinct characters. The function takes string and pattern as parameters and returns either true or false. Return true if pattern is found else return false.

Expected Time Complexity: O(N + M).
Expected Auxiliary Space: O(1).
Note: N = |S|, M = |P|.

Constraints:
1 <= T <= 100
1 <= |S|, |P| <= 103

Example:
Input:
2
abceabcdabceabcd
abcd
abceabcdabceabcd
gfhij
Output:
Yes
No

Explanation:
Testcase 1: Given pattern abcd is present at index 4.
Testcase 2: Given pattern gfhij is not found in the string.
################################################################################Solution#############################################################################
*/
class Search{

    /*  function to search for a pattern with distinct characters
    *   pat: pattern(to be searched in txt) given in the input
    *   txt: string given in the input
    */
    static boolean search(String pat, String txt)
    {
        // Your code here
        int n=txt.length();
        int m = pat.length();
        
        for(int i=0;i<=n-m;){
            int j;
            for(j=0;j<m;j++){
                if(txt.charAt(i+j)!=pat.charAt(j)){
                    break;
                }
            }
            if(j==m){
                return true;
            }
            if(j==0){
                i++;
            }
            else {
                i=i+j;
            }
        }
        return false;
    }
}
