/*
Given an array A and an integer K. Find the maximum for each and every contiguous subarray of size K.

Input:
The first line of input contains an integer T denoting the number of test cases. The first line of each test case contains a single integer N denoting the size of array and the size of subarray K. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.

Output:
Print the maximum for every subarray of size k.

Constraints:
1 ≤ T ≤ 200
1 ≤ N ≤ 107
1 ≤ K ≤ N
0 ≤ A[i] <= 107

Example:
Input:
2
9 3
1 2 3 1 4 5 2 3 6
10 4
8 5 10 7 9 4 15 12 90 13

Output:
3 3 4 5 5 5 6
10 10 10 15 15 90 90

Explanation:
Testcase 1: Starting from first subarray of size k = 3, we have 3 as maximum. Moving the window forward, maximum element are as 3, 4, 5, 5, 5 and 6.

########################################################################Solution####################################################################################
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws Exception {
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-->0){
		    String input[] = br.readLine().trim().split(" ");
		    int size = Integer.parseInt(input[0]);
		    int k = Integer.parseInt(input[1]);
		    int arr[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		    
		    Deque<Integer> dq = new LinkedList<>();
            int n=arr.length;
            for(int i=0;i<k;i++){
                while(!dq.isEmpty() && arr[i]>=arr[dq.peekLast()]){
                    dq.pollLast();
                }
                dq.offerLast(i);
            }
            for(int i=k;i<n;i++){
                System.out.print(arr[dq.peekFirst()]+" ");
                while(!dq.isEmpty() && dq.peekFirst()<=i-k){
                    dq.pollFirst();
                }
                while(!dq.isEmpty() && arr[i]>=arr[dq.peekLast()]){
                    dq.pollLast();
                }
                dq.offerLast(i);
            }
            System.out.print(arr[dq.peekFirst()]+" ");
            System.out.println();
		}
	}
}
