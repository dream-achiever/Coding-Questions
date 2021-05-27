/*
Given a weighted, undirected and connected graph of V vertices and E edges, Find the shortest distance of all the vertex's from the source vertex S.
Note: The Graph doesn't contain any negative weight cycle.

Example 1:

Input:

S = 0
Output:
0 9
Explanation:
Shortest distance of all nodes from
source is printed.
Example 2:

Input:

S = 2
Output:
4 3 0
Explanation:
For nodes 2 to 0, we can follow the path-
2-1-0. This has a distance of 1+3 = 4,
whereas the path 2-0 has a distance of 6. So,
the Shortest path from 2 to 0 is 4.
The other distances are pretty straight-forward.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function dijkstra()  which takes number of vertices V and an adjacency list adj as input parameters and returns a list of integers, where ith integer denotes the shortest distance of the ith node from Source node. Here adj[i] contains a list of lists containing two integers where the first integer j denotes that there is an edge between i and j and second integer w denotes that the weight between edge i and j is w.

 

Expected Time Complexity: O(V2).
Expected Auxiliary Space: O(V2).

 

Constraints:
1 ≤ V ≤ 1000
0 ≤ adj[i][j] ≤ 1000
0 ≤ S < V
#############################################################################Solution###############################################################################
*/
class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        
        boolean[] finalized = new boolean[V];
        
        int dist[] = new int[V];
        
        for(int i=0;i<V;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        
        dist[S]=0;
        
        for(int count=0;count<V-1;count++){
            int u = -1;
            
            for(int i=0;i<V;i++){
                if(!finalized[i] && (u==-1 || dist[i]<dist[u])){
                    u=i;
                }
            }
            finalized[u]=true;
            
            // for(int v=0;v<V;v++){
            //     if(!finalized[v] && adj.get(count).get(u).get(v)!=0 && dist[u]!=Integer.MAX_VALUE){
            //         dist[v]=Math.min(dist[v],dist[u]+adj.get(count).get(u).get(v));
            //     }
            // }
            
            for(int i=0;i<adj.get(u).size();i++) {
                int v = adj.get(u).get(i).get(0);
                int costUV = adj.get(u).get(i).get(1);
                
                if(!finalized[v] && dist[v]>dist[u]+costUV){
                    dist[v]=dist[u]+costUV;
                }
            }
            
        }
        
        return dist;
        
    }
}
