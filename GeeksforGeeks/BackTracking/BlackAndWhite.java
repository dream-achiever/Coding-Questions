/*
Given the chessboard dimensions. Find out the number of ways we can place a black and a white Knight on this chessboard such that they cannot attack each other.

Note:
The knights have to be placed on different squares. A knight can move two squares horizontally and one square vertically (L shaped), or two squares vertically and one square horizontally (L shaped). The knights attack each other if one can reach the other in one move.

Example 1:

Input:
N = 2,M = 2
Output: 12 
Example 2:

Input:
N = 2,M = 3
Output: 26
Your Task:
Your task is to complete the function solve () which takes the chessboard dimension N and M as inputs and returns the number of ways we can place 2 Knights on this chessboard such that they cannot attack each other. Since this number can be very large, return it modulo 109+7.

Expected Time Complexity: O(N*M).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N * M <= 105
######################################################################################Solution######################################################################
*/
class BlackAndWhite
{
    //Function to find out the number of ways we can place a black and a 
    //white Knight on this chessboard such that they cannot attack each other.
    static long solve(int N, int M)
    {
        // add your code here
        
        int row[] = {-2,-1,1,2,2,1,-1,-2};
        int col[] = {-1,-2,-2,-1,1,2,2,1};
        
        long num = N*M-1;
        long ans=0;
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                int count=0;
                for(int k=0;k<8;k++){
                    int x = row[k]+i;
                    int y = col[k]+j;
                    
                    if(x>=0 && x<N && y>=0 && y<M){
                        count++;
                    }
                }
                ans=(ans+(num-count))%1000000007;
            }
        }
        return ans;
    }
}
