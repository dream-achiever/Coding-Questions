/*
Given a Linked List Representation of Complete Binary Tree. The task is to construct the Binary tree.
Note : The complete binary tree is represented as a linked list in a way where if root node is stored at position i, its left, and right children are stored at position 2*i+1, 2*i+2 respectively.
 



Example 1:

Input:
N = 5
K = 1->2->3->4->5
Output: 1 2 3 4 5
Explanation: The tree would look like
      1
    /   \
   2     3
 /  \
4   5
Now, the level order traversal of
the above tree is 1 2 3 4 5.
Example 2:

Input:
N = 5
K = 5->4->3->2->1
Output: 5 4 3 2 1
Explanation: The tree would look like
     5
   /  \
  4    3
 / \
2    1
Now, the level order traversal of
the above tree is 5 4 3 2 1.
Your Task:
The task is to complete the function convert() which takes head of linked list and root of the tree as the reference. The driver code prints the level order.

Constraints:
1 <= N <= 103
1 <= Ki <= 103
###########################################################################Solution#################################################################################
*/
class GfG {
    public static Tree convert(Node head, Tree node) {
        // add code here.
        if(head == null){
            return null;
        }
        node = new Tree(head.data);
        Queue<Tree> q= new LinkedList<>();
        q.add(node);
        head = head.next;
        while(head!=null){
            Tree t = q.poll();
            t.left = new Tree(head.data);
            q.add(t.left);
            head=head.next;
            if(head == null){
                return node;
            }
            t.right = new Tree(head.data);
            q.add(t.right);
            head=head.next;
        }
        return node;
    }
    
}
