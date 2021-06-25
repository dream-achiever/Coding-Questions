/*
Given a number K and string str of digits denoting a positive integer, build the largest number possible by performing swap operations on the digits of str at most K times.


Example 1:

Input:
K = 4
str = "1234567"
Output:
7654321
Explanation:
Three swaps can make the
input 1234567 to 7654321, swapping 1
with 7, 2 with 6 and finally 3 with 5
Example 2:

Input:
K = 3
str = "3435335"
Output:
5543333
Explanation:
Three swaps can make the input
3435335 to 5543333, swapping 3 
with 5, 4 with 5 and finally 3 with 4 

Your task:
You don't have to read input or print anything. Your task is to complete the function findMaximumNum() which takes the string and an integer as input and returns a string containing the largest number formed by perfoming the swap operation at most k times.


Expected Time Complexity: O(n!/(n-k)!) , where n = length of input string
Expected Auxiliary Space: O(n)


Constraints:
1 ≤ |str| ≤ 30
1 ≤ K ≤ 10
######################################################################################Solution######################################################################
*/
class Res{
    static String max = "";
}

class Solution
{
    
    public static String swap(char[] str, int  a, int b){
        
        char temp = str[a];
        str[a]=str[b];
        str[b]=temp;
        
        return String.valueOf(str);
    }
    
    public static void findMaxUtil(char str[], int k, Res r){
        
        if(k==0){
                return;
            }
            
            int len = str.length;
            for(int i=0;i<len-1;i++){
                for(int j=i+1;j<len;j++){
                    
                    if (str[i] < str[j])
                    {
                        char temp = str[i];
                        str[i] = str[j];
                        str[j] = temp;
                        
                        String tp = new String(str);
                        
                        if(r.max.compareTo(tp)<0){
                            r.max = tp;
                        }
                        
                        findMaxUtil(str,k-1,r);
                    
                        temp = str[i];
                        str[i] = str[j];
                        str[j] = temp;
                    }
                }
            }
    }
    
    //Function to find the largest number after k swaps.
    public static String findMaximumNum(String str, int k)
    {

            //code here.
            
            Res r = new Res();
            r.max=str;
            
            findMaxUtil(str.toCharArray(), k,r);
            
            return r.max;
    }
}
