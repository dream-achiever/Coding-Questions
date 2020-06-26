/*
Given a sorted array arr[] of size N without duplicates, and given a value x. Find the floor of x in given array. Floor of x is defined as the largest element K in arr[] such that K is smaller than or equal to x.

Input:
First line of input contains number of testcases T. For each testcase, first line of input contains number of elements in the array and element whose floor is to be searched. Last line of input contains array elements.

Output:
Output the index of floor of x if exists, else print -1 (0 based Indexing).

User Task:
The task is to complete the function findFloor() which finds the floor of x.

Expected Time Complexity: O(log N).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 107
1 ≤ arr[i] ≤ 1018
0 ≤ X ≤ arr[n-1]

Example:
Input:
3
7 0
1 2 8 10 11 12 19
7 5
1 2 8 10 11 12 19
7 10
1 2 8 10 11 12 19

Output:
-1
1
3

Explanation:
Testcase 1: No element less than 0 is found. So output is "-1".
Testcase 2: Number less than 5 is 2, whose index is 1(0-based indexing).
Testcase 3: Number less than or equal to 10 is 10 and its index is 3.
###########################################################################Solution#################################################################################
*/
class FloorSearch{
    
    // Function to find floor of x
    // arr: input array
    // left and right as 0 and n-1, where n is the size of array
    static int findFloor(long arr[], int left, int right, long x)
    {
        left = 0;right=arr.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
        
            if(arr[mid] > x &&(mid==0 || arr[mid-1]<=x)){
                return (int)mid-1;
            }else if(mid==arr.length-1 &&(mid==0 || arr[mid-1]<=x)){
                return (int)mid;
            }
            
            if(arr[mid]>x){
                right = mid-1;
            }
            else {
                left = mid+1;
            }
        }
        
        return -1;
    }
    
}
