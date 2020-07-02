/*
Given two arrays A and B of size N and M respectively. The task is to find union between these two arrays.
Union of the two arrays can be defined as the set containing distinct elements from both the arrays. If there are repetitions, then only one occurrence of element should be printed in union.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consist of three lines. The first line of each test case contains two space separated integers N and M, where N is the size of array A and M is the size of array B. The second line of each test case contains N space separated integers denoting elements of array A. The third line of each test case contains M space separated integers denoting elements of array B.

Output:
Correspoding to each test case, print the count of union elements of the two arrays.

Expected Time Complexity: O(N + M).
Expected Auxiliary Space: O(N + M).

Constraints:
1 ≤ T ≤ 100
1 ≤ N, M ≤ 105
1 ≤ A[i], B[i] < 105

Example:
Input:
2
5 3
1 2 3 4 5
1 2 3
6 2
85 25 1 32 54 6
85 2
Output:
5
7

Explanation:
Testcase 1: 1, 2, 3, 4 and 5 are the elements which comes in the union set of both arrays.
Testcase 2: 1 , 2 , 6 , 25 , 32 , 54 and 85 are the elements which comes in the union set of both arrays.
######################################################################Solution######################################################################################
*/
class GFG {
	public static void main (String[] args) throws Exception {
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-->0){
		    String sizes[] = br.readLine().trim().split(" ");
		    int N = Integer.parseInt(sizes[0]);
		    int M = Integer.parseInt(sizes[1]);
		    
		    //int arr1[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		    //System.out.println(Arrays.toString(arr1));
		    //int arr2[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		    //System.out.println(Arrays.toString(arr2));
		    //GFG.union(arr1,N,arr2,M);
		    
		    HashSet<Integer> arr1 = new HashSet<>();
		    String input1[] = br.readLine().trim().split(" ");
		    for(int i=0;i<N;i++){
		        int value = Integer.parseInt(input1[i]);
		        if(!arr1.contains(value)){
		            arr1.add(value);   
		        }
		    }
		    HashSet<Integer> arr2 = new HashSet<>();
		    String input2[] = br.readLine().trim().split(" ");
		    for(int i=0;i<M;i++){
		        int value = Integer.parseInt(input2[i]);
		        if(!arr2.contains(value)){
		            arr2.add(value);   
		        }
		    }
		    int count = arr1.size();
		    Iterator<Integer> itr = arr2.iterator();
		    while(itr.hasNext()){
		        int value = itr.next();
	            if(!arr1.contains(value)){
	                count++;   
	            }
		    }
		    System.out.println(count);
		}
	}
}
