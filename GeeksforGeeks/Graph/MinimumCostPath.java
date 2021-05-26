/*
Given a square grid of size N, each cell of which contains integer cost which represents a cost to traverse through that cell, we need to find a path from top left cell to bottom right cell by which the total cost incurred is minimum.
From the cell (i,j) we can go (i,j-1), (i, j+1), (i-1, j), (i+1, j). 

Note: It is assumed that negative cost cycles do not exist in the input matrix.
 

Example 1:

Input: grid = {{9,4,9,9},{6,7,6,4},
{8,3,3,7},{7,4,9,10}}
Output: 43
Explanation: The grid is-
9 4 9 9
6 7 6 4
8 3 3 7
7 4 9 10
The minimum cost is-
9 + 4 + 7 + 3 + 3 + 7 + 10 = 43.
Example 2:

Input: grid = {{4,4},{3,7}}
Output: 14
Explanation: The grid is-
4 4
3 7
The minimum cost is- 4 + 3 + 7 = 14.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function minimumCostPath() which takes grid as input parameter and returns the minimum cost to react at bottom right cell from top left cell.
 

Expected Time Compelxity: O(n2*log(n))
Expected Auxiliary Space: O(n2) 
 

Constraints:
1 ≤ n ≤ 500
1 ≤ cost of cells ≤ 1000
##################################################################################Solution##########################################################################
*/
class Cell {
    
    int x=0;
    int y=0;
    int dist = 0;
    
    Cell(int x,int y, int dist){
        this.x=x;
        this.y=y;
        this.dist=dist;
    }
    
}

class distanceComparator implements Comparator<Cell> {
    
    public int compare(Cell a, Cell b){
        
        if(a.dist<b.dist){
            return -1;
        }
        else if(a.dist>b.dist){
            return 1;
        }
        else {
            return 0;
        }
        
    }
    
}


class Solution
{
    
    boolean isSafe(int grid[][] , int row, int col){
        int m = grid.length;
        int n = grid[0].length;
        
        return (row>=0) && (row<m) && (col>=0) && (col<n);
        
    }
    
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
    public int minimumCostPath(int[][] grid)
    {
        // Code here
        int m = grid.length;
        int n = grid[0].length;
        
        int dist[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        
        int rowNum[] = {0,0,1,-1};
        int colNum[] = {1,-1,0,0};
        
        dist[0][0]=grid[0][0];
        
        PriorityQueue<Cell> pq = new PriorityQueue<Cell>(m*n, new distanceComparator());
        
        pq.add(new Cell(0,0,dist[0][0]));
        
        while(!pq.isEmpty()){
            
            Cell curr = pq.poll();
            
            for(int i=0;i<4;i++){
                int row = curr.x+rowNum[i];
                int col = curr.y + colNum[i];
                
                if(isSafe(grid,row,col)){
                    if(dist[row][col] > dist[curr.x][curr.y]+grid[row][col]){
                        if(dist[row][col]!=Integer.MAX_VALUE){
                            Cell adj = new Cell(row,col,dist[row][col]);
                            
                            pq.remove(adj);
                        }
                        
                        dist[row][col] = dist[curr.x][curr.y] + grid[row][col];
                        
                        pq.add(new Cell(row,col,dist[row][col]));
                        
                    }
                }
                
            }
            
        }
        
        return dist[m-1][n-1];
    }
}
