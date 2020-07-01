/*
Hashing is very useful to keep track of the frequency of the elements in a list.

You are given an array of integers. You need to print the count of non-repeated elements in the array.

Input:
The first line of input contains T denoting the number of testcases. T testcases follow. Each testcase contains two lines of input. The first line contains an integer n denoting the size of the array. The second line contains n space separated elements of the array.

Output:
For each testcase, in a new line, print the count of distinct elements in the array.

Your Task:
You don't need to read input or print anything. You only need to complete the function countNonRepeated() that takes array arr[] and its size n as parameters and returns the count of non-repeating elements in the array. 

Expected Time Complexity: O(n).
Expected Auxiliary Space: O(n).

Constraints:
1 <= T <= 100
1 <= n <= 103
0 <= arri <= 107

Examples:
Input:
2
10
1 1 2 2 3 3 4 5 6 7
5
10 20 30 40 10
Output:
4
3

Explanation:
Testcase 1: 4, 5, 6 and 7 are the elements with frequency 1 and rest elements are repeated so the number of non-repeated elements are 4.
Testcase 2: 20, 30, 40 are the elements with the frequency 1 and 10 is the repeated element to number of non-repeated elements are 3.

#################################################################################Solution#########################################################################
*/
class Hashing
{
    // Function to count non-repeated elements in the array
    // arr[]: input array
    // n: size of array
    static long countNonRepeated(int arr[], int n)
    {
        // add your code
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            hm.put(arr[i],null);
        }
        
        for(int i=0;i<n;i++){
            Integer c = hm.get(arr[i]);
            if(c==null){
                hm.put(arr[i],1);
            }
            else {
                hm.put(arr[i],c+1);
            }
        }
        long count=0;
        Iterator<Map.Entry<Integer,Integer>> itr = hm.entrySet().iterator();
        while(itr.hasNext()){
            Map.Entry<Integer,Integer> pair = itr.next();
            if(pair.getValue()==1){
                count++;
            }
        }
        return count;
    }
}
