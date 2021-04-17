/*
Given an input stream of N integers. The task is to insert these numbers into a new stream and find the median of the stream formed by each insertion of X to the new stream.

Example 1:

Input:
N = 4
X[] = 5,15,1,3
Output:
5
10
5
4
Explanation:Flow in stream : 5, 15, 1, 3 
5 goes to stream --> median 5 (5) 
15 goes to stream --> median 10 (5,15) 
1 goes to stream --> median 5 (5,15,1) 
3 goes to stream --> median 4 (5,15,1 3) 
 

Example 2:

Input:
N = 3
X[] = 5,10,15
Output:
5
7.5
10
Explanation:Flow in stream : 5, 10, 15
5 goes to stream --> median 5 (5) 
10 goes to stream --> median 7.5 (5,10) 
15 goes to stream --> median 10 (5,10,15) 
Your Task:
You are required to complete 3 methods insertHeap() which takes 1 argument, balanceHeaps() and getMedian() and returns the current median.
Expected Time Complexity : O(nlogn)
Expected Auxilliary Space : O(n)
 
Constraints:
1 <= N <= 106
1 <= x <= 106

##########################################################################Solution##################################################################################
*/
class Solution
{
    //Function to insert heap.
    public static PriorityQueue<Integer> g = new PriorityQueue<>();
    public static PriorityQueue<Integer> s = new PriorityQueue<>(Collections.reverseOrder());
    public static void insertHeap(int x)
    {
        // add your code here
        if(s.isEmpty()){
            s.add(x);
        }
        else if(x>s.peek()){
            g.add(x);
        }
        else if(g.isEmpty()){
            g.add(s.poll());
            s.add(x);
        }
        else {
            s.add(x);
        }
        balanceHeaps();
        
    }
    
    //Function to balance heaps.
    public static void balanceHeaps()
    {
       // add your code here
       if(Math.abs(s.size()-g.size()) > 1){
           if(s.size() > g.size()){
                g.add(s.poll());
           }
           else {
               s.add(g.poll());
           }
       }
    }
    
    //Function to return Median.
    public static double getMedian()
    {
        // add your code here
        if(s.size()==g.size()){
            return (double) ((s.peek()+g.peek())/2);
        }
        else if(s.size() > g.size()) {
            return (double)  s.peek();
        }
        else {
            return (double)  g.peek();
        }
    }
    
}
