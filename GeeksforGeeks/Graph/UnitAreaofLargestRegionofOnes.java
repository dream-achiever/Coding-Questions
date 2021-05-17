/*
Given a grid of dimension nxm containing 0s and 1s. Find the unit area of the largest region of 1s.
Region of 1's is a group of 1's connected 8-directionally(horizontally, vertically, dioganally).
 

Example 1:

Input: grid = {{1,1,1,0},{0,0,1,0},{0,0,0,1}}
Output: 5
Explanation: The grid is-
1 1 1 0
0 0 1 0
0 0 0 1
The largest region of 1's is colored
in orange.
Example 2:

Input: grid = {{0,1}}
Output: 1
Explanation: The grid is-
0 1
The largest region of 1's is colored in 
orange.
 

Your Task:
You don't need to read or print anyhting. Your task is to complete the function findMaxArea() which takes grid as input parameter and returns the area of the largest region of 1's.

Expected Time Complexity: O(n*m)
Expected Auxiliary Space: O(n*m)
 

Constraints:
1 ≤ n, m ≤ 500
####################################################################################Solution########################################################################
*/
class Solution
{
    
    boolean isSafe(int[][] grid, boolean visited[][],int row,int col){
        int m = grid.length;
        int n = grid[0].length;
        
        return (row>=0) && (row<m) && (col>=0) && (col<n) && (grid[row][col]==1 && !visited[row][col]);
    }
    
    int dfsRec(int[][] grid, boolean visited[][],int row,int col,int count){
        int[] rowNum = {0,-1,0,1,1,-1,-1,1};
        int[] colNum = {-1,0,1,0,-1,-1,1,1};
        
        visited[row][col]=true;
        for(int k=0;k<8;k++){
            if(isSafe(grid,visited,row+rowNum[k],col+colNum[k])){
                count=dfsRec(grid,visited,row+rowNum[k],col+colNum[k],count+1);
            }
        }
        return count;
    }
    
    //Function to find unit area of the largest region of 1s.
    public int findMaxArea(int[][] grid)
    {
        // Code here
        
        int max = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        boolean visited[][] = new boolean[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    max = Math.max(max,dfsRec(grid,visited,i,j,1));
                }
            }
        }
        return max;
    }
}
