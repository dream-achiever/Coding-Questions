/*
Given a postfix expression, the task is to evaluate the expression and print the final value. Operators will only include the basic arithmetic operators like *,/,+ and - . 

Input:
The first line of input will contains an integer T denoting the no of test cases . Then T test cases follow. Each test case contains an postfix expression.

Output:
For each test case, in a new line, evaluate the postfix expression and print the value.

Constraints:
1 <= T <= 100
1 <= length of expression <= 100

Example:
Input:
2
231*+9-
123+*8-
Output:
-4
-3

Explanation: 
Test Case 1: 231*+9-
- : ( ) - ( )
9 : ( ) - (9)
+ : ( ( ) + ( ) ) - (9)
'*':  ( ( ) + ( ( ) * ( ) ) ) - (9)
1 : ( ( ) + ( ( ) * (1) ) ) - (9)
3 : ( ( ) + ( (3) * (1) ) ) - (9)
2 : ( (2) + ( (3) * (1) ) ) - (9) 
Result = (2 + 3) - 9 = 5 - 9 = -4

Test Case 2: 123+*8-
- : ( ) - ( )
8 : ( ) - (8)
* : ( ( ) * ( ) ) - (8)
+ : ( ( ) * ( ( ) + ( ) ) ) - (8)
3 : ( ( ) * ( ( ) + (3) ) ) - (8)
2 : ( ( ) * ( (2) + (3) ) ) - (8)
1 : ( (1) * ( (2) + (3) ) ) - (8) 
Result = (1 * 5) - 8 = 5 - 8 = -3

#######################################################################Solution#####################################################################################
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static int postfix(String sent){
        Stack<Integer>st = new Stack<>();
        for(int i=0;i<sent.length();i++){
            char c = sent.charAt(i);
            if(Character.isDigit(c)){
                st.push(c-'0');
            }
            else {
                int val1 = st.pop();
                int val2 = st.pop();
                switch(c){
                    case '+': st.push(val2+val1);
                        break;
                    case '-': st.push(val2-val1);
                        break;
                    case '/': st.push(val2/val1);
                        break;
                    case '*': st.push(val2*val1);
                        break;
                }
            }
        }
        return st.pop();
    }
    
	public static void main (String[] args) throws Exception {
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-->0){
		    String sent = br.readLine();
		    System.out.println(postfix(sent));
		}
	}
}
