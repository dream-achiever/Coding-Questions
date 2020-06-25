/*
Given three sorted arrays A, B and C of size N, M and P respectively. The task is to merge them into a single array which must be sorted in increasing order.

Input:
First line of input contains number of testcases T. For each testcase, first line of input contains size of three arrays N, M and P. Next three lines contains N, M and P elements for arrays.

Output:
Output the merged sorted array.

Your Task:
This is a function problem. You only need to complete the function mergeThree() that takes A,B,C as parameters. The function returns an array or vector.

Expected Time Complexity: O(N + M + P).
Expected Auxiliary Space: O(1).

Constraints:
1 <= T <= 100
1 <= N, M, P <= 106
1 <= A[i], B[i], C[i] <= 106

Example:
Input:
2
4 5 6
1 2 3 4
1 2 3 4 5
1 2 3 4 5 6
2 3 4
1 2
2 3 4
4 5 6 7
Output:
1 1 1 2 2 2 3 3 3 4 4 4 5 5 6
1 2 2 3 4 4 5 6 7

Explanation:
Testcase 1: Merging these three sorted arrays, we have elements as 1 1 1 2 2 2 3 3 3 4 4 4 5 5 6.
Testcase 2: Merging three sorted arrays , we have elements as 1 2 2 3 4 4 5 6 7.
###########################################################################################Solution#################################################################
*/
class MergeThree
{
    // Function to merge three sorted arrays
    // A[], B[], C[]: input arrays
    static ArrayList<Integer> merge3sorted(int A[], int B[], int C[])
    {
        // add ypur code here
        ArrayList<Integer> arr = new ArrayList<>();
        int i=0,j=0,k=0,l=0;
        while(i<A.length && j<B.length && k<C.length){
            if(A[i]==B[j]){
                if(A[i]==C[k]){
                    arr.add(l,A[i]);
                    l++;
                    i++;
                    arr.add(l,B[j]);
                    l++;
                    j++;
                    arr.add(l,C[k]);
                    l++;
                    k++;    
                }
                else if(A[i]>C[k]){
                    arr.add(l,C[k]);
                    l++;
                    k++;
                }
                else {
                    arr.add(l,A[i]);
                    l++;
                    i++;
                    arr.add(l,B[j]);
                    l++;
                    j++;
                }
            }
            else if(A[i]<B[j]){
                if(A[i]==C[k]){
                    arr.add(l,A[i]);
                    l++;
                    i++;
                    arr.add(l,C[k]);
                    l++;
                    k++;
                }
                else if(A[i]>C[k]){
                    arr.add(l,C[k]);
                    l++;
                    k++;
                }
                else {
                    arr.add(l,A[i]);
                    l++;
                    i++;
                }
            }
            else
            {
                if(B[j]==C[k]){
                    arr.add(l,B[j]);
                    l++;
                    j++;
                    arr.add(l,C[k]);
                    l++;
                    k++;
                }
                else if(B[j]>C[k]){
                    arr.add(l,C[k]);
                    l++;
                    k++;
                }
                else {
                    arr.add(l,B[j]);
                    l++;
                    j++;
                }
            }
        }
        while(i<A.length && j<B.length){
            if(A[i]==B[j]){
                arr.add(l,A[i]);
                l++;
                i++;
                arr.add(l,B[j]);
                l++;
                j++;
            }
            else if(A[i]>B[j]){
                arr.add(l,B[j]);
                l++;
                j++;
            }
            else {
                arr.add(l,A[i]);
                l++;
                i++;
            }
        }
        while(j<B.length && k<C.length){
            if(B[j]==C[k]){
                arr.add(l,B[j]);
                l++;
                j++;
                arr.add(l,C[k]);
                l++;
                k++;
            }
            else if(B[j]>C[k]){
                arr.add(l,C[k]);
                l++;
                k++;
            }
            else {
                arr.add(l,B[j]);
                l++;
                j++;
            }
        }
        while(i<A.length && k<C.length){
            if(A[i]==C[k]){
                arr.add(l,A[i]);
                l++;
                i++;
                arr.add(l,C[k]);
                l++;
                k++;
            }
            else if(A[i]>C[k]){
                arr.add(l,C[k]);
                l++;
                k++;
            }
            else {
                arr.add(l,A[i]);
                l++;
                i++;
            }
        }
        
        while(i<A.length){
            arr.add(l,A[i]);
            l++;
            i++;
        }
        
        while(j<B.length){
            arr.add(l,B[j]);
            l++;
            j++;
        }
        
        while(k<C.length){
            arr.add(l,C[k]);
            l++;
            k++;
        }
        
        return arr;
    }
}
