/*
Given an unsorted array A of size N of non-negative integers, find a continuous sub-array which adds to a given number S.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. The first line of each test case is N and S, where N is the size of array and S is the sum. The second line of each test case contains N space-separated integers denoting the array elements.

Output:
For each test case, in a new line, print the starting and ending positions(1 indexing) of first such occurring subarray from the left if sum equals to subarray, else print -1.

User Task:
The task is to complete the function subarraySum() which finds starting and ending positions(1 indexing) of first such occurring subarray from the left if sum equals to subarray, else -1 is printed. The driver code automatically appends a new line.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= T <= 100
1 <= N <= 105
1 <= Ai <= 1010

Example:
Input:
3
5 12
1 2 3 7 5
10 15
1 2 3 4 5 6 7 8 9 10
4 15
5 7 1 2
Output:
2 4
1 5
1 4

Explanation :
Testcase1: the sum of elements from 2nd position to 4th position is 12.
Testcase2: the sum of elements from 1st position to 5th position is 15.
Testcase 3: Sum of elements from 1st to 4th position is 15.
###############################################################################Solution#############################################################################
*/
class Subarray{
    
    // Function to find subarray with given sum
    static void subarraySum(int n, int s, int[] m) {
        
        // Your code here
        int current_sum = m[0],start = 0,i;
        for(i=1;i<=n;i++){
            while(current_sum>s && start<i-1){
                current_sum-=m[start];
                start++;
            }
            
            if(current_sum == s){
                System.out.print(start+1+" "+(i));
                return;
            }
            if(i<n){
                current_sum+=m[i];
            }
        }
        System.out.print("-1");
        return;
    }
}
