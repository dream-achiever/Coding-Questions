/*
You are given a number n. You need to find the sum of digits of n.

Input:
The first line of input contains T denoting the number of testcases. T testcases follow. Each testcase contains one line of input containing n.

Output:
For each testcase, in a newline, print the sum of digits of n.

Your Task:
This is a function problem. You only need to complete the function sumOfDigits that takes n as parameter and returns the sum of digits of n.

Constraints:
1 <= T <= 100
1 <= n <= 107

Examples:
Input:
2
1
99999
Output:
1
45

Explanation:
Testcase 1: Sum of digits for 1 is 1.
Testcase 2: Sum of digits for 99999 is 9 + 9 + 9 + 9 + 9 = 45
#####################################################Solution##################################################################
*/
class Digitsum
{
    // complete the function
    public static int sumOfDigits(int n)
    {
        // add your code here
        if(n==0)
            return 0;
        else
            return (n%10 + sumOfDigits(n/10));
    }
}
