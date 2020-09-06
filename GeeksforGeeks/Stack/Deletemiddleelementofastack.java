/*
Given a stack with push(), pop(), empty() operations, delete the middle of it without using any additional data structure.
Middle: ceil(size_of_stack/2.0)
 

Example 1:

Input: 
sizeOfStack = 5
stack = [1 2 3 4 5]
Output:
modifiedStack = [1 2 4 5]
Explanation:
As the number of elements is 5 , 
hence the middle element will be the 3rd
element which is deleted
Example 2:

Input: 
sizeOfStack = 4
stack = [1 2 3 4]
Output:
modifiedStack = [1 3 4]
Explanation:
As the number of elements is 4 , 
hence the middle element will be the 2nd
​element which is deleted
 

Your Task:
This is a function problem. The input is already taken by the driver code. You only need to complete the function deleteMid() which takes 3 arguments(stack, size of the stack, and current index - initially 0) and returns the modified stack.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= sizeOfStack <= 100

Note: The output on the console is printed in reverse order of elements in the modified stack.
##########################################################################################Solution##################################################################
*/
class Geeks
{
    //Complete this function
    public Stack<Integer> deleteMid(Stack<Integer>s,int sizeOfStack,int current)
    {
        //Your code here
        if(s.isEmpty()){
            return s;
        }
        int mid = (int)Math.ceil((double)sizeOfStack/2.0);
        if(sizeOfStack%2==0){
            mid=mid+1;
        }
        Stack<Integer> as = new Stack<>();
        for(int i=0;i<mid-1;i++){
            int x = s.pop();
            as.push(x);
        }
        s.pop();
        while(!as.isEmpty()){
            int x=as.pop();
            s.push(x);
        }
        return s;
    } 
}
