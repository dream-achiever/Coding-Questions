/*
Given a grid consisting of '0's(Water) and '1's(Land). Find the number of islands.
Note: An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically or diagonally i,e in all 8 directions.
 

Example 1:

Input:
grid = {{0,1},{1,0},{1,1},{1,0}}
Output:
1
Explanation:
The grid is-
0 1
1 0
1 1
1 0
All lands are connected.
Example 2:

Input:
grid = {{0,1,1,1,0,0,0},{0,0,1,1,0,1,0}}
Output:
2
Expanation:
The grid is-
0 1 1 1 0 0 0
0 0 1 1 0 1 0 
There are two islands one is colored in blue 
and other in orange.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function numIslands() which takes grid as input parameter and returns the total number of islands.
 

Expected Time Compelxity: O(n*m)
Expected Space Compelxity: O(n*m)
 

Constraints:
1 <= n, m <= 500
###############################################################################Solution#############################################################################
*/
class Solution
{
    
    boolean isSafe(char grid[][],boolean[][] visited,int row,int col){
        int m = grid.length;
        int n = grid[0].length;
        
        return (row>=0) && (row<m) && (col>=0) && (col<n) && (grid[row][col]=='1' && !visited[row][col]);
    }
    
    void dfsRec(char grid[][],boolean[][] visited,int row,int col){
        visited[row][col]=true;
        
        int[] rowNum = {0,-1,0,1,1,-1,-1,1};
        int[] colNum = {-1,0,1,0,-1,-1,1,1};
        for(int k=0;k<8;++k){
            if(isSafe(grid,visited,row+rowNum[k],col+colNum[k])){
                dfsRec(grid,visited,row+rowNum[k],col+colNum[k]);
            }
        }
        
    }
    
    //Function to find the number of islands.
    public int numIslands(char[][] grid)
    {
        // Code here
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count=0;
        
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(grid[i][j]=='1' && !visited[i][j]){
                    dfsRec(grid,visited,i,j);
                    ++count;
                }
            }
        }
        return count;
    }
}
