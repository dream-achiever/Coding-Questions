/*
Given two arrays A and B of equal size, the task is to find if given arrays are equal or not. Two arrays are said to be equal if both of them contain same set of elements, arrangements (or permutation) of elements may be different though.
Note : If there are repetitions, then counts of repeated elements must also be same for two array to be equal.

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow.  Each test case contains 3 lines of input. The first line contains an integer N denoting the size of the array. The second line contains element of array A[]. The third line contains elements of the array B[].

Output:
For each test case, print 1 if the arrays are equal else print 0.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N). 

Constraints:
1 <= T <= 100
1 <= N <= 107
1 <= A[],B[] <= 1018

Example:
Input:
2
5
1 2 5 4 0
2 4 5 0 1
3
1 2 5
2 4 15
Output:
1
0

Explanation:
Testcase1:
Input : A[] = {1, 2, 5, 4, 0}; B[] = {2, 4, 5, 0, 1}; Since all the array elements are same. So,
Output : 1
Testcase2:
Input : A[] = {1, 2, 5}; B[] = {2, 4, 15}; Since all the array elements are not same. So,
Output : 0

#####################################################################################Solution#######################################################################
*/
class GFG {
	public static void main (String[] args) throws Exception {
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-->0){
		    int N = Integer.parseInt(br.readLine());
		    String input1 [] = br.readLine().trim().split("\\s+");
		    LinkedHashMap<Long,Long> array1 = new LinkedHashMap<>();
		    for(int i=0;i<N;i++){
		        long key = Long.parseLong(input1[i]);
		        Long c = array1.get(key);
		        if(c==null){
		           array1.put(key,(long)1); 
		        }
		        else {
		            array1.put(key,(long)c+1);
		        }
		    }
		    String input2 [] = br.readLine().trim().split("\\s+");
		    for(int i=0;i<N;i++){
		        long key = Long.parseLong(input2[i]);
		        if(array1.containsKey(key)){
		            long freq = array1.get(key);
		           array1.put(key,freq-1); 
		        }
		    }
		    Iterator<Map.Entry<Long,Long>> itr = array1.entrySet().iterator();
		    int flag =0;
		    while(itr.hasNext()){
		        Map.Entry<Long,Long> pair =  itr.next();
		        long v1 = pair.getValue();
		        if(v1!=0){
		            flag=1;
		            System.out.println("0");
		            break;
		        }
		    }
		    if(flag==0){
		     System.out.println("1");   
		    }
		}
	}
}
