/*
You are given a number N. Find the total count of set bits for all numbers from 1 to N(both inclusive).

Input:
The first line of input contains an integer T denoting the number of test cases. T testcases follow. The first line of each test case is N.

Output:
For each testcase, in a new line, print the total count of all bits.

User Task:
The task is to complete the function countSetBits() that takes n as parameter and returns the count of all bits.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 103

Example:
Input:
2
4
17
Output:
5
35

Explanation:
Testcase1:
An easy way to look at it is to consider the number, n = 4:
0 0 0 = 0 set bits
0 0 1 = 1 set bits
0 1 0 = 1 set bits
0 1 1 = 2 set bits
1 0 0 = 1 set bits
Therefore, the total number of set bits is 5.
Testcase 2: From numbers 1 to 17(both inclusive), the total number of set bits is 35.

#########################################################Solution##############################################################
*/
class CountBits{
    
    // Function to count number of set bits
    public static int countSetBits(int n){
    
        // Your code here
        int count=0;
        for(int i=0;i<=n;i++){
            for(int j=0;j<32;j++){
                if((1&(i>>j))==1){
                    //System.out.print(i);
                    count++;
                }
            }
            //System.out.println();
        }
        return count;
    }
}
