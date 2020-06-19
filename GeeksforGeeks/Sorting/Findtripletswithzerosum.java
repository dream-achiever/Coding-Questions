/*
Given an array of integers. Check whether it contains a triplet that sums up to zero. 

Input:
The first line of input contains an integer T, denoting the number of test cases. Then T test cases follow. The first line of each test case contains an integer N, denoting the number of elements in array. The second line of each test case contains N space separated values of the array.

Output:
For each test case, output will be 1 if triplet exists else 0.

Your Task:
You don't need to read input or print anything. Your task is to complete the boolean function findTriplets() which takes the array arr[] and the size of the array (n) as inputs and returns True if the given array has a triplet with zero sum and False otherwise. 

Expected Auxiliary Space: O(1)
Expected Time Complexity: O(n2)

Constrains:
1 <= T <= 100
1 <= N <= 104
-106 <= Ai <= 106

Example:
Input:
2
5
0 -1 2 -3 1
3
1 2 3
Output:
1
0

Explanation:
Testcase 1: 0, -1 and 1 forms a triplet with sum equal to 0.
Testcase 2: No triplet exists which sum to 0.

################################################################Solution#######################################################
*/
class Triplet
{
    // Function to check if triplet is present 
    // arr[]: input array
    // n: size of the array
    
    public static void quicksort(int arr[], int start, int end){
        if(start<end){
            int partitionIndex = partition(arr,start,end);
            quicksort(arr,start,partitionIndex-1);
            quicksort(arr,partitionIndex+1,end);
        }
    }
    public static int partition(int arr[], int start, int end){
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
        temp=arr[pIndex];
        arr[pIndex]=arr[end];
        arr[end]=temp;
        return pIndex;
    }
    
    public static boolean pairsum(int arr[],int start, int end,int target){
        while(start<end){
            if(arr[start]+arr[end] == target){
                return true;
            }
            else if(arr[start]+arr[end] > target){
                end--;
            }
            else {
                start++;
            }
        }
        return false;
    }
    
	public boolean findTriplets(int arr[] , int n)
    {
        //add code here.
        quicksort(arr,0,n-1);
        for(int i=0;i<n-2;i++){
            if(pairsum(arr,i+1,n-1,0-arr[i])){
             return true;   
            }
        }
        return false;
    }
}
