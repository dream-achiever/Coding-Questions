/*
Given an infix expression in the form of a string str. Conver this infix expression to postfix expression.

Infix expression: The expression of the form a op b. When an operator is in-between every pair of operands.
Postfix expression: The expression of the form a b op. When an operator is followed for every pair of operands.
Input:
The first line of input contains an integer T denoting the number of test cases. The next T lines contains an infix expression.The expression contains all characters and ^,*,/,+,-.

Output:
For each testcase, in a new line, output the infix expression to postfix expression.

Constraints:
1 <= T <= 100
1 <= length of str <= 103

Example:
Input:
2
a+b*(c^d-e)^(f+g*h)-i
A*(B+C)/D

Output:
abcd^e-fgh*+^*+i-
ABC+*D/

##########################################################################Solution##################################################################################
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    public static int Prec(char c){
        switch(c){
            case '+':
            case '-':
                return 1;
            case '/':
            case '*':
                return 2;
            case '^':
                return 3;
            default: 
                return -1;
        }
    }
    public static String infix(String sent){
        
        Stack<Character> st = new Stack<>();
        String result="";
        for(int i=0;i<sent.length();i++){
            char c = sent.charAt(i);
            if(Character.isLetterOrDigit(c)){
                result+=c;
            }
            else if(c=='('){
                st.push(c);
            }
            else if(c==')'){
                while(!st.isEmpty() && st.peek()!='('){
                    result+=st.pop();
                }
                if(!st.isEmpty() && st.peek()!='('){
                    return "Invalid Expression";
                }
                else {
                    st.pop();
                }
            }
            else {
                while(!st.isEmpty() && Prec(c)<=Prec(st.peek())){
                    if(st.peek()=='('){
                        return "Invalid Expression";
                    }
                    result+=st.pop();
                }
                st.push(c);
            }
        }
        while(!st.isEmpty()){
            if(st.peek()=='('){
                return "Invalid Expression";
            }
            result+=st.pop();
        }
        return result;
    }
    
	public static void main (String[] args) throws Exception{
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-->0){
		    String sent = br.readLine();
		    String res = infix(sent);
		    if(res!="Invalid Expression"){
		        System.out.println(res);
		    }
		}
	}
}
