/*
Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not. 

Example 1:

Input:   

Output: 1
Explanation: 1->2->3->4->1 is a cycle.
Example 2:

Input: 

Output: 0
Explanation: No cycle in the graph.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function isCycle() which takes V denoting the number of vertices and adjacency list as input parameters and returns a boolean value denoting if the undirected graph contains any cycle or not.
 

Expected Time Complexity: O(V + E)
Expected Space Complexity: O(V)
 

Constraints:
1 ≤ V, E ≤ 105
##############################################################################Solution##############################################################################
*/
class Solution
{
    
    public boolean dfsRec(ArrayList<ArrayList<Integer>> adj, boolean visited[],int s, int parent){
        visited[s]=true;
        for(int v: adj.get(s)){
            if(!visited[v]){
                
                if(dfsRec(adj,visited,v,s)){
                    return true;
                }
            }
            else if(v!=parent){
                return true;
            }
        }
        
        return false;
    }
    
    //Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        boolean visited[] = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(dfsRec(adj,visited,i,-1)){
                    return true;
                }
            }
        }
        
        return false;
    }
}
