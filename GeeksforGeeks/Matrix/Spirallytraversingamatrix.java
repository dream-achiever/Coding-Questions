/*
Given a matrix mat[][] of size M*N. Traverse and print the matrix in spiral form.

Input:
The first line of the input contains a single integer T, denoting the number of test cases. Then T test cases follow. Each testcase has 2 lines. First line contains M and N respectively separated by a space. Second line contains M*N values separated by spaces.

Output:
Elements when travelled in Spiral form, will be displayed in a single line.

Your Task:
This is a function problem. You only need to complete the function spirallyTraverse that takes m, n, and matrix as parameters and prints the spiral traversal. The driver code automatically appends a new line.

Constraints:
1 <= T <= 100
2 <= M, N <= 100
0 <= Ai <= 100

Example:
Input:
2
4 4
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
3 4
1 2 3 4 5 6 7 8 9 10 11 12
Output:
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
1 2 3 4 8 12 11 10 9 5 6 7

Explanation:
Testcase 1:


Testcase 2: Applying same technique as shown above , output for the 2nd testcase will be 1 2 3 4 8 12 11 10 9 5 6 7.
#################################################Solution######################################################################
*/
class Traverse
{
    //Complete this function
    static void spirallyTraverse(int m, int n, int arr1[][])
    {
       //Your code here
       int row_start=0, col_start=0, row_end=m-1,col_end=n-1;
       
       while(row_start<=row_end && col_start<=col_end){
           
           int row=row_start;
           int col=col_start;
           
           for(;col<=col_end;col++){
               System.out.print(arr1[row][col]+" ");
           }
           
           col--;
           row++;
           
           for(;row<=row_end;row++){
               System.out.print(arr1[row][col]+" ");
           }
           
           row--;
           col--;
           
            for(;col>=col_start && row>row_start;col--){
               System.out.print(arr1[row][col]+" ");
           }
           
           col++;
           row--;
           
            for(;row>row_start && col<col_end;row--){
               System.out.print(arr1[row][col]+" ");
           }
           
           row_start++;
           col_start++;
           
           row_end--;
           col_end--;
       }
    }
}
