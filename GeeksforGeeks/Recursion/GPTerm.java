/*
Given the first 2 terms A and B of a Geometric Series. The task is to find the Nth term of the series.

Input:
First line contains an integer, the number of test cases 'T'. T testcases follow. Each test case in its first line contains two positive integer A and B (First 2 terms of GP). In the second line of every test case it contains of an integer N.

Output:
In each seperate line print the Nth term of the Geometric Progression. Print the floor ( floor(2.3)=2 ) of the answer.

Your Task:
This is a function problem. You need to complete the function termOfGP() that takes A and B as parameter and returns Nth term of GP. The return value should be double that would be automatically converted to floor by the driver code.

Constraints:
1 <= T <= 100
-100 <= A <= 100
-100 <= B <= 100
1 <= N <= 5

Example:
Input:
2
2 3
1
1 2
2
Output:
2
2

##############################################################Solution#######################################################
*/
class GP 
{
    
    public double termOfGP(int A,int B,int N)
    {
        //Your code here
        double N_term =0.0;
        double r =0.0;
        r = ((double)B/(double)A);
        N_term = A*(Math.pow(r,N-1));
        return N_term;
    }

}
