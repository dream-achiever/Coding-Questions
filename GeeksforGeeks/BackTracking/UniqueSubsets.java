/*
Given an array arr[] of integers of size N that might contain duplicates, the task is to find all possible unique subsets.

Note: Each subset should be sorted.

Example 1:

Input: N = 3, arr[] = {2,1,2}
Output:(),(1),(1 2),(1 2 2),(2),(2 2)
Explanation: 
All possible subsets = (),(2),(1),(1,2),(2),(2,2),(2,1),(2,1,2)
After Sorting each subset = (),(2),(1),(1,2),(2),(2,2),(1,2),(1,2,2) 
Unique Susbsets in Lexicographical order = (),(1),(1,2),(1,2,2),(2),(2,2)
Example 2:

Input: N = 4, arr[] = {1,2,3,3}
Output: (),(1),(1 2),(1 2 3)
(1 2 3 3),(1 3),(1 3 3),(2),(2 3)
(2 3 3),(3),(3 3)
Your Task:
Your task is to complete the function AllSubsets() which takes the array arr[] and N as input parameters and returns list of all possible unique subsets in lexographical order. 

Expected Time Complexity: O(2N).
Expected Auxiliary Space: O(2N * X), X = Length of each subset.

Constraints:
1 ≤ N ≤ 12
1 ≤ arr[i] ≤ 9
####################################################################################Solution########################################################################
*/
class solve
{
    
    public static void uniqueSubsets(int[] arr, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> subset, int startIndex){
        
        res.add(new ArrayList<>(subset));
        
        for(int i=startIndex;i<arr.length;i++){
            if(i!=startIndex && arr[i] == arr[i-1]){
                continue;
            }
            
            subset.add(arr[i]);
            uniqueSubsets(arr,res,subset,i+1);           
            subset.remove(subset.size()-1);
        }
        
    }
    
    //Function to find all possible unique subsets.
    public static ArrayList <ArrayList <Integer>> AllSubsets(int arr[], int n)
    {
        // your code here
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        if(arr==null || arr.length==0){
            return res;
        }
        
        Arrays.sort(arr);
        
        
        ArrayList<Integer> subset = new ArrayList<>();
        
        
        uniqueSubsets(arr,res,subset,0);
        
        res.remove(0);
        return res;
    }
}
