/*
Given an array arr[] of N integers which is closer sorted (defined below) and an element x. The task is to find index of the element x if it is present. If not present, then print -1.
Closer Sorted: First array is sorted, but after sorting some elements are moved to either of the adjacent positions, i.e, may be to the arr[i+1] or arr[i-1].

Input:
First line of input contains number of testcases T. For each testcase, first line of input contains number of elements in the array. Next line contains the array elements. Last line contains the element to be searched.

Output:
Output the index at which the element is present (0-based), if present, else print "-1".

Your Task:
This is a function problem. You only need to complete the function closer() that arr, N, and x as parameters and returns the index. If element is not present, return -1.

Expected Time Complexity: O(Log(N)).
Expected Auxiliary Space: O(1).

Constraints:
1 <= T <= 100
1 <= N <= 106
1 <= arr[i],x <= 106

Example:
Input:
2
5
3 2 10 4 40
2
4
2 1 4 3
5
Output:
1
-1

Explanation:
Testcase 1: 2 is present at index 1 (0-based indexing) in the given array.
Testcase 2: 5 is not in the array so the output will be -1.

###############################################################################################Solution#############################################################
*/
class Closer_to_sort
{
    // Function to find the element x in input array arr[]
    // n: size of array
    // x: element to find
    
    static int binarySearch(int arr[], int start, int end, int target ){
        if(start>end){
            return -1;
        }
            int mid = start+(end-start)/2;
            
            if(arr[mid] == target && (mid==0 || arr[mid-1]!=target)){
                return mid;
            }
            if(arr[mid] == target){
                return mid;
            }
            if(arr[mid]>=target && arr[mid]>arr[start]){
                return binarySearch(arr,start,mid-1,target);
            }
            // else if(arr[mid]<arr[start] && arr[mid]<target){
            //     return binarySearch(arr,mid+1,end,target);
            // }
            return binarySearch(arr,mid+1,end,target);
    }
    
    static long closer(int arr[], int n, long x)
    {
        // add your code here
        int index = binarySearch(arr,0,n-1,(int)x); 
        return (long) index;
    }
}
