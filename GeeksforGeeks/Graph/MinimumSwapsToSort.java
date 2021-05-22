/*
Given an array of n distinct elements. Find the minimum number of swaps required to sort the array in strictly increasing order.


Example 1:

Input:
nums = {2, 8, 5, 4}
Output:
1
Explaination:
swap 8 with 4.
Example 2:

Input:
nums = {10, 19, 6, 3, 5}
Output:
2
Explaination:
swap 10 with 3 and swap 19 with 5.

Your Task:
You do not need to read input or print anything. Your task is to complete the function minSwaps() which takes the nums as input parameter and returns an integer denoting the minimum number of swaps required to sort the array. If the array is already sorted, return 0. 


Expected Time Complexity: O(nlogn)
Expected Auxiliary Space: O(n)


Constraints:
1 ≤ n ≤ 105
1 ≤ numsi ≤ 106
######################################################################################Solution######################################################################
*/
class Solution
{
    
    public void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        // Code here
        int len = nums.length;
        int[] temp = Arrays.copyOfRange(nums,0,len);
        Arrays.sort(temp);
        
        int count=0;
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i=0;i<len;i++){
            hm.put(nums[i],i);
        }
        
        for(int i=0;i<len;i++){
            if(nums[i]!=temp[i]){
                count++;
                int init = nums[i];
                swap(nums,i,hm.get(temp[i]));
                
                hm.put(init, hm.get(temp[i]));
                hm.put(temp[i],i);
            }
        }
        return count;
    }
}
