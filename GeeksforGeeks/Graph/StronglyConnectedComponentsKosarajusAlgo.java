/*
Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, Find the number of strongly connected components in the graph.
 

Example 1:

Input:

Output:
3
Explanation:

We can clearly see that there are 3 Strongly
Connected Components in the Graph
Example 2:

Input:

Output:
1
Explanation:
All of the nodes are connected to each other.
So, there's only one SCC.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function kosaraju() which takes the number of vertices V and adjacency list of the graph as inputs and returns an integer denoting the number of strongly connected components in the given graph.
 

Expected Time Complexity: O(V+E).
Expected Auxiliary Space: O(V).
 

Constraints:
1 ≤ V ≤ 5000
0 ≤ E ≤ (V*(V-1))
0 ≤ u, v ≤ N-1
Sum of E over all testcases will not exceed 25*106
###############################################################################Solution#############################################################################
*/
class Solution
{
    
    void topologicalDFS(ArrayList<ArrayList<Integer>> adj,int s,Stack<Integer> st,boolean visited[]){
            visited[s]=true;
            
            for(int v : adj.get(s)){
                if(!visited[v]){
                    topologicalDFS(adj,v,st,visited);
                }
            }
            
            st.push(s);
    }
    
    ArrayList<ArrayList<Integer>> transpose(ArrayList<ArrayList<Integer>> adj){
        
        ArrayList<ArrayList<Integer>> transposeAdj = new ArrayList<ArrayList<Integer>>();
        
        for(int i=0;i<adj.size();i++){
            transposeAdj.add(new ArrayList<>());
        }
        
        for(int i=0;i<adj.size();i++){
            for(int j : adj.get(i) ){
                transposeAdj.get(j).add(i);
            }
        }
        return transposeAdj;
    }
    
    void normalDFS(ArrayList<ArrayList<Integer>> adj,int u,boolean visited[]){
        visited[u]=true;
        
        for(int v : adj.get(u)){
            if(!visited[v]){
                normalDFS(adj,v,visited);
            }
            
        }
        
    }
    
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        Stack<Integer> st = new Stack<>();
        
        boolean visited[] = new boolean[V];
        
        for(int i=0;i<V;i++){
            if(visited[i]==false){
                topologicalDFS(adj,i,st,visited);
            }
        }
        ArrayList<Integer> topologicalSort = new ArrayList<>();
        while(!st.isEmpty()){
            topologicalSort.add(st.pop());
        }
        
        ArrayList<ArrayList<Integer>> arr = transpose(adj);
        
        Arrays.fill(visited,false);
        
        int count=0;
        for(int v : topologicalSort){
            if(!visited[v]){
                normalDFS(arr,v,visited);
                count++;
            }
        
        }
        
        return count;
    }
}
