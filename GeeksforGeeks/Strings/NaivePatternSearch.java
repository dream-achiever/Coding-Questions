/*
Given a string S and a pattern P both of lowercase characters. The task is to check if the given pattern exists in the given string or not.

Input:
The first line of input contains the number of test cases T. For each testcase, the first line will the string and the second line will be the pattern to be searched.

Output:
For each testcase, print "Yes" if the pattern exists or "No" if doesn't.

User Task:
The task is to complete the function search() which finds the pattern in the given string. The function takes pattern and string as parameters and returns either true or false. Return true if pattern exists else return false.

Expected Time Complexity: O(N*M).
Expected Auxiliary Space: O(1).
Note: N = |S|, M = |P|.

Constraints:
1 <= T <= 100
1 <= |S|, |P| <= 103

Example:
Input:
2
aabaacaadaabaaabaa
aaba
aabaacaadaabaaabaa
ccda
Output:
Yes
No

Explanation:
Testcase 1: Given pattern aaba is found in the string at index 0.
Testcase 2: Given pattern ccda doesn't exists in the string at all.
################################################################################Solution##########################################################################
*/
class Search{
    
    /*  Function to search pattern in the given string
    *   pat: pattern given in input
    *   txt: string given in the input
    */
    static boolean search(String pat, String txt)
    {
            // Your code here
            int count [] = new int[256];
            
            int n = txt.length();
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
