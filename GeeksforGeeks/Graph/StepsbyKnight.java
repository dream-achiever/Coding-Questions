/*
Given a square chessboard, the initial position of Knight and position of a target. Find out the minimum steps a Knight will take to reach the target position.

Note:
The initial and the target position co-ordinates of Knight have been given accoring to 1-base indexing.

 

Example 1:

Input:
N=6
knightPos[ ] = {4, 5}
targetPos[ ] = {1, 1}
Output:
3
Explanation:

Knight takes 3 step to reach from 
(4, 5) to (1, 1):
(4, 5) -> (5, 3) -> (3, 2) -> (1, 1).
 

 

Your Task:
You don't need to read input or print anything. Your task is to complete the function minStepToReachTarget() which takes the inital position of Knight (KnightPos), the target position of Knight (TargetPos) and the size of the chess board (N) as an input parameters and returns the minimum number of steps required by the knight to reach from its current position to the given target position.

 

Expected Time Complexity: O(N2).
Expected Auxiliary Space: O(N2).

 

Constraints:
1 <= N <= 1000
1 <= Knight_pos(X, Y), Targer_pos(X, Y) <= N
##################################################################################Solution##########################################################################
*/
class Ele {
    int x=0;
    int y=0;
    int dist=0;
    Ele(int x,int y,int dist){
        this.x=x;
        this.y=y;
        this.dist = dist;
    }
}

class Solution
{
    
    boolean isSafe(int[][] mat,boolean[][] visited,int row,int col,int  N){
        return (row>=1) && (row<=N) && (col>=1) && (col<=N) && (!visited[row][col]);
    }
    
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
        
        int[][] mat = new int[N][N];
        
        boolean visited[][] = new boolean[N+1][N+1];
        
        int rowNum[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
        int colNum[] = { -1, -2, -2, -1, 1, 2, 2, 1 };;
        
        Queue<Ele> q = new LinkedList<>();
        q.add(new Ele(KnightPos[0],KnightPos[1],0));
        Ele temp;
        int row,col;
        visited[KnightPos[0]][KnightPos[1]]=true;
        
        while(!q.isEmpty()){
            temp = q.poll();
            if(temp.x==TargetPos[0] && temp.y == TargetPos[1]){
                return temp.dist;
            }
            for(int k=0;k<8;k++){
                row = temp.x+rowNum[k];
                col = temp.y+colNum[k];
                
                if(isSafe(mat,visited,row,col,N)){
                    visited[row][col]=true;
                    q.add(new Ele(row,col,temp.dist+1));
                }
            }
        }
        return Integer.MAX_VALUE;
        
    }
}
