/*
Given a number 'N'. The task is to find the Nth number whose each digit is a prime number i.e 2, 3, 5, 7. In other words you have to find nth number of this sequence : 2, 3, 5, 7, 22, 23 ,.. and so on.

Input Format:
The first line contains a single integer T i.e. the number of test cases. The first and only line of each test case consists of an integer N. 

Output Format:
For each testcase, in a new line, print the Nth number whose each digit is a prime number.

Your Task:
Complete primeDigits function and return the nth number of the given sequence made of prime digits.

Constraints:
1 <= T <= 100
1 <= N <= 100

Examples:
Input:
2
10
21

Output:
33
222

Explanation:
Testcase 1: 10th number in the sequence of numbers whose each digit is prime is 33.
########################################################################Solution####################################################################################
*/
public static void printSub(String str, String curr, int index,int stop,ArrayList<String> ts){
        
        if(index == stop+1){
            ts.add(curr);
            return;
        }
        
        for(int i=0;i<str.length();i++){
            printSub(str,curr+str.charAt(i),index+1,stop,ts);   
        }
        
    }

    public static int primeDigits(int n){
        //Your code here
        ArrayList<String> ts = new ArrayList<>();
        for(int k=0;k<4;k++){
            printSub("2357","",0, k,ts);   
        }
        
        return Integer.parseInt(ts.get(n-1));
    }
