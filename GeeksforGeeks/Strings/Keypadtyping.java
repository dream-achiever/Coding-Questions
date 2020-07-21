/*
You are given a string S of alphabet characters and the task is to find its matching decimal representation as on the shown keypad. Output the decimal representation corresponding to the string. For ex: if you are given “amazon” then its corresponding decimal representation will be 262966.



Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of a single line containing a string.

Output:
For each testcase, in a new line, print the decimal sequence.

Your Task:
Complete printNumber() function that takes string s and its length as parameters and returns the corresponding decimal representation of the given string as a string type. The printing is done by the driver code.

Constraints:
1 ≤ T ≤ 100
1 ≤ length of String ≤ 100

Expected Time Complexity : O(n)
Expected Auxilliary Space : O(n)

Example:
Input:
2
geeksforgeeks
geeksquiz

Output:
4335736743357
433577849

Explanation:
Testcase1: geeksforgeeks is 4335736743357 in decimal when we type it using the given keypad.
Testcase2: geeksquiz is 433577849 in decimal when we type it using the given keypad.
###########################################################################Solution#################################################################################
*/
public static String printNumber(String s, int n) 
{
    //Your code here
    int count[] = {2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9};
    int [] character= new int[n];
    for(int i=0;i<n;i++){
        character[i]=count[s.charAt(i)-'a'];
    }
    return Arrays.toString(character).replace("[","").replace("]","").replace(",","").replace(" ","");
}
