/*
Given an array of 0s, 1s and 2s. Arrange the array elements such that all 0s come first, followed by all the 1s and then, all the 2s.

Note: Do not use inbuilt sort function.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. The first line of each test case is N, size of the array. The second line of each test case contains N space separated values of the array arr[].

Output: 
For each test case, print the sorted array in a new line.

Your Task:
You don't need to read input or print anything. Your task is to complete the function segragate012() which takes the array arr[] and the size of the array as inputs and updates the array arr[] such that all the 0s come before the 1s and all the 1s come before the 2s.

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(1).

Constraints:
1 <= T <= 500
1 <= N <= 106
0 <= Ai <= 2

Example:
Input :
2
5
0 2 1 2 0
3
0 1 0
Output:
0 0 1 2 2
0 0 1

Explanation:
Testcase 1: After segragating the 0s, 1s and 2s, we have 0 0 1 2 2.
Testcase 2: After segragating the 0s, 1s and 2s, we have 0 0 1.
#################################################################Solution######################################################
*/
class Sort012
{
    // The function should do the stated modifications in the given array arr[]
    // Do not return anything.
    
    // arr[]: Input Array
    // N: Size of the Array arr[]

    public static void segragate012(int arr[], int N){
        // Your Code Here
        int start = 0;
        int end = N-1;
        int index=0;
        
        while(index<=end && start<end){
            if(arr[index]==0){
                arr[index]=arr[start];
                arr[start]=0;
                start++;
                index++;
            }
            else if(arr[index]==2){
                arr[index]=arr[end];
                arr[end]=2;
                end--;
            }
            else {
                index++;
            }
        }
    }
}
