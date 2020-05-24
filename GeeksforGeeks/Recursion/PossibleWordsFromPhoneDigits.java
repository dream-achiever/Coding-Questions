/*
Given a keypad as shown in diagram, and an N digit number. List all words which are possible by pressing these numbers.
Input:
The first line of input contains an integer T denoting the number of test cases. T test cases follow. Each test case contains two lines of input. The first line of each test case is N, N is the number of digits. The second line of each test case contains D[i], N number of digits.

Output:
Print all possible words in lexicographically order from phone digits with a single space.

Your Task:
This is a function problem. You just need to complete the function possibleWords that takes an array as parameter and prints all the possible words in lexicographical order. The new line is automatically added by the driver code.

Expected Time Complexity: O(4N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= T <= 100
1 <= N <= 10
2 <=  D[i] <= 9

Example:
Input:
2
3
2 3 4
3
3 4 5
Output:
adg adh adi aeg aeh aei afg afh afi bdg bdh bdi beg beh bei bfg bfh bfi cdg cdh cdi ceg ceh cei cfg cfh cfi
dgj dgk dgl dhj dhk dhl dij dik dil egj egk egl ehj ehk ehl eij eik eil fgj fgk fgl fhj fhk fhl fij fik fil

Explanation:
Testcase 1: When we press 2,3,4 then adg,adh,adi , ......,cfi are the list of possible words.
Testcase 2: When we press 3,4,5 then dgj,dgk,dgl,.......,fil are the list of possible words.

#########################################################Solution#######################################################################
*/
class PhoneDigit
{
    private static final String[] mapping = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    
    public static void helper(String digits, int index,String singleCombination,List<String> res){
        if(index == digits.length()){
            res.add(singleCombination);
            return;
        }
        String letters = mapping[digits.charAt(index) - '0'];
        
        for(char letter : letters.toCharArray()){
            helper(digits, index+1,singleCombination+letter,res);
        }
    }
    
    static void possibleWords(int a[], int N)
    {
        // your code here 
        StringBuffer sb = new StringBuffer();
        String digits="", result="";
        int index=0;
        List<String> res = new ArrayList<>();
        for(int i=0;i<N;i++){
            digits = String.valueOf(sb.append(a[i]));
        }
        result = Arrays.toString(res.toArray()).replace("[", "").replace("]", "");
        
        if(digits == null || digits.length() == 0){
            System.out.print(result);
        }
        
        helper(digits,0,"",res);
        result = Arrays.toString(res.toArray()).replace("[", "").replace(",", "").replace("]", "");
        System.out.print(result);
    }
}
