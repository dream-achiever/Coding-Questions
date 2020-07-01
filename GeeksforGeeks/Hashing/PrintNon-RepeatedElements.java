/*
Hashing is very useful to keep track of the frequency of the elements in a list.

You are given an array of integers. You need to print the non-repeated elements as they appear in the array.

Input:
The first line of input contains T denoting the number of testcases. T testcases follow. Each testcase contains two lines of input. The first line contains n denoting the size of the array. The second line contains n elements of the array.

Output:
For each testcase, in a new line, print the non-repeated elements in the order they appear in the array.

Your Task:
You don't need to read input or print anything. You only need to complete the function printNonRepeated() that takes arr and n as parameters and return the array which has the distinct elements in same order as they appear in input array. The newline is appended automatically by the driver code.

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
10 20 40 30 10
Output:
4 5 6 7
20 40 30

Explanation:
Testcase 1: 4, 5, 6 and 7 are the only elements which is having only 1 frequency and hence, Non-repeating.
Testcase 2: 20, 40, 30 are the only elements which is having only 1 frequency and hence, Non-repeating.
#############################################################################Solution###############################################################################
*/
class Hashing
{
    static ArrayList<Integer> printNonRepeated(int arr[], int n)
    {
        // add your code here
        LinkedHashMap<Integer,Integer> hm = new LinkedHashMap<Integer,Integer>();
        ArrayList<Integer> array = new ArrayList<>();
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
        Iterator<Map.Entry<Integer,Integer>> itr = hm.entrySet().iterator();
        while(itr.hasNext()){
            Map.Entry<Integer,Integer> pair = itr.next();
            if(pair.getValue()==1){
                array.add(pair.getKey());
            }
        }
        return array;
    }
}
