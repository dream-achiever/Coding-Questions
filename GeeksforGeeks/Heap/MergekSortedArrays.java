/*
Given K sorted arrays arranged in the form of a matrix of size K*K. The task is to merge them into one sorted array.
Example 1:

Input:
K = 3
arr[][] = {{1,2,3},{4,5,6},{7,8,9}}
Output: 1 2 3 4 5 6 7 8 9
Explanation:Above test case has 3 sorted
arrays of size 3, 3, 3
arr[][] = [[1, 2, 3],[4, 5, 6], 
[7, 8, 9]]
The merged list will be 
[1, 2, 3, 4, 5, 6, 7, 8, 9].
Example 2:

Input:
K = 4
arr[][]={{1,2,3,4}{2,2,3,4},
         {5,5,6,6},{7,8,9,9}}
Output:
1 2 2 2 3 3 4 4 5 5 6 6 7 8 9 9 
Explanation: Above test case has 4 sorted
arrays of size 4, 4, 4, 4
arr[][] = [[1, 2, 2, 2], [3, 3, 4, 4],
[5, 5, 6, 6]  [7, 8, 9, 9 ]]
The merged list will be 
[1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 
6, 6, 7, 8, 9, 9 ].
Your Task:
You do not need to read input or print anything. Your task is to complete mergeKArrays() function which takes 2 arguments, an arr[k][k] 2D Matrix containing k sorted arrays and an integer k denoting the number of sorted arrays, as input and returns the merged sorted array ( as a pointer to the merged sorted arrays in cpp, as an ArrayList in java, and list in python)

Expected Time Complexity: O(nk Logk)
Expected Auxiliary Space: O(k)

Constraints:
1 <= K <= 100
*/
class Temp implements Comparable<Temp>{
    int data;
    int aPos;
    int vPos;
    Temp(int d, int apos, int vpos){
        data = d;
        aPos = apos;
        vPos = vpos;
    }
    
    public int compareTo(Temp t){
        if(this.data <=t.data){
            return -1;
        }
        else {
            return 1;
        }
    }
} 

class Solution
{
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arrays,int k) 
    {
        // Write your code here.
        ArrayList<Integer> a = new ArrayList<>();
        PriorityQueue<Temp> pq = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            Temp t = new Temp(arrays[i][0],i,0);
            pq.add(t);
        }
        while(!pq.isEmpty()){
            Temp t = pq.poll();
            a.add(t.data);
            int ap =t.aPos;
            int vp = t.vPos;
            if(vp+1<k){
                Temp c = new Temp(arrays[ap][vp+1],ap,vp+1);
                pq.add(c);
            }
        }
        return a;
    }
}
