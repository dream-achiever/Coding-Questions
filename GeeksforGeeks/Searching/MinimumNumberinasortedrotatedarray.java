/*
Given an array of distinct elements which was initially sorted. This array is rotated at some unknown point. The task is to find the minimum element in the given sorted and rotated array. 

Input:
The first line of input contains an integer T denoting the number of test cases. Each test case contains the number of elements in the array arr[] as N and next line contains space separated n elements in the array arr[].

Output:
Print an integer which denotes the minimum element in the array.

User Task:
The task is to complete the function minNumber() which takes the array arr[] and its starting and ending indices (low and high) as inputs and returns the minimum element in the given sorted and rotated array.

Expected Time Complexity: O(LogN).
Expected Auxiliary Space: O(LogN).

Constraints:
1 <= T <= 100
1 <= N <= 107
1 <= arr[i] <= 107

Example:
Input:
3
10
2 3 4 5 6 7 8 9 10 1
5
3 4 5 1 2
8
10 20 30 45 50 60 4 6
Output:
1
1
4

Explanation:
Testcase 1: The array is rotated once anti-clockwise. So minium element is at last index (n-1) which is 1.
Testcase 2: The array is rotated and the minimum element present is at index (n-2) which is 1.
Testcase 3: The array is rotated and the minimum element present is 4.
####################################################################################Solution#######################################################################
*/
class MinimumNumber{
    
    static long minNumber(int arr[], long low, long high)
    {
        
        // Your code here
        low=0;
        high = arr.length-1;
        while(low<high){
            int mid = (int)low+(int)(high-low)/2;
            
            if(arr[mid]>arr[(int)high]){
                low = mid+1;
            }
            else{
                high = mid;
            }
        }
        return arr[(int)low];
    }
    
}
