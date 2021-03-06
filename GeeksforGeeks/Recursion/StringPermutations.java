/*
Given a string S. The task is to print all permutations of a given string.

Input Format:
The first line of input contains an integer T, denoting the number of test cases. Each test case contains a single string S in capital letter.

Output Format:
For each test case, print all permutations of a given string S with single space and all permutations should be in lexicographically increasing order.

Your Task:
This is a function problem. You only need to complete the function permutation that takes S as parameter and prints the permutations in lexicographically increasing order. The newline is automatically added by driver code.

Constraints:
1 ≤ T ≤ 100
1 ≤ size of string ≤ 5

Example:
Input:
2
ABC
ABSG

Output:
ABC ACB BAC BCA CAB CBA 
ABGS ABSG AGBS AGSB ASBG ASGB BAGS BASG BGAS BGSA BSAG BSGA GABS GASB GBAS GBSA GSAB GSBA SABG SAGB SBAG SBGA SGAB SGBA

Explanation:
Testcase 1: Given string ABC has permutations in 6 forms as ABC, ACB, BAC, BCA, CAB and CBA .
######################################################Solution#################################################################
*/
class Permutation
{
    private static void permute(String str, int l, int r,ArrayList<String>list)
    {
        if(l == r){
        
            list.add(str);
            return;
        }
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permute(str, l+1, r,list);
                str = swap(str,l,i);
            }
        }
    }
    public void permutation(String S)
    {
        //Your code here
        ArrayList <String> list = new ArrayList<>();
        int n=S.length();
        permute(S,0,n-1,list);
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
    }
	public static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
