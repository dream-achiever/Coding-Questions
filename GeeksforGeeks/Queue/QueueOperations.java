/*
Here, we will learn operations on queues.

Given N integers, the task is to insert those elements in the queue. Also, given M integers, task is to find the frequency of each number in the Queue.

Example:

Input:
8
1 2 3 4 5 2 3 1
5
1 3 2 9 10

Output:
2
2
2
-1
-1

Explanation:
After inserting 1, 2, 3, 4, 5, 2, 3, 1 into the queue, 
frequency of 1 is 2, 3 is 2, 2 is 2, 9 is -1 and 10 is 
-1 (since, 9 and 10 is not there in the queue).
Your Task:
Your task is to complete the functions insert() and findFrequency() which inserts the element into the queue and find the count of occurences of element in the queue respectively.

Constraints:
1 <= N <= 103
1 <= M <= 103
1 <= Elements of Queue <= 106

######################################################################Solution#######################################################################################
*/
class Geeks{
    
    // Function to insert element into the queue
    static void insert(Queue<Integer> q, int k){
        
        // Your code here
        q.add(k);
    }
    
    // Function to find frequency of an element
    // rteturn the frequency of k
    static int findFrequency(Queue<Integer> q, int k){
        
        // Your code here
        int count=0;
        Iterator<Integer> itr = q.iterator();
        while(itr.hasNext()){
            if(itr.next()==k){
                count++;
            }
        }
        return count;
    }
    
}
