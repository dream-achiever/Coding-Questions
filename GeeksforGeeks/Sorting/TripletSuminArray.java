/*
Given an array and an integer. Find if there's a triplet in the array which sums up to the given integer. 

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. The first line of each test case constains two integers N, size of the array and X, the required sum. The second line of each test case contains N space separated values of the array arr[].

Output:
Print "1" (without quotes) if there exist three elements in arr[] whose sum is exactly X, else "0" (without quotes).

Your Task:
You don't need to read input or print anything. Your task is to complete the function find3Numbers() which takes the array arr[], the size of the array (N) and the sum (X) as inputs and returns True if there exists a triplet in the array arr[] which sums up to X and False otherwise.

Expected Auxiliary Space: O(1)
Expected Time Complexity: O(n2)

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 103
1 ≤ A[i] ≤ 105

Example:
Input:
2
6 13
1 4 45 6 10 8
5 10
1 2 4 3 6
Output:
1
1

Explanation:
Testcase 1: The triplet {1, 4, 8} in the array sums up to 13.
Testcase 2: The triplet {1, 3, 6} in the array sums up to 10.
#########################################################Solution##############################################################
*/
class TripletSum
{
    // arr[] : The input Array
    // N : Size of the Array
    // X : Sum which you need to search for
    
    public static void quicksort(int arr[], int start, int end){
        if( start<end){
            int pIndex = partition(arr,start,end);
            quicksort(arr,start, pIndex-1);
            quicksort(arr,pIndex+1,end);
        }
    }
    
    public static int partition(int arr[],int start,int end){
        int pivot = arr[end];
        int pIndex = start;
        
        for(int i=start;i<end;i++){
            if(arr[i]<=pivot){
                swap(arr,i,pIndex);
                pIndex++;
            }
        }
        swap(arr,end,pIndex);
        return pIndex;
    }
    
    public static void swap(int arr[],int start,int end){
        int temp=arr[start];
        arr[start]=arr[end];
        arr[end]=temp;
    }
    
    public static boolean isPair(int arr[],int start,int end, int target){
        
        while(start<end){
            if(arr[start]+arr[end]==target){
                return true;
            }
            else if(arr[start]+arr[end]>target){
                end--;
            }
            else {
                start++;
            }
        }
        return false;
    }
    
    public static int find3Numbers(int arr[], int N, int X) { 
    
       // Your code Here
       quicksort(arr,0,N-1);
       for(int i=0;i<N-2;i++){
            if(isPair(arr,i+1,N-1,X-arr[i])){
                return 1;
            }
        }
        return 0;
    }
}
