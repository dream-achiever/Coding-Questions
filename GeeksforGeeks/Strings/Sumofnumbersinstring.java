/*
Given a string str containing alphanumeric characters. The task is to calculate the sum of all the numbers present in the string.

Input:
The first line of input contains an integer T denoting the number of test cases. Then Ttest cases follow. Each test case contains a string containing alphanumeric characters.

Output:
Print the sum of all the numbers present in the string.

User Task:
The task is to complete the function findSum() which finds and returns the sum of numbers in the string.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 <= T <= 100
1 <= length of the string <= 105
Sum of Numbers <= 105

Example:
Input:
4
1abc23
geeks4geeks
1abc2x30yz67
123abc

Output:
24
4
100
123

Explanation:
Testcase 1: 1 and 23 are numbers in the string which is added to get the sum as 24.
Testcase 2: 4 is the only number, so the sum is 4.
Testcase 3: 1, 2, 30 and 67 are the numbers in the string which is added to get the sum as 100.
Testcase 4: 123 is a single number, so the sum is 123.
#####################################################################Solution#####################################################################################
*/
class SumNumbers{
    // Function to find the sum of all
    // the numbers in the given string s
    public static long findSum(String s){
        
        // your code here
        int res=0;
        
            for(int i=0;i<s.length();){
                int num =0;
                while(i<s.length() && (s.charAt(i)>47 && s.charAt(i)<58)){
                    num=num*10+Character.getNumericValue(s.charAt(i));
                    i++;
                }
                //res+=(char)temp-'0';
                res+=num;
            
            if(num == 0)
                i++;
            }
            return (long)res;
    }
    
}
