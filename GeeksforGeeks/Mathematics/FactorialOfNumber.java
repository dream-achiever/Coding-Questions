/*
Given a positive integer N. The task is to find factorial of N.

Input:
The first line contains an integer 'T' denoting the total number of test cases. T testcases follow. In each test cases, it contains an integer 'N'.

Output:
For each testcase, in a new line, print the factorial of N.

Your Task:
This is a function problem. You just need to complete the function factorial() that takes N as parameter and returns factorial of N.

Constraints:
1 <= T <= 100
0 <= N <= 18

Example:
Input:
3
1
4
13

Output:
1
24
6227020800

#########################################################Solution############################################################
*/
class Factorial
{
    
    public long factorial (int N)
    {
        //Your code here
        if (N <= 1 ){
            return 1;
        }
        else {
            return N*factorial(N-1);
        }
    }

}
