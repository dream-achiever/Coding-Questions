/*
The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate the span of stock’s price for all n days. 
The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the current day is less than or equal to its price on the given day.
For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}.

Input:
The first line of input contains an integer T denoting the number of test cases. The first line of each test case is N, N is the size of the array. The second line of each test case contains N input C[i].

Output:
For each testcase, print the span values for all days.

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 200
1 ≤ C[i] ≤ 800

Example:
Input:
2
7
100 80 60 70 60 75 85
6
10 4 5 90 120 80

Output:
1 1 1 2 1 4 6
1 1 2 4 5 1

##########################################################################Solution##################################################################################
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    public static void stockspan(int arr[]){
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[i]>=arr[st.peek()]){
                st.pop();
            }
            int span = ((st.isEmpty())?i+1:(i-st.peek()));
            st.push(i);
            System.out.print(span+" ");
        }
        System.out.println();
    }
    
	public static void main (String[] args)throws Exception {
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-->0){
		    int size = Integer.parseInt(br.readLine());
		    int arr[] = new int[size];
		    String line = br.readLine();
		    String l[] = line.trim().split("\\s+");
		    for(int i=0;i<size;i++){
		        arr[i]= Integer.parseInt(l[i]);
		    }
		    stockspan(arr);
		}
	}
}
