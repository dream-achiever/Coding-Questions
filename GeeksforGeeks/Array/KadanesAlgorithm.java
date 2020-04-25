/*
Given an array arr of N integers. Find the contiguous sub-array with maximum sum.

Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. The first line of each test case contains a single integer N denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.

Output:
Print the maximum sum of the contiguous sub-array in a separate line for each test case.

User Task:
The task is to complete the function maxSubarraySum() which finds subarray with maximum sum.

Constraints:
1 ≤ T ≤ 110
1 ≤ N ≤ 106
-107 ≤ A[i] <= 107

Example:
Input:
2
5
1 2 3 -2 5
4
-1 -2 -3 -4

Output:
9
-1

Explanation:
Testcase 1: Max subarray sum is 9 of elements (1, 2, 3, -2, 5) which is a contiguous subarray.

#####################################################Solution##################################################################
*/
class Kadane{
    
    // Function to find subarray with maximum sum
    // arr: input array
    // n: size of array
    int maxSubarraySum(int arr[], int n){
        
        // Your code here
        int max_current=arr[0];
        int max_global=arr[0];
        for(int i=1;i<n;i++){
            max_current=Math.max(arr[i],max_current+arr[i]);
            if(max_current>max_global)
                max_global=max_current;
        }
        return max_global;
    }
    
}
