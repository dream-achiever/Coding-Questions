/*
Given two arrays A and B respectively of size N and M. The task is to print the count of elements in the intersection (or common elements) of the two arrays.
For this question, intersection of two arrays can be defined as the set containing distinct common elements between the two arrays.

Input:
The first line of input contains an integer T denoting the number of test cases. The first line of each test case is N and M, N is the size of array A and M is size of array B. The second line of each test case contains N input A[i].
The third line of each test case contains M input B[i].

Output:
Print the count of intersecting elements.

Constraints:
1 ≤ T ≤ 100
1 ≤ N, M ≤ 105
1 ≤ A[i], B[i] ≤ 105

Example:
Input:
4
5 3
89 24 75 11 23
89 2 4
6 5
1 2 3 4 5 6
3 4 5 6 7
4 4
10 10 10 10
20 20 20 20
3 3
10 10 10
10 10 10
Output:
1
4
0
1

Explanation:
Testcase 1: 89 is the only element in the intersection of two arrays.
Testcase 2: 3 4 5 and 6 are the elements in the intersection of two arrays.
Testcase 3: Non of the elements are common so the output will be -1.
Testcase 4: 10 is the only element which is in the intersection of two arrays.
#############################################################################Solution###############################################################################
*/
class GFG {
    
	public static void main (String[] args) throws IOException {
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine().trim());
		while(test-->0){
		    String sizes[] = br.readLine().trim().split(" ");
		    int size1 = Integer.parseInt(sizes[0]);
		    int size2 = Integer.parseInt(sizes[1]);
		    LinkedHashSet<Integer> array1 = new LinkedHashSet<>();
		    String inputline1[] = br.readLine().trim().split(" ");
		    for(int i=0;i<size1;i++){
		        int value = Integer.parseInt(inputline1[i]);
		        if(!array1.contains(value)){
		            array1.add(value);   
		        }
		    }
		    LinkedHashSet<Integer> array2 = new LinkedHashSet<>();
		    String inputline2[] = br.readLine().trim().split(" ");
		    int count=0;
		    for(int i=0;i<size2;i++){
		        int value = Integer.parseInt(inputline2[i]);
		        if(!array2.contains(value)){
		            array2.add(value);   
		        }
		    }
		  Iterator<Integer> itr = array2.iterator();
		  while(itr.hasNext()){
		      if(array1.contains(itr.next())){
		          count++;
		      }
		  }
		    System.out.println(count);
		}
	}
}
