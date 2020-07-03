/*
Given an array of positive and negative numbers. Find if there is a subarray (of size at-least one) with 0 sum.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains an integer n denoting the size of the array. The next line contains N space separated integers forming the array.

Output:
Print "Yes" (without quotes) if there exist a subarray of size at least one with sum equal to 0 or else print "No" ( without quotes).

Your Task:
This is a function problem. You only need to complete the function subArrayExists() that takes array and n as parameters and returns true or false depending upon whether there is a subarray present with 0-sum or not.

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(n).

Constraints:
1 <= T <= 100
1 <= N <= 104
-105 <= a[i] <= 105

Example:
Input:
2
5
4 2 -3 1 6
5
4 2 0 1 6
Output:
Yes
Yes

Explanation:
Testcase 1: 2, -3, 1 is the subarray with sum 0.
Testcase 2: 0 is one of the element in the array so there exist a subarray with sum 0.
##############################################################################Solution##############################################################################
*/
static boolean findsum(int arr[],int n)
{
    //Your code here
    HashSet<Integer> hs = new HashSet<>();
    hs.add(0);
    int prefix=0;
    for(int i=0;i<n;i++){
        prefix +=arr[i];
        if(hs.contains(prefix)){
            return true;
        }
        hs.add(prefix);
    }
    return false;
}
