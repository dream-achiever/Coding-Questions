/*
Given a sorted array and an integer element. The task is to check if the element is present in the array or not.

Input:
First line of input contains number of testcases T. For each testcase, first line of input contains number of elements in the array and the number K seperated by space. Next line contains N elements.

Output:
For each testcase, if the element is present in the array print "1" (without quotes), else print "-1" (without quotes).

User Task:
The task is to complete the function searchInSorted() which takes the sorted array arr[], its size N and the element K as inputs and returns 1 if the element is present in the array, else it returns -1. 

Expected Time Complexity: O(LogN).
Expected Auxiliary Space: O(1).

Constraints:
1 <= T <= 100
1 <= N <= 106
1 <= K <= 106
1 <= arr[i] <= 106

Example:
Input:
2
5 6
1 2 3 4 6
5 2
1 3 4 5 6

Output:
1
-1

Explanation:
Testcase 1: Since, 6 is present in the array at index 4 (0-based indexing), so output is 1.
Testcase 2: Since, 2 is not present in the array, so output is -1.

########################################################Solution###############################################################
*/
class SearchElement{
    static int binarySearch (int arr[],int low, int high, int x){
        
        if(low>high){
            return -1;
        }
        int mid = low + (high-low)/2;
        
        if(arr[mid] == x){
            return 1;
        }
        if(arr[mid]>x){
            return binarySearch(arr,low,mid-1,x);
        }
        return binarySearch(arr,mid+1,high,x);
    }
        
    static int searchInSorted(int arr[], int n, int x)
    {
        
        // Your code here
        return binarySearch(arr,0,n-1,x);
        
    }
}
