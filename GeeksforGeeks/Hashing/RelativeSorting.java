/*
Given two arrays A1[] and A2[] of size N and M respectively. The task is to sort A1 in such a way that the relative order among the elements will be same as those in A2. For the elements not present in A2, append them at last in sorted order. It is also given that the number of elements in A2[] are smaller than or equal to number of elements in A1[] and A2[] has all distinct elements.
Note: Expected time complexity is O(N log(N)).

Input:
First line of input contains number of testcases. For each testcase, first line of input contains length of arrays N and M and next two line contains N and M elements respectively.

Output:
Print the relatively sorted array.

Constraints:
1 ≤ T ≤ 100
1 ≤ N,M  ≤ 106
1 ≤ A1[], A2[] <= 106

Example:
Input:
2
11 4
2 1 2 5 7 1 9 3 6 8 8
2 1 8 3
8 4
2 6 7 5 2 6 8 4 
2 6 4 5
Output:
2 2 1 1 8 8 3 5 6 7 9
2 2 6 6 4 5 7 8

Explanation:
Testcase 1: After sorting the resulted output is 2 2 1 1 8 8 3 5 6 7 9.
Testcase 2: After sorting the resulted output is 2 2 6 6 4 5 7 8.
######################################################################Solution######################################################################################
*/
class GFG {
    
	public static void main (String[] args) throws Exception{
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-->0){
		    int input[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		    int m = input[0];
		    int n = input[1];
		    int arr1 [] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		    int arr2 [] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		    
		    
		    TreeMap<Integer,Integer> hm = new TreeMap<>();
		    
		    int[] array = new int[m];
		    int k=0;
		    
		    for(int i=0;i<m;i++){
		        if(hm.containsKey(arr1[i])){
		            hm.put(arr1[i],hm.get(arr1[i])+1);
		        }
		        else {
		            hm.put(arr1[i],1);
		        }
		    }
		    
		    for(int i=0;i<n;i++){
		        if(hm.containsKey(arr2[i])){
		            int value = hm.get(arr2[i]);
		            while(value-->0 && k<m){
		                array[k]=arr2[i];
		                k++;
		            }
		            hm.remove(arr2[i]);
		        }
		    }
    	    
    	    Iterator<Map.Entry<Integer,Integer>> itr = hm.entrySet().iterator();
		    while(itr.hasNext()){
		        Map.Entry<Integer,Integer> pair = itr.next();
		        if(!Arrays.asList(array).contains(pair.getKey())){
		            int value = pair.getValue();
		            while(value-->0 && k<m){
		                array[k]=pair.getKey();
		                k++;
		            }
		        }
		    }
		    
		    for(int i=0;i<m;i++){
		        System.out.print(array[i]+" ");
		    }
    	    System.out.println();
    	    
		}
	}
}
