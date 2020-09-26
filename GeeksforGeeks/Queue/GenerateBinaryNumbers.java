/*
The first line of input contains an integer T denoting the number of test cases. There will be a single line for each testcase which contains N.

Output:
Print all binary numbers with decimal values from 1 to N in a single line.

Constraints:
1 ≤ T ≤ 106
1 ≤ N ≤ 106

Example:
Input:
2
2
5

Output:
1 10
1 10 11 100 101

Explanation:
Testcase 1: Binary numbers from 1 to 2 are 1 and 10.
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
		    int a = Integer.parseInt(br.readLine());
		    Queue<String> q = new LinkedList<>();
		    q.add("1");
		    for(int i=0;i<a;i++){
		        String curr = q.poll();
		        System.out.print(curr+" ");
		        q.add(curr+"0");
		        q.add(curr+"1");
		    }
		    System.out.println();
		}
	}
}
