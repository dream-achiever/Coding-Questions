/*
You are given an array of N+2 integer elements. All elements of the array are in range 1 to N. Also, all elements occur once except two numbers which occur twice. Find the two repeating numbers.

Input:
The first line of the input contains an integer T, denoting the total number of test cases. Then T test cases follow Each test case consists of two lines. First line of each test case contains an integer N denoting the range of numbers to be inserted in array of size N+2. Second line of each test case contains the N+2 space separated integers denoting the array elements.

Output:
Print the two elements occuring twice in the array. Order of the two elements must be according to second appearance, i.e., first print the element whose second occurrence arrives first. For example in 1 2 2 1, the output should be 2 1. And for 1 1 2 2, output should be 1 2.

User Task:
The task is to complete the function repeatedElements() which takes array arr[] and an integer N as inputs (the size of the array is N + 2 and elements are in range[1, N]) and finds the two repeated element in the array and prints them. The newline is added by the driver code automatically.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1). 

Constraints:
1 ≤ T ≤ 30
2 ≤ N ≤ 105
1 ≤ array[i] ≤ N

Example:
Input:
3
4
1 2 1 3 4 3
2
1 2 2 1
2
1 1 2 2
Output:
1 3
2 1
1 2

Explanation:
Testcase 1: In the given array, 1 and 3 are repeated two times.
Testcase 2: In the given array , 1 and 2 are repeated two times and second occurence of 2 comes before 1. So the output is 2 1.
Testcase 3: In the given array , 1 and 2 are repeated two times and the output is 1 2.
###############################################################Solution############################################################################################
*/
class Repeated{

    // Function to find the repeated element in the array
    // arr[]: input array
    // n: size of array
    static void twoRepeated(int arr[], int n){
        
        // Your code here
        for(int i=0;i<n+2;i++){
            if(arr[Math.abs(arr[i])]>0){
                arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            }
            else {
                System.out.print(Math.abs(arr[i])+" ");
            }
        }
        
    }
    
}
