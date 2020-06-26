/*
Given an array arr[] of size N and an element k. The task is to find all elements in array that appear more than n/k times.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains an integer n denoting the size of the array. Then the next line contains n space separated integers forming the array. The last line of input contains an integer k.

Output:
Print the count of elements in array that appear more than n/k times.

User Task:
The task is to complete the function countOccurence() which returns count of elements with more than n/k times appearance.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= T <= 102
1 <= N <= 104
1 <= a[i] <= 106
1 <= k <= N

Example:
Input:
2
8
3 1 2 2 1 2 3 3
4
4
2 3 3 2
3
Output:
2
2

Explanation:
Testcase 1: In the given array, 3 and 2 are the only elements that appears more than n/k times.
Testcase 2: In the given array, 3 and 2 are the only elements that appears more than n/k times. So the count of elements are 2.

##################################################################################Solution##########################################################################
*/
class CountElement {

    // Function to find element with count more than n/k times
    // arr: input array
    public int countOccurence(int[] arr, int n, int k) {
        // your code here,return the answer
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        int size = max+1;
        int list[] = new int[size];
        for(int i=0;i<arr.length;i++){
            list[arr[i]]+=1;
        }
        int count=0;
        for(int i=0;i<size;i++){
            if(list[i]>(n/k)){
                count++;   
            }
        }
        return count;
    }
}
