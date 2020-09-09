/*
Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a number of contiguous bars. For simplicity, assume that all bars have same width and the width is 1 unit.

Input:
The first line contains an integer 'T' denoting the total number of test cases. T test-cases follow. In each test cases, the first line contains an integer 'N' denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array. The elements of the array represents the height of the bars.

Output:
For each test-case, in a separate line, the maximum rectangular area possible from the contiguous bars.

Constraints:
1 <= T <= 100
1 <= N <= 105
1 <= A[i] <= 104

Example:
Input: 
2
7
6 2 5 4 5 1 6
4
6 3 4 2
Output:
12
9
#################################################################################Solution###########################################################################
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    public static void maxarea(int arr[]){
        Stack<Integer> pg = new Stack<>();
        Stack<Integer> ng = new Stack<>();
        int s1[] = new int[arr.length];
        int s2[] = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            while(!pg.isEmpty() && arr[i]<=arr[pg.peek()]){
                pg.pop();
            }
            s1[i]= (pg.isEmpty()?-1:pg.peek());
            pg.push(i);
        }
        for(int i=arr.length-1;i>=0;i--){
            while(!ng.isEmpty() && arr[i]<=arr[ng.peek()]){
                ng.pop();
            }
            s2[i]= (ng.isEmpty()?arr.length:ng.peek());
            ng.push(i);
        }
        int result=0,curr=0;
        for(int i=0;i<arr.length;i++){
            curr=(s2[i] - s1[i] -1)*arr[i];
            result = Math.max(result,curr);
        }
        System.out.println(result);
    }
    
	public static void main (String[] args) throws Exception {
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-->0){
		    int size = Integer.parseInt(br.readLine());
		    String line = br.readLine();
		    int arr[] = new int[size];
		    String l[] = line.trim().split("\\s+");
		    for(int i=0;i<size;i++){
		        arr[i]= Integer.parseInt(l[i]);
		    }
		    maxarea(arr);
		}
	}
}
