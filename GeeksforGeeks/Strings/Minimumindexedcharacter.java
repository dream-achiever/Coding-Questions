/*
Given a string str and another string patt. Find the character in patt that is present at the minimum index in str. If no character of patt is present in str then print ‘No character present’.

Input:
The first line of input contains an integer T denoting the number of test cases. Then the description of T test cases follow. Each test case contains two strings str and patt respectively.

Output:
Print the character in patt that is present at the minimum index in str. Print "No character present" (without quotes) if no character of patt is present in str.

Your Task:
This is a function problem. You only need to complete the function minIndexChar() that returns the index of answer in str or returns -1 in case no character of patt is present in str. The newline is automatically appended by the driver code.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Number of distinct characters).

Constraints:
1 <= T <= 105
1 <= |str|,|patt| <= 105

Example:
Input:
2
geeksforgeeks
set
adcffaet
onkl
Output:
e
No character present

Explanation:
Testcase 1: e is the character which is present in given patt "geeksforgeeks" and is first found in str "set".
Testcase 2: There are none of the characters which is common in patt and str.
##################################################################Solution##########################################################################################
*/
class solve{

    public static int minIndexChar(String str, String pat){
        // Your code here
        int count[] = new int[26];
        Arrays.fill(count,-1);
        int min = Integer.MAX_VALUE;
        for(int i=0;i<str.length();i++){
            if(count[str.charAt(i)-'a']==-1){
                count[str.charAt(i)-'a']=i;
            }
            else {
                count[str.charAt(i)-'a']=Math.min(count[str.charAt(i)-'a'],i);
            }
        }
        int min2 = Integer.MAX_VALUE;
        for(int i=0;i<pat.length();i++){
            if(count[pat.charAt(i)-'a']!=-1){
                min2 = Math.min(min2,count[pat.charAt(i)-'a']);
            }
            //System.out.println(count[pat.charAt(i)-'a']);
        }
        return (min2==Integer.MAX_VALUE)?-1:min2;
    }
}
