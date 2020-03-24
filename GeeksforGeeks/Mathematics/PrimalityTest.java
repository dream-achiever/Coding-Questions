/*
For a given number N check if it is prime or not. A prime number is a number which is only divisible by 1 and itself.

Input:
First line contains an integer, the number of test cases 'T'. T testcases follow. Each test case should contain a positive integer N.

Output:
For each testcase, in a new line, print "Yes" if it is a prime number else print "No".

Your Task:
This is a function problem. You just need to complete the function isPrime that takes N as parameter and returns True if N is prime else returns false. The printing is done automatically by the driver code.

Constraints:
1 <= T <= 100
1 <= N <= 103

Example:
Input:
2
5
4
Output:
Yes
No

######################################################Solution#################################################################
*/
class Primality 
{
    
    public boolean isPrime(int N)
    {
      //Your code here
      if(N == 1){
          return false;
      }
      for (int i=2;i<=Math.sqrt(N);i++){
          if (N%i==0){
              return false;
          }
      }
      return true;
    }

}
