/*
Given two strings a and b. The task is to find if the string 'b' can be obtained by rotating another string 'a' by exactly 2 places.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. In the next two lines are two string a and b respectively.

Output:
For each test case in a new line print 1 if the string 'a' can be obtained by rotating string 'b' by two places else print 0.

User Task:
The task is to complete the function isRotated() which takes two strings as input parameters and checks if given strings can be formed by rotations. The function returns true if string 1 can be obtained by rotating string 2 by two places, else it returns false.

Expected Time Complexity: O(N).
Expected Space Complexity: O(N).
Challenge: Try doing it in O(1) space complexity.

Constraints:
1 <= T <= 50
1 <= length of a, b < 100

Example:
Input:
2
amazon
azonam
geeksforgeeks
geeksgeeksfor
Output:
1
0

Explanation:
Testcase 1: amazon can be rotated anti-clockwise by two places, which will make it as azonam.
Testcase 2: If we rotate geeksforgeeks by two place in any direction , we won't get geeksgeeksfor.

##############################################################################Solution############################################################################
*/
class Rotation{
    
    /*  Function to check if two strings are rotated
    *   s1, s2: input strings
    */
    
    public static void reverse(char []str,int start, int end){
        while(start<end){
            char temp = str[start];
            str[start]=str[end];
            str[end]=temp;
            start++;
            end--;
        }
    }
    
    public static boolean isRotated(String s1, String s2){
        
        // Your code here
        
        char str[] = s1.toCharArray();
        char str1[] = s1.toCharArray();
        if(s1.length()==1){
            if((s1.compareTo(s2))==0){
                return true;
            }
            else {
                return false;
            }
        }
        reverse(str,0,1);
        reverse(str,2,str.length-1);
        reverse(str,0,str.length-1);
        
        String string = new String(str);
        
        reverse(str1,str1.length-2,str1.length-1);
        reverse(str1,0,str1.length-3);
        reverse(str1,0,str1.length-1);
        
        String string1 = new String(str1);
        if((string.compareTo(s2))==0){
            return true;
        }
        else if((string1.compareTo(s2))==0){
            return true;
        }
        return false;
        
    }
    
}
