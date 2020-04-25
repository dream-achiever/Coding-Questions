/*
Given an array A[] of N positive integers. The task is to find the maximum of j - i subjected to the constraint of A[i] <= A[j].

Input:
The first line contains an integer T, depicting total number of test cases.  Then T test case follows. First line of each test case contains an integer N denoting the size of the array. Next line contains N space separated integeres denoting the elements of the array.

Output:
For each test case, print the maximum difference of the indexes i and j in a separtate line.

User Task:
The task is to complete the function maxIndexDiff() which finds and returns maximum index difference. Printing the output will be handled by driver code.

Constraints:
1 ≤ T ≤ 1000
1 ≤ N ≤ 107
0 ≤ A[i] ≤ 1018

Example:
Input:
2
2
1 10
9
34 8 10 3 2 80 30 33 1

Output:
1
6

Explanation:
Testcase 1: A[0]<=A[1] so (j-i) is 1-0 = 1.
Testcase 2:  In the given array A[1] < A[7] satisfying the required condition(A[i] <= A[j]) thus giving the maximum difference of j - i which is 6(7-1).

####################################################Solution###################################################################
*/
class MaxDifference{
    
    // Function to find maximum difference of j-1
    // arr[]: input array
    // n: size of array
    static int maxIndexDiff(int arr[], int n) { 
        
        // Your code here
        int j=n-1,i=0,diff=0,max=0;
        while(j>i){
            if(arr[j]>=arr[i]){
                //System.out.println("i"+i);
                //System.out.println("j"+j);
                diff=j-i;
                j=n-1;
                i++;
                if(diff>max){
                    max=diff;
                }
                continue;
            }
            else {
                j--;
            }
        }
        return max;
    }
}
