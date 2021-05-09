/*
Given a Directed Graph with V vertices and E edges, Find any Topological Sorting of that Graph.


Example 1:

Input:

Output:
1
Explanation:
The output 1 denotes that the order is
valid. So, if you have, implemented
your function correctly, then output
would be 1 for all test cases.
One possible Topological order for the
graph is 3, 2, 1, 0.
Example 2:

Input:


Output:
1
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function topoSort()  which takes the integer V denoting the number of vertices and adjacency list as input parameters and returns an array consisting of a the vertices in Topological order. As there are multiple Topological orders possible, you may return any of them.


Expected Time Complexity: O(V + E).
Expected Auxiliary Space: O(V).


Constraints:
2 ≤ V ≤ 104
1 ≤ E ≤ (N*(N-1))/2
##############################################################################Solution##############################################################################
*/
class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        
        boolean visited[] = new boolean[V];
        int indegree[] = new int[V];
        int topSort[] = new int[V];
        int index=0;
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<V;i++){
            for(int v : adj.get(i)){
                indegree[v]++;
            }
        }
        
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        
        while(!q.isEmpty()){
            int u = q.poll();
            topSort[index] = u;
            index++;
            
            for(int v : adj.get(u)){
                indegree[v]--;
                if(indegree[v]==0){
                    q.add(v);
                }
            }
        }
        return topSort;
    }
}
