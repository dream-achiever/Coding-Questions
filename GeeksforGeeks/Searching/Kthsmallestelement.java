/*
Given an array arr[] and a number K where K is smaller than size of array, the task is to find the Kth smallest element in the given array. It is given that all array elements are distinct.

Input:
The first line of input contains an integer T, denoting the number of testcases. Then T test cases follow. Each test case consists of three lines. First line of each testcase contains an integer N denoting size of the array. Second line contains N space separated integer denoting elements of the array. Third line of the test case contains an integer K.

Output:
Corresponding to each test case, print the kth smallest element in a new line.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).

Constraints:
1 <= T <= 100
1 <= N <= 105
1 <= arr[i] <= 105
1 <= K <= N

Example:
Input:
2
6
7 10 4 3 20 15
3
5
7 10 4 20 15
4
Output:
7
15

Explanation:
Testcase 1: 3rd smallest element in the given array is 7.
Testcase 2: 4th smallest elemets in the given array is 15.
############################################################################Solution################################################################################
*/
class GFG {
    
    public static void kSmallestElement(int arr[],int size,int k){
        
        int max = Integer.MIN_VALUE;
        for(int i=0;i<size;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        
        int list[] = new int[max+1];
        int count=1;
        for(int i=0;i<size;i++){
            list[arr[i]]+=count;
        }
        int sum=0;
        for(int i=0;i<max+1;i++){
            sum+=list[i];
            if(sum>=k){
                System.out.println(i);
                break;
            }
        }
    }
    
	public static void main (String[] args) throws IOException {
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-->0){
		    int size = Integer.parseInt(br.readLine());
		    int arr[] = new int[size];
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i=0;i<size;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    int k = Integer.parseInt(br.readLine());
		    GFG.kSmallestElement(arr,size,k);
		}
	}
}
