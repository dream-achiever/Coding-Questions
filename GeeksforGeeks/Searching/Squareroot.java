/*
Given an integer x. The task is to find the square root of x. If x is not a perfect square, then return floor(√x).

Input:
First line of input contains number of testcases T. For each testcase, the only line contains the number x.

Output:
For each testcase, print square root of given integer.

Your Task:
The task is to complete the function floorSqrt() which should return the square root of given number x.
Expected Time Complexity: O(log N).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ T ≤ 10000
1 ≤ x ≤ 107

Example:
Input:
2
5
4
Output:
2
2

Explanation:
Testcase 1: Since, 5 is not perfect square, so floor of square_root of 5 is 2.
Testcase 2: Since, 4 is a perfect square, so its square root is 2.
#######################################################################################Solution#####################################################################
*/
class SquareRoot
{
     long floorSqrt(long x)
	 {
		// Your code here
		long low = 1, high = x;
		long ans=0;
		if(x == 0 || x==1){
		    return x;
		}
		while(low<=high){
		    long mid = low+(high-low)/2;
		    if((mid*mid) == x){
		        return mid;
		    }
		    else if(mid*mid<x){
		        low=mid+1;
		        ans = mid;
		    }
		    else {
		        high = mid-1;
		    }
		}
		return (long)Math.floor(ans);
	 }
}
