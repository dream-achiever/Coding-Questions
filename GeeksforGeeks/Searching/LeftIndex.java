/*
Given a sorted array of positive integers (elements may be repeated) and a number x. The task is to find the leftmost index of x in the given array.

Input:
First line of input contains number of testcases T. For each testcase, first line contains number of elements N, and next line contains N elements. Last line contains x.

Output:
For each testcase, print the leftmost index at which x is present in the array. If the element is not present in the array, then output "-1" (without quotes).

User Task:
The task is to complete the function leftIndex() which takes the array arr[], its size N and an integer X as inputs and returns the index of leftmost occurrence of X in given input array. It returns -1 if element is not present in the array.

Expected Time Complexity: O(LogN).
Expected Auxiliary Space: O(1).

Constraints:
1 <= T <= 100
1 <= N <= 106
1 <= arr[i] <= 106
1 <= x <= 106

Example:
Input:
2
10
1 1 2 2 3 4 5 5 6 7
1
7
10 20 20 20 20 20 20
20

Output:
0
1

Explanation:
Testcase 1: 1 is present two times in the array and its leftmost index is 0.
Testcase 2: 20 is present 5 times , but its leftmost index is 1.
######################################################################################Solution######################################################################
*/
class LeftIndex{ 
    
    static int leftmostIndex(int arr[], int left, int right, int x){
        if(left>right){
            return -1;
        }
        int mid = left + (right-left)/2;
        if(arr[mid] == x &&(mid == 0 || arr[mid-1] !=x)){
            return mid;
        }
        if(arr[mid]>=x){
            return leftmostIndex(arr,left, mid-1,x);
        }
        return leftmostIndex(arr, mid+1, right,x);
    }
    
    static int leftIndex(int sizeOfArray, int arr[], int elementToSearch)
    {
       
       // Your code here
       return leftmostIndex(arr,0,sizeOfArray-1,elementToSearch);
       
    }
}
