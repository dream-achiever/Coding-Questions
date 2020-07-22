/*
Given two strings s1 and s2. Modify both the strings such that all the common characters of s1 and s2 are to be removed and the uncommon characters of s1 and s2 are to be concatenated.
Note: If all characters are removed print -1.

Input:
The first line consists of an integer T i.e number of test cases. The first line of each test case consists of a string s1. The next line consists of a string s2. 

Output:
Print the concatenated string.

User Task:
The task is to complete the function concatenatedString() which removes the common characters, concatenates, and returns the string. If all characters are removed then return -1.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Number of distinct characters).

Constraints: 
1 <= T <= 200
1 <= |Length of Strings| <= 104

Example:
Input:
2
aacdb
gafd
abcs
cxzca

Output:
cbgf
bsxz

Explanation:
Testcase 1: The common characters of s1 and s2 are: a, d. The uncommon characters of s1 and s2 are c, b, g and f. Thus the modified string with uncommon characters concatenated is cbgf.

Testcase 2: The common characters of s1 and s2 are: a,c. The uncommon characters of s1 and s2 are b,s,x and z. Thus the modified string with uncommon characters concatenated is bsxz.
###############################################################Solution##############################################################################################
*/
class RemoveCommon{
    
    // Function which concatenate two strings
    // after removing common characters
    public static String concatenatedString(String s1,String s2){
        
        // Your code here
        int count[] = new int[256];
        int count2[] = new int[256];
        String s="";
        Arrays.fill(count,-1);
        for(int i=0;i<s1.length();i++){
            if(count[s1.charAt(i)]==-1){
                count[s1.charAt(i)]=1;
            }
            else {
                count[s1.charAt(i)]++;
            }
        }
        for(int i=0;i<s2.length();i++){
            if(count[s2.charAt(i)]!=-1){
                count[s2.charAt(i)]=-1;
                count2[s2.charAt(i)]=-2;
            }
            else if(count2[s2.charAt(i)]!=-2) {
                if(count2[s2.charAt(i)]==-1){
                    count2[s2.charAt(i)]=1;
                }
                else {
                    count2[s2.charAt(i)]++;
                }
            }
        }
        for(int i=0;i<s1.length();i++){
            if(count[s1.charAt(i)]>-1){
                s+=s1.charAt(i);
            }
        }
        for(int i=0;i<s2.length();i++){
            if(count2[s2.charAt(i)]>-1){
                s+=s2.charAt(i);
            }
        }
        return (s.length()>0)?s:"-1";
    }
}
