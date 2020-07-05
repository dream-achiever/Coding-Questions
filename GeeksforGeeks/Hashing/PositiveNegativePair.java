/*
Given an array arr[] of N positive and negative integer pairs, may not be in sorted order. The task is to pair the positive and negative element in such a way that a positive element is paired with a negative element of same absolute value. If a pair element is not present for an element, then ignore it. The output should contain all pairs in increasing order of absolute values. To print a pair, positive value should be printed before its corresponding negative value.
Note: The elements in array are distinct.

Input:
First line of input contains number of testcases T. For each testcase, first line contains an integer N, number of elements in the array. Next line contains N space separated array elements.

Output:
For each testcase, print the pairs of positive and negative, sorted with positive numbers. If no such pair exists, print 0.

Constraints:
1 <= T <= 100
1 <= N <= 106
-106 <= arr[i] <= 106

Example:
Input:
2
8
1 3 6 -2 -1 -3 2 7
3
3 2 -3
Output:
1 -1 2 -2 3 -3
3 -3

Explanation:
Testcase 1: 1, 2 and 3 are present pairwirse postive and negative. 6 and 7 have no pair.
Testcase 2: 3 is the only element present pairwise positive and negative.
##########################################################################Solution##################################################################################
*/
class GFG {
	public static void main (String[] args) throws Exception {
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-->0){
		    int size = Integer.parseInt(br.readLine());
		    int arr[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		    LinkedHashSet<Integer> hs = new LinkedHashSet<>();
		    TreeSet<Integer> ss = new TreeSet<>();
		    for(int i=0;i<size;i++){
		        int value = arr[i];
		        int diff=0;
		        diff=0-value;
		        if(hs.contains(diff)){
		            if(diff>0){
		                ss.add(diff);
		            }
		            else {
		                ss.add(value);
		            }
		        }
		        else {
		            hs.add(value);
		        }
		    }
		    Iterator<Integer> itr = ss.iterator();
		    if(ss.size()>0){
    		    while(itr.hasNext()){
    		        int original = itr.next();
    		        int opp = -original;
    		        System.out.print(original+" "+ opp +" ");
    		    }
		    }
		    else {
		        System.out.print("0");
		    }
		  System.out.println();
		}
	}
}
