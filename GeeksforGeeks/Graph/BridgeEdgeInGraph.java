/*
Given an undirected graph of V vertices and E edges and another edge (c-d), the task is to find if the given edge is a bridge in graph, i.e., removing the edge disconnects the graph.

 

Example 1:

Input:

c = 1, d = 2
Output:
1
Explanation:
From the graph, we can clearly see that
removing the edge 1-2 will result in 
disconnection of the graph. So, it is 
a bridge Edge and thus the Output 1.

Example 2:

Input:

c = 0, d = 2
Output:
0
Explanation:

Removing the edge between nodes 0 and 2
won't affect the connectivity of the graph.
So, it's not a Bridge Edge. All the Bridge
Edges in the graph are marked with a blue
line in the above image.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function isBridge()  which takes number of vertices V, the number of edges E, an adjacency lsit adj and two integers c and d denoting the edge as input parameters and returns 1 if the given edge c-d is a Bridge. Else, it returns 0.

 

Expected Time Complexity: O(V + E).
Expected Auxiliary Space: O(V).

 

Constraints:
1 ≤ V,E ≤ 105
0 ≤ c, d ≤ V-1
################################################################################Solution############################################################################
*/
class Solution
{
 
    public static void DFS(ArrayList<ArrayList<Integer>> adj, int u,boolean visited[]){
        visited[u] = true;
        
        for(int v : adj.get(u)){
            if(!visited[v]){
                DFS(adj,v,visited);
            }
        }
    }
    
    public static boolean isConnected(ArrayList<ArrayList<Integer>> adj, int V, int one,int two){
        
        boolean visited[] = new boolean[V];
        
        DFS(adj,one,visited);
        
        if(!visited[two]){
            return false;
        }
        return true;
    }
    
    //Function to find if the given edge is a bridge in graph.
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
        // code here
        
        if(!isConnected(adj,V,c,d)){
            return 0;
        }
        else {
            
            adj.get(c).remove(new Integer(d));
            adj.get(d).remove(new Integer(c));
            
            if(isConnected(adj,V,c,d)){
                return 0;
            }
            else {
                return 1;
            }
            
        }
        
    }
}
