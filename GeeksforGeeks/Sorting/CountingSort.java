/*
Given a string S consisting of lowercase latin letters, arrange all its letters in lexographical order using Counting Sort.

Input:
The first line of the input contains T denoting number of testcases.Then T test cases follow. Each testcase contains positive integer N denoting the length of string.The last line of input contains the string S.

Output:
For each testcase, in a new line, output the sorted string.

Your Task:
This is a function problem. You only need to complete the function countSort() that takes char array as parameter and return the sorted char array. The printing is done by driver code.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= T <= 105
1 <= N <= 105

Example:
Input:
2
5
edsab
13
geeksforgeeks
Output:
abdes
eeeefggkkorss

Explanation:
Testcase 1: In lexicographical order , string will be abdes.
Testcase 2: In lexicographical order , string will be eeeefggkkorss.
#####################################################Solution##################################################################
*/
class GfG
{
    
    // Function to do count sort
    // seq[]: input array
    // return the sorted input array of character
    public static char[] countSort(char seq[])
    {
        // add your code here  
        int size = seq.length;
        char output[] = new char[size];
        int max = seq[0];
        for(int i=1;i<size;i++){
            if(seq[i]>max){
                max=seq[i];
            }
        }
        int count[] = new int[max+1];
        
        for(int i=0;i<size;i++){
            count[seq[i]]++;
        }
        
        for(int i=1;i<=max;i++){
            count[i]+=count[i-1];
        }
        for(int i=size-1;i>=0;i--){
            output[count[seq[i]]-1]=seq[i];
            count[seq[i]]--;
        }
        return output;
    }
}
