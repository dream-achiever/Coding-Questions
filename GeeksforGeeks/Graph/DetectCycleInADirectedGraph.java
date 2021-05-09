/*
Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.


Example 1:

Input:



Output: 1
Explanation: 3 -> 3 is a cycle

Example 2:

Input:


Output: 0
Explanation: no cycle in the graph

Your task:
You don’t need to read input or print anything. Your task is to complete the function isCyclic() which takes the integer V denoting the number of vertices and adjacency list as input parameters and returns a boolean value denoting if the given directed graph contains a cycle or not.


Expected Time Complexity: O(V + E)
Expected Auxiliary Space: O(V)


Constraints:
1 ≤ V, E ≤ 105
#####################################################################################Solution#######################################################################
*/
class Solution 
{
    
    public boolean dfsRec(ArrayList<ArrayList<Integer>> adj,int s,boolean visited[],boolean recSt[]){
        visited[s]=true;
        recSt[s]=true;
        
        for(int v : adj.get(s)){
            if(!visited[v]){
                
                if(dfsRec(adj,v,visited,recSt)){
                    return true;
                }
                
            }
            
            if(recSt[v]){
                return true;
            }
            
        }
        recSt[s]=false;
        return false;
    }
    
    //Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // code here
        boolean visited[] = new boolean[V];
        
        boolean recSt[] = new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(dfsRec(adj,i,visited,recSt)){
                    return true;
                }
            }
            
        }
        
        return false;
    }
}
