/*
Given an unsorted array arr of positive integers. Find the number of triangles that can be formed with three different array elements as lengths of three sides of triangles. 

Input: 
The first line of the input contains T denoting the number of test cases. The first line of the test case is the length of array N and the second line of the test case are its elements.

Output:
The number of possible triangles is displayed to the user.

Your Task:
This is a function problem. You only need to complete the function findNumberOfTriangles() that takes N as a parameter and returns the count of total possible triangles.

Expected Time Complexity: O(N2).
Expected Space Complexity: O(1).

Constraints:
1 <= T <= 10
3 <= N <= 103
1 <= arr[i] <= 103

Example:
Input:
2
3
3 5 4
5
6 4 9 7 8
Output:
1
10

Explanation:
Testcase 1: A triangle is possible with all the elements 5, 3 and 4.
Testcase 2: There are 10 triangles possible with the given elements like (6,4,9), (6,7,8),...
###############################################################Solution########################################################
*/
class Count_possible_triangle
{
    // Function to find number of triangles that can be formed
    // arr[]: input array
    // n: size of array
    public static void quicksort(int arr[], int start, int end){
        if(start<end){
            int pIndex = partition(arr,start,end);
            quicksort(arr,start,pIndex-1);
            quicksort(arr,pIndex+1,end);
            
        }
    }
    public static int partition(int arr[],int start, int end){
        int pivot = arr[end];
        int pIndex = start;
        int temp=0;
        for(int i=start;i<end;i++){
            if(arr[i]<=pivot){
                temp=arr[i];
                arr[i]=arr[pIndex];
                arr[pIndex]=temp;
                pIndex++;
            }
        }
        temp = arr[end];
        arr[end]=arr[pIndex];
        arr[pIndex]=temp;
        return pIndex;
    }
    
    static long findNumberOfTriangles(int arr[], int n)
    {
        // add your code here
        quicksort(arr,0,n-1);
        long count=0;
        for(int i=n-1;i>=1;i--){
            int start=0,end=i-1;
            while(start<end){
                if(arr[start]+arr[end]>arr[i]){
                    count+=(long)end-(long)start;
                    end--;
                }
                else {
                    start++;
                }
            }
        }
        return count;
    }
}
