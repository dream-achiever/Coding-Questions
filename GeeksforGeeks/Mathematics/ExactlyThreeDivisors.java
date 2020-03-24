/*
Given a positive integer value N. The task is to find how many numbers less than or equal to N have numbers of divisors exactly equal to 3.

Input:
The first line contains integer T, denoting number of test cases. Then T test cases follow. The only line of each test case contains an integer N.

Output:
For each testcase, in a new line, print the answer of each test case.

Your Task:
This is a function problem. You only need to complete the function exactly3Divisors() that takes N as parameter and returns count of numbers less than or equal to N with exactly 3 divisors.

Constraints :
1 <= T <= 105
1 <= N <= 109

Example:
Input :
3
6
10
30
Output :
1
2
3

Explanation:
Testcase 1: There is only one number 4 which has exactly three divisors 1, 2 and 4.
Testcase 2: 4 and 9 are the only two numbers less than or equal to 10 that have exactly three divisors.
Testcase 3: 4, 9, 25 are the only numbers less than or equal to 30 that have exactly three divisors.

############################################################Solution#########################################################
*/
class Divisors
{
    
    public int exactly3Divisors(int N)
    {
        int count=0;
        boolean isPrime[] = new boolean[N+1];
		for(int i=0; i<=N;++i) {
			isPrime[i] = true;
		}
		isPrime[0] = false;
		isPrime[1] = false;
		for(int i=2; i*i<=N;i++) {
			if(isPrime[i]) {
				//Mark all the multiples of i as Composite Numbers
				for(int j=i*i;j<=N;j+=i) {
					isPrime[j]=false;
				}
			}
		}
		for (int i=0;i*i<=N;i++){
		    if(isPrime[i] ==true){
		        count++;
		    }
		}
		return count;
    }
}
