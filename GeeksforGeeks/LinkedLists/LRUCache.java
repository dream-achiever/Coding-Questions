/*
The task is to design and implement methods of an LRU cache. The class has two methods get() and set() which are defined as follows.
get(x)   : Returns the value of the key x if the key exists in the cache otherwise returns -1.
set(x,y) : inserts the value if the key x is not already present. If the cache reaches its capacity it should invalidate the least recently used item before inserting the new item.
In the constructor of the class the size of the cache should be intitialized.

Example 1:

Input:
N = 2
Q = 2
Queries = SET 1 2 GET 1
Output: 2
Explanation: Cache Size = 2
SET 1 2 GET 1
SET 1 2 : 1 -> 2
GET 1 : Print the value corresponding
to Key 1, ie 2.
Example 2:

Input:
N = 2
Q = 7
Queries = SET 1 2 SET 2 3 SET 1 5
SET 4 5 SET 6 7 GET 4 GET 1
Output: 5 -1
Explanation: Cache Size = 2
SET 1 2 SET 2 3 SET 1 5 SET 4 5
SET 6 7 GET 4 GET 1
SET 1 2 : 1 -> 2
SET 2 3 : 1 -> 2, 2 -> 3 (the most
recently used one is kept at the
rightmost position) 
SET 1 5 : 2 -> 3, 1 -> 5
SET 4 5 : 1 -> 5, 4 -> 5 (Cache size
is 2, hence we delete the least
recently used key-value pair)
SET 6 7 : 4 -> 5, 6 -> 7 
GET 4 : Prints 5
GET 1 : No key-value pair having
key = 1. Hence prints -1.
Your Task:
You only need to complete the provided functions get() and set(). 

Expected Time Complexity: O(1) for both get() and set().
Expected Auxiliary Space: O(1) for both get() and set(). (though, you may use extra space for cache storage and implementation purposes).

Constraints:
1 <= N <= 1000
1 <= Q <= 100000
1 <= x, y <= 1000

#########################################################################Solution###################################################################################
*/
class Node {
    
    int key;
    int value;
    Node next;
    Node prev;
    
    Node(int key, int value){
        this.key = key;
        this.value = value;
    }
    // @Override
    // public String toString(){
    //     return String.valueOf(value);
    // }
}

class LRUCache
{
    static int cap;
    static Map<Integer,Node> cache;
    static Node head;
    static Node tail;
    LRUCache(int cap)
    {
        // Intialize the cache capacity with the given
        // cap
        this.cap=cap;
        cache= new HashMap<>(cap);
        head=null;
        tail=null;
    }

    // This method works in O(1)
    public static int get(int key)
    {
        // your code here
        if(cache.containsKey(key))
        {
            Node node = cache.get(key);
            moveToFront(node);
            return node.value;
        }
        return -1;
    }

    // This method works in O(1)
    public static void set(int key, int value)
    {
        // your code here
        if(cache.containsKey(key))
        {
            Node node = cache.get(key);
            node.value=value;
            moveToFront(node);
            return;
        }
        Node node = new Node(key,value);
        
        if(cache.size()==cap){
            cache.remove(tail.key);
            removeNode(tail);
        }
        addToFirst(node);
        cache.put(key,node);
    }
    public static void moveToFront(Node node){
        removeNode(node);
        addToFirst(node);
    }
    public static void removeNode(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;
        
        if(prevNode!=null){
            prevNode.next=nextNode;
        }
        else {
            head=nextNode;
        }
        
        if(nextNode!=null){
            nextNode.prev = prevNode;
        }
        else {
            tail=prevNode;
        }
    }
    public static void addToFirst(Node node){
        node.next = head;
        node.prev = null;
        
        if(head!=null){
            head.prev=node;
        }
        head=node;
        if(tail==null){
            tail=node;
        }
        
    }
}
