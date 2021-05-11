/*
Given a Undirected Graph with V vertices and E edges, Find the level of node X. if X does not exist in the graph then print -1.
Note: Traverse the graph starting from vertex 0.
 

Example 1:

Input:

X = 4
Output:
2
Explanation:

We can clearly see that Node 4 lies at Level 2.
Example 2:

Input:

X = 5
Output:
-1
Explanation:
Node 5 isn't present in the Graph, so the
Output is -1.
 

Your task:
You don’t need to read input or print anything. Your task is to complete the function nodeLevel() which takes two integers V and X denoting the number of vertices and the node, and another adjacency list adj as input parameters and returns the level of Node X. If node X isn't present it returns -1.


Expected Time Complexity: O(V + E)
Expected Auxiliary Space: O(V)

 

Constraints:
2 ≤ V ≤ 104
1 ≤ E ≤ (N*(N-1))/2
0 ≤ u, v < V
1 ≤ X ≤ 104
Graph doesn't contain multiple edges and self loops.
##################################################################################Solution########################################################################
*/
class Solution
{
    
    //Function to find the level of node X.
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X)
    {
        // code here
        boolean visited[] = new boolean[V];
        int level[] = new int[V];
        Queue<Integer> q = new LinkedList<>();
        
        if(X>=V){
            return -1;
        }
        
        visited[0]=true;
        level[0]=0;
        q.add(0);
        
        while(!q.isEmpty()){
            int u = q.poll();
            visited[u]=true;
            
            for(int v : adj.get(u)){
                if(!visited[v]){
                    level[v]=level[u]+1;
                    visited[v]=true;
                    q.add(v);
                }
            }
        }
        return level[X];
    }
}
