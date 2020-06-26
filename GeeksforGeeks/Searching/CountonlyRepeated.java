/*
Given an array of positive integers, where elements are consecutive (sorted). Also, there is a single element which is repeating X (any variable) number of times. Now, the task is to find the element which is repeated and number of times it is repeated.

Input:
First line of input contains number of testcases T. For each testcase, first line of input contains number of elements in the array N. Next line contains the array elements.

Output:
For each testcase, there will be a single line containing the element which is repeated and the number of times it is repeated, seperated by space.

Expected Time Complexity: O(LogN).
Expected Auxiliary Space: O(1). 

Constraints:
1 <= T <= 100
1 <= N <= 107
1 <= arr[i] <= 1015

Input:
2
5
1 2 3 3 4
5
2 3 4 5 5

Output:
3 2
5 2

Example:
Testcase 1: In the given array, 3 is occuring two times.So the output is 3 2.
Testcase 2: In the given array, 5 is occuring two times.So the output is 5 2.
###############################################################################Solution#############################################################################
*/
class GFG {
    
    public static void repeated(int[] arr, int size){
        int count = 1;
        int repeat = 0;
        for(int i=1;i<size;i++){
            if(arr[i]==arr[i-1]){
               count++;
               repeat = arr[i];
            }
        }
        System.out.print(repeat+" "+count);
    }
    
	public static void main (String[] args) throws IOException {
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-->0){
		    int size = Integer.parseInt(br.readLine());
		    int arr[] = new int[size];
		    String line = br.readLine();
		    String[] elements= line.trim().split("\\s+");
		    
		    for(int i=0;i<size;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    GFG.repeated(arr,size);
		    System.out.println();
		}
		
	}
}
