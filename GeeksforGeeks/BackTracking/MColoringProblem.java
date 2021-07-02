/*
Given an undirected graph and an integer M. The task is to determine if the graph can be colored with at most M colors such that no two adjacent vertices of the graph are colored with the same color. Here coloring of a graph means the assignment of colors to all vertices. Print 1 if it is possible to colour vertices and 0 otherwise.

Example 1:

Input:
N = 4
M = 3
E = 5
Edges[] = {(1,2),(2,3),(3,4),(4,1),(1,3)}
Output: 1
Explanation: It is possible to colour the
given graph using 3 colours.
Example 2:

Input:
N = 3
M = 2
E = 3
Edges[] = {(1,2),(2,3),(1,3)}
Output: 0
Your Task:
Your task is to complete the function graphColoring() which takes the 2d-array graph[], the number of colours and the number of nodes as inputs and returns true if answer exists otherwise false. 1 is printed if the returned value is true, 0 otherwise. The printing is done by the driver's code.
Note: In the given 2d-array graph[], if there is an edge between vertex X and vertex Y graph[] will contain 1 at graph[X-1][Y-1], else 0. In 2d-array graph[ ], nodes are 0-based indexed, i.e. from 0 to N-1.

Expected Time Complexity: O(MN).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 20
1 <= E <= (N*(N-1))/2
1 <= M <= N

Note: The given inputs are 1-base indexed but you have to consider the graph given in the adjacency matrix/list as 0-base indexed.
###############################################################################Solution#############################################################################
*/
class solve 
{
    
    public static boolean isSafe(List<Integer> a,int[] color,int V,int j){
        
        for(int i=0;i<a.size();i++){
            if(j==color[a.get(i)]){
                return false;
            }
        }
        
        return true;
    }
    
    public static boolean dfs(List<Integer>[] G,int[] color,int V,int m, int i){
        if(i==V){
            return true;
        }
        
        for(int j=0;j<m;j++){
            if(isSafe(G[i],color,V,j)){
                color[i]=j;
                if(dfs(G,color,V,m,i+1)){
                    return true;
                }
                color[i]=-1;
            }
        }
        return false;
        
    }
    
    //Function to determine if graph can be coloured with at most M colours such
    //that no two adjacent vertices of graph are coloured with same colour.
    public static boolean graphColoring(List<Integer>[] G, int[] color, int i, int C) 
    {
        // Your code here
        
        int V = G.length;
        
        Arrays.fill(color,-1);
        
        return dfs(G,color,V,C,0);
    }
}
