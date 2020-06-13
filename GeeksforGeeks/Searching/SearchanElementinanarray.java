/*
Given an integer array and another integer element. The task is to find if the given element is present in array or not.

Input:
First line contains an integer, the number of test cases 'T'. For each test case, first line contains an integer 'N', size of array. The second line contains the elements of the array separated by spaces. Third line contains element to be find in the array.

Output:
For each testcase, output a single line containing first index of element to be found in array. If element is not in the array, then print "-1" (without quotes).

User Task:
The task is to complete the function search() which takes the array arr[], its size N and the element X as inputs and returns the index of first occurrence of X in the given array. If the element X does not exist in the array, the function should return -1.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1). 

Constraints:
1 <= T <= 100
1 <= N <= 100
1 <= Arr[i] <= 100
1 <= X <= 100

Example:
Input:
2
4
1 2 3 4
3
5
1 2 3 4 5
5
Output:
2
4

Explanation:
Testcase 1: There is one test case with array as {1, 2, 3 4} and element to be searched as 3.  Since 3 is present at index 2, output is 2.
Testcase 2: For array elements {1,2,3,4,5} element to be searched is 5 and it is at index 4. So, the output is 4.

########################################################Solution#############################################################
*/
class Searching{
        
    static int search(int arr[], int n, int x)
    {
        
        // Your code here
        for(int i=0;i<n;i++){
            if(arr[i] == x){
                return i;
            }
        }
        return -1;
    }
    
}
