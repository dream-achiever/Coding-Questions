/*
Given an unsorted array of integers and a sum. The task is to count the number of subarray which adds to the given sum.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains an integer N denoting the size of the array. The next line contains N space separated integers forming the array. The last line contains an integer denoting the value of the sum.

Output:
For each testcase, in a new line, print the count of the subarray which adds to the given sum.

Your Task:
This is a function problem. You only need to complete the function subArraySum() that takes arr, n, sum as parameters and returns the count of subarrays which adds up to the given sum. 

Constraints:
1 <= T <= 200
1 <= N <= 105
-105 <= arr[i] <= 105
-105 <= sum <= 105

Example:
Input:
2
5
10 2 -2 -20 10
-10
6
1 4 20 3 10 5
33
Output:
3
1

Explanation:
Testcase 1: Subarrays with sum -10 are: [10, 2, -2, -20], [2, -2, -20, 10] and [-20, 10].
Testcase 2: Subarray with sum 33 is: [20,3,10].
##########################################################################Solution##################################################################################
*/
class sumRange
{
    static int subArraySum(int arr[], int n, int sum)
    {
        // add your code here
        Integer count=0;
        LinkedHashMap<Integer,Integer> hs = new LinkedHashMap<>();
        hs.put(0,1);
        int prefix = 0;
        for(int i=0;i<n;i++){
            prefix +=arr[i];
            if(hs.containsKey(prefix-sum)){
                Integer c = hs.get(prefix);
                count+=hs.get(prefix-sum);
            }
            if(!hs.containsKey(prefix)){
                hs.put(prefix,1);
            }
            else {
                hs.put(prefix,hs.get(prefix)+1);
            }
            
            
        }
        return count;
    }
}
