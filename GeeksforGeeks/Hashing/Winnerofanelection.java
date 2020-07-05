/*
Given an array of names (consisting of lowercase characters) of candidates in an election. A candidate name in array represents a vote casted to the candidate. Print the name of candidate that received Max votes. If there is tie, print lexicographically smaller name.

Input:
The first line of the input contains a single integer T, denoting the number of test cases. Then T test case follows. Each testcase contains two lines input. First line is the number of votes cast N.And second line is the name of the candidates separated by a space. Each name represents one vote casted to that candidate.

Output:
For each testcase, print the name of the candidate with the maximum votes, and also print the votes casted for the candidate. The name and votes are separated by a space.

Your Task:
This is a functional problem. You only need to complete the function winner() that takes an array of strings arr, and n as parameters and returns the name of the candiate with maximum votes. 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= T <= 100
1 <= N <= 105

Example:
Input:
2
13
john johnny jackie johnny john jackie jamie jamie john johnny jamie johnny john
3
andy blake clark
Output:
john 4
andy 1

Explanation:
Testcase1: john has 4 votes casted for him, but so does johny. john is lexicographically smaller, so we print john and the votes he received.
Testcase2: All the candidates get 1 votes each. We print andy as it is lexicographically smaller.
############################################################################Solution################################################################################
*/
class Sol
{
    public static pair winner(String arr[], int n)
    {
        // add your code
        LinkedHashMap<String,Integer> hm = new LinkedHashMap<>();
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
        int max_value = Integer.MIN_VALUE;
        String min_name = "";
        Iterator<Map.Entry<String,Integer>> itr = hm.entrySet().iterator();
        while(itr.hasNext()){
            Map.Entry<String, Integer> pr = itr.next();
            int curr_value = pr.getValue();
            String curr_name = pr.getKey();
            if(curr_value>max_value){
                max_value = curr_value;
                min_name = curr_name;
            }
            else if(curr_value==max_value){
                if(curr_name.compareTo(min_name)<0){
                    min_name = curr_name;
                }
            }
        }
        pair p = new pair(min_name,max_value);
        return p;
    }
}
