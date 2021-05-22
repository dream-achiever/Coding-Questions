/*
Given a grid of dimension nxm where each cell in the grid can have values 0, 1 or 2 which has the following meaning:
0 : Empty cell
1 : Cells have fresh oranges
2 : Cells have rotten oranges

We have to determine what is the minimum time required to rot all oranges. A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right) in unit time. 
 

Example 1:

Input: grid = {{0,1,2},{0,1,2},{2,1,1}}
Output: 1
Explanation: The grid is-
0 1 2
0 1 2
2 1 1
Oranges at positions (0,2), (1,2), (2,0)
will rot oranges at (0,1), (1,1), (2,2) and 
(2,1) in unit time.
Example 2:

Input: grid = {{2,2,0,1}}
Output: -1
Explanation: The grid is-
2 2 0 1
Oranges at (0,0) and (0,1) can't rot orange at
(0,3).
 

Your Task:
You don't need to read or print anything, Your task is to complete the function orangesRotting() which takes grid as input parameter and returns the minimum time to rot all the fresh oranges. If not possible returns -1.
 

Expected Time Compelxity: O(n*m)
Expected Auxiliary Space: O(1)
 

Constraints:
1 ≤ n, m ≤ 500
################################################################################Solution############################################################################
*/
class Ele{
    
    int x=0;
    int y=0;
    
    Ele(int x,int y){
        this.x = x;
        this.y = y;
    }
    
}

class Solution
{
    
    boolean isValid(int[][] grid, int row, int col){
        int m = grid.length;
        int n = grid[0].length;
        return (row>=0) && (col>=0) && (row<m) && (col<n);
    }
    
    boolean isDelim(Ele temp){
        return (temp.x==-1 && temp.y==-1);
    }
    
    boolean checkAll(int grid[][]){
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    return true;
                }
            }
        }
        return false;
    }
    
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        // Code here
        
        Queue<Ele> q = new LinkedList<>();
        
        int m = grid.length;
        int n = grid[0].length;
        
        Ele temp;
        
        int count=0;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new Ele(i,j));
                }
            }
        }
        q.add(new Ele(-1,-1));
        
        int[] rowNum = {0,0,1,-1};
        int[] colNum = {1,-1,0,0};
        
        while(!q.isEmpty()){
            boolean flag = false;
            while(!isDelim(q.peek())){
                temp = q.peek();
                
                for(int k=0;k<4;k++){
                    if(isValid(grid,temp.x+rowNum[k],temp.y+colNum[k]) && grid[temp.x+rowNum[k]][temp.y+colNum[k]]==1){
                        if(!flag){
                            count++;
                            flag=true;
                        }
                        grid[temp.x+rowNum[k]][temp.y+colNum[k]] = 2;
                        
                        if(rowNum[k]!=0){
                            temp.x = temp.x+rowNum[k];
                            q.add(new Ele(temp.x,temp.y));
                            temp.x = temp.x-rowNum[k];
                        }
                        else if(colNum[k]!=0){
                            temp.y = temp.y+colNum[k];
                            q.add(new Ele(temp.x,temp.y));
                            temp.y = temp.y-colNum[k];
                        }
                    }
                }
                
                q.remove();
                
            }
            q.remove();
            
            if(!q.isEmpty()){
                q.add(new Ele(-1,-1));
            }
            
        }
        return (checkAll(grid))?-1:count;
    }
}
