/*
You are given an array of integers and an integer sum. You need to find if two numbers in the array exists that have sum equal to the given sum.

Input:
The first line of input contains T denoting the number of testcases. T testcases follow. Each testcase contains three lines of input. The first line contains N denoting the size of the array A. The second line contains N elements of the array. The third line contains element sum.

Output:
For each testcase, in a new line, print the required output.

Your Task:
You don't need to read input or print anything. You just have to complete the function sumExists() which takes the array arr[], its size N and an integer sum as inputs and returns true if there exists a pair with the given sum in the array. Else, it returns false. 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= T <= 100
1 <= N <= 1000
1 <= Ai <= 106
1 <= sum <= 1000

Examples:
Input:
2
10
1 2 3 4 5 6 7 8 9 10
14
4
4 3 5 6
12
Output:
1
0

Explanation:
Testcase 1: there exists a pair which gives sum as 14 example (4,10), (5,9) etc.
Testcase 2: there does not exist any such pair which gives sum as 12.

#######################################################################Solution#####################################################################################
*/
class Geeks
{
    //Complete this function
    public static int sumExists(int arr[], int N, int sum)
    {
        
        //Your code here
        
        LinkedHashSet<Integer> hs = new LinkedHashSet<>();
        for(int i=0;i<N;i++){
            hs.add(arr[i]);
        }
        Iterator<Integer> itr = hs.iterator();
        int count=0;
        while(itr.hasNext()){
            int value = itr.next();
            if(hs.contains(sum-value) &&(sum-value)!=value ){
                count++;
            }
            if(count==2){
                return 1;
            }
        }
        return 0;
     }
      
    
}
