/*
Given a string str. The task is to find the maximum occurring character in the string str. If more than one character occurs the maximum number of time then print the lexicographically smaller character.

Input:
The first line of input contains an integer T denoting the number of test cases. Each test case consists of a string in 'lowercase' only in a separate line.

Output:
For each testcase, in a new line, print the lexicographically smaller character which occurred the maximum number of time.

User Task:
The task is to complete the function getMaxOccuringChar() which returns the character which is most occurring.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Number of distinct characters).

Constraints:
1 ≤ T ≤ 30
1 ≤ |s| ≤ 100

Example:
Input:
2
testsample
output

Output:
e
t

Explanation:
Testcase 1: e is the character which is having the highest frequency.
Testcase 2: t and u are the characters with the same frequency, but t is lexicographically smaller.

##############################################################################Solution##############################################################################
*/
class MaxOccur{
    
    // Function to get maximum occuring 
    // character in given string str
    public static char getMaxOccuringChar(String line){
        
        // Your code here
        int count[] = new int[256];
        for(int i=0;i<line.length();i++){
            count[line.charAt(i)]++;
        }
        int max = Integer.MIN_VALUE;
        int pos=0;
        for(int i=0;i<256;i++){
            if(max<count[i]){
                max=count[i];
                pos=i;
            }
            else{ 
                if(max==count[i]){
                    if(pos>i){
                        pos=i;
                    }
                }
            }
        }
        return (char)pos;
    }
    
}
