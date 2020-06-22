/*
Given an array of N elements and a number K. The task is to arrange array elements according to the absolute difference with K, i. e., element having minimum difference comes first and so on.
Note : If two or more elements are at equal distance arrange them in same sequence as in the given array.

Input:
First line of input contains a single integer T which denotes the number of test cases. Then T test cases follows. First line of test case contains two space separated integers N and K. Second line of each test case contains N space separated integers.

Output:
For each test case print the given array in the order as described above.

Your Task:
This is a functional problem. You only need to complete the function sortABS(). The printing is done automatically by the driver code.

Expected Time Complexity: O(N log(N) ).
Expected Auxiliary Space: O(N).

Constraints:
1 <= T <= 100
1 <= N <= 105
1 <= K <= 105

Example:
Input:
3
5 7
10 5 3 9 2
5 6
1 2 3 4 5
4 5
2 6 8 3
Output:
5 9 10 3 2
5 4 3 2 1
6 3 2 8

Explanation:
Testcase 1: Sorting the numbers accoding to the absolute difference with 7, we have array elements as 5, 9, 10, 3, 2.
Testcase 2: Sorting the numbers according to the absolute difference with 6, we have array elements as 5 4 3 2 1.
Testcase 3: Sorting the numbers according to the absolute difference with 5, we have array elements as 6 3 2 8.

##############################################################Solution#########################################################
*/
class SortABS
{
    // here k is the value with which we have to 
    // compute absolute difference
    // length of array can be computed as arr.length
    
    public static void mergesort(int arr[], int start, int end,int target){
        if(start<end){
            int mid=start+(end-start)/2;
            mergesort(arr,start, mid,target);
            mergesort(arr,mid+1,end,target);
            merge(arr,start,end,mid,target);
        }
    }
    
    public static void merge(int arr[],int start, int end,int mid, int target){
        int lsize = mid-start+1;
        int rsize = end-mid;
        
        int larr[] = new int[lsize];
        int rarr[] = new int[rsize];
        
        int i=0,j=0,k=0;
        for( i=0;i<lsize;i++){
            larr[i]=arr[start+i];
        }
        
        for( j=0;j<rsize;j++){
            rarr[j]=arr[mid+j+1];
        }
        i=0;
        j=0;
        k=start;
        
        while(i<lsize && j<rsize){
            if(Math.abs(larr[i]-target)<=Math.abs(rarr[j]-target)){
                arr[k++]=larr[i++];
            }
            else {
                arr[k++]=rarr[j++];
            }
        }
        while(i<lsize){
            arr[k++]=larr[i++];
        }
        while(j<rsize){
            arr[k++]=rarr[j++];
        }
    } 
    
    static void sortABS(int arr[], int n,int k)
    {
        // add your code here
        
        mergesort(arr,0,n-1,k);
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
