/*
You are given heights of consecutive buildings. You can move from the roof of a building to the roof of next adjacent building. You need to find the maximum number of consecutive steps you can put forward such that you gain an increase in altitude with each step.

Input:
The first line contains an integer T, denoting number of test cases. First line of each test case contains an integer N, denoting number of buildings. Second line of the test case contains N space separated integers, the ith integer denote the hieght of the ith building.

Output:
For each test case, print maximum number of consecutive steps he can put forward such that he increase in altitude, in separate lines. He initially is on the roof of the first building.

User Task:
The task is to complete the function maxStep() which takes an array A[] (denoting the heights of buildings) and its size N as inputs and returns the maximum number of steps to gain increase in altitude.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1). 

Constraints:
1 <= T <= 104
1 <= N <= 104
1 <= Ai <= 104

Example:
Input:
2
5
1 2 2 3 2
4
1 2 3 4
Output:
1
3

Explanation:
Testcase 1: 1, 2 or 2, 3 are the only consecutive buildings with increasing heights.
Testcase 2: 1 to 2 to 3 to 4 is the jump of length 3 to have maximum number of buildings with increasing heights.
#############################################################################################Solution###############################################################
*/
class Step{
    
    // Function to find the maximum steps
    // arr[]: input array
    // n: size of the array
    static int maxStep(int arr[], int n){
        
        // Your code here
        int buy=arr[0];
        int sell = arr[0];
        int count=0,global=0;
        for(int i=1;i<n;i++){
            if(arr[i]>sell){
                sell = arr[i];
                count++;
            }
            else{
                count=0;
                global = Math.max(global,count);
                buy = arr[i];
                sell = arr[i];
            }
            global=Math.max(global,count);
        }
        return global;
    }
    
}
