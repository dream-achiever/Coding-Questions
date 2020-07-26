/*
Given a string S consisting of uppercase and lowercase characters. The task is to sort uppercase and lowercase letters separately such that if the ith place in the original string had an Uppercase character then it should not have a lowercase character after being sorted and vice versa.

Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. The first line of each test case contains a single integer N denoting the length of string. The second line contains a string S of length N, consisting of uppercase and lowercase characters.

Output:
For each testcase, in a new line, print the answer.

Your Task:
This is a function problem. You only need to complete the function caseSort that returns sorted string.

Expected Time Complexity: O(N*Log(N)).
Expected Auxiliary Space: O(N).

Constraints:
1 ≤ T ≤ 50
1 ≤ N ≤ 103

Example:
Input:
2
12
defRTSersUXI
6
srbDKi
Output:
deeIRSfrsTUX
birDKs

Explanation:
Testcase 1: Sorted form of given string with the same case of character as that in original string.
Testcase 2: Sorted form of given string with the same case of character will result in output as birDKs.
#######################################################################Solution#####################################################################################
*/
class solve{
    
    public static void mergeSort(char [] arr,int start,int end){
        if(start<end){
            int mid = start+(end-start)/2;
            mergeSort(arr,start,mid);
            mergeSort(arr, mid+1,end);
            merge(arr, start, end, mid);
        }
    }
    
    public static void merge(char[] arr, int start, int end, int mid){
        int i=0,j=0,k=0;
        int lsize = mid+1-start;
        int rsize = end-mid;
        
        char larr[] = new char[lsize];
        char rarr[] = new char[rsize];
        
        for(i=0;i<lsize;i++){
            larr[i]=arr[start+i];
        }
        
        for(j=0;j<rsize;j++){
            rarr[j]=arr[mid+1+j];
        }
        i=0;
        j=0;
        k=start;
        while(i<lsize && j<rsize){
            if(larr[i]<=rarr[j]){
                arr[k++]=larr[i++];
            }
            else if(larr[i]>rarr[j]){
                arr[k++]=rarr[j++];
            }
        }
        while(i<lsize){
            arr[k++]=larr[i++];
        }
        while(j<rsize){
            arr[k++]=rarr[j++];
        }
    }
    public static String caseSort(String str) {
        // Your code here
        char s[] = str.toCharArray();
        char arr[] = str.toCharArray();
        mergeSort(arr,0,arr.length-1);
        int k=0;
        for(int i=0;i<s.length;i++){
            if(s[i]>=65 && s[i]<=90){
                s[i]=arr[k++];
            }
            else {
                continue;
            }
        }
        for(int i=0;i<s.length;i++){
            if(s[i]>=97 && s[i]<=122){
                s[i]=arr[k++];
            }
            else {
                continue;
            }
        }
        String std=String.valueOf(s);
        return std;
    }
}
