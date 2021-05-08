/*
Given the adjacency list of a bidirectional graph. Your task is to return the adjacency list for each vertex.


Example 1:

Input:

Output: 
0-> 1-> 4 
1-> 0-> 2-> 3-> 4 
2-> 1-> 3 
3-> 1-> 2-> 4 
4-> 0-> 1-> 3
Explanation:
As 0,1 and 3 is connected to 4 so 4th row
of the list containing 4 and its connected
nodes 0,1 and 3 and we have to add those in
sorted order and same for every row.


Example 2:

Input:


Output: 
0-> 2-> 3 
1-> 2 
2-> 0-> 1 
3-> 0
Explanation:
As 2 and 3 is connected to 0 so 0th row
of the list containing 0 and its connected 
nodes 2 and 3 and we have to add those in
sorted order and same for every row. 


Your task:
You don’t need to read input or print anything. Your task is to complete the function printGraph() which takes the integer V denoting the number of vertices and adjacency list as input parameters and returns the list of list  contains the node itself with its connected nodes(as same as it is given in input adjacency  list).


Expected Time Complexity: O(V + E)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ V, E ≤ 104
###############################################################################Solution#############################################################################
*/
class Solution
{
    //Function to return the adjacency list for each vertex.
    public ArrayList<ArrayList<Integer>> printGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<V;i++){
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(i);
            for(int v : adj.get(i)){
                arr.add(v);
            }
            graph.add(arr);
        }
        return graph;
    }
}