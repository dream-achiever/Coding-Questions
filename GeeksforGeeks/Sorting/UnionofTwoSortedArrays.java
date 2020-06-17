/*
Given two sorted arrays arr[] and brr[] of size N and M respectively. The task is to find the union of these two arrays.
Union of two arrays can be defined as the common and distinct elements in the two arrays.

Input:
The first line of input contains the number of test cases T. For each test case, the first line of input contains the number of test cases T. For each test case, the first line of input contains the size of two arrays N and M. Next two lines contains N and M elements.

Output:
For each test case, print the union (common and distinct) of two arrays in a single line. You need to print the union in sorted order.

Your Task:
This is a function problem. You only need to complete the function findUnion() that takes N and M as parameters and returns the union of two arrays. The new line is automatically appended by the driver code.

Expected Time Complexity: O(N+M).
Expected Auxiliary Space: O(N+M).

Constraints:
1 <= T <= 100
1 <= N, M <= 105
1 <= arr[i], brr[i] <= 106

Example:
Input:
3
5 3
1 2 3 4 5
1 2 3
5 5
2 2 3 4 5
1 1 2 3 4
5 5
1 1 1 1 1
2 2 2 2 2
Output:
1 2 3 4 5
1 2 3 4 5
1 2

Explanation:
Testcase 1: Distinct elements including both the arrays are: 1 2 3 4 5.
Testcase 2: Distinct elements including both the arrays are: 1 2 3 4 5.
Testcase 3: Distinct elements including both the arrays are: 1 2.

###########################################################Solution#############################################################
*/
class Union
{
    
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        // add your code here
        ArrayList<Integer> arr = new ArrayList<Integer>();
        //int [] arr = new int[n+m];
        int i=0,j=0,k=0;
        while(i<n && j<m){
            if(arr1[i]==arr2[j]){
                if(k>0&&arr1[i]!=arr.get(k-1)){
                    arr.add(arr1[i++]);
                    k++;
                    j++;
                }
                else if(k==0){
                    arr.add(arr1[i++]);
                    k++;
                    j++;
                }
                else {
                    i++;
                    j++;
                }
            }
            else if(arr1[i]>arr2[j]){
                if(k>0&&arr2[j]!=arr.get(k-1)){
                    arr.add(arr2[j++]);
                    k++;
                    //i++;
                }
                else if(k==0){
                    arr.add(arr2[j++]);
                    k++;
                }
                else {
                    //arr[k++]=arr1[i++];
                    j++;
                }
            }
            else if (arr1[i]<arr2[j]){
                if(k>0 && arr1[i]!=arr.get(k-1)){
                    arr.add(arr1[i++]);
                    k++;
                    //j++;
                }
                else if(k==0){
                    arr.add(arr1[i++]);
                    k++;
                }
                else {
                    //arr[k++]=arr2[j++];
                    i++;
                }
            }
        }
        while(k>0 && i<n){
            if(arr1[i]!=arr.get(k-1)){
                arr.add(arr1[i++]);
                k++;    
            }
            else {
               i++; 
            }
            
        }
        while(k>0 && j<m){
            if(arr2[j]!=arr.get(k-1)){
                arr.add(arr2[j++]);
                k++;   
            }
            else {
                j++;
            }
        }
        
        return arr;
    }
}
