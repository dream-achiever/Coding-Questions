/*
Complete the function to find spiral order traversal of a tree. For below tree, function should return 1, 2, 3, 4, 5, 6, 7.


 
 

Example 1:

Input:
      1
    /   \
   3     2
Output:1 3 2

Example 2:

Input:
           10
         /     \
        20     30
      /    \
    40     60
Output: 10 20 30 60 40 
Your Task:
The task is to complete the function findSpiral() which returns the elements in spiral form of level order traversal as a list. The newline is automatically appended by the driver code.
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
0 <= Number of nodes <= 105
1 <= Data of a node <= 105
##################################################################################Solution##########################################################################
*/
class Spiral
{
      ArrayList<Integer> findSpiral(Node node) 
      {
           // Your code here
           Stack<Node> s1 = new Stack<>();
           Stack<Node> s2 = new Stack<>();
           ArrayList<Integer>arr = new ArrayList<>();
           s1.push(node);
           while(!s1.isEmpty() || !s2.isEmpty()){
                while(!s1.isEmpty()){
                    Node curr = s1.pop();
                    if(curr==null){
                        break;
                    }
                    else {
                        arr.add(curr.data);
                    }
                    if(curr.right!=null){
                        s2.push(curr.right);
                    }
                    if(curr.left!=null){
                        s2.push(curr.left);
                    }
                }
                while(!s2.isEmpty()){
                    Node curr = s2.pop();
                    if(curr==null){
                        break;
                    }
                    else {
                        arr.add(curr.data);
                    }
                    if(curr.left!=null){
                        s1.push(curr.left);
                    }
                    if(curr.right!=null){
                        s1.push(curr.right);
                    }
                }
           }
           return arr;
      }
}
