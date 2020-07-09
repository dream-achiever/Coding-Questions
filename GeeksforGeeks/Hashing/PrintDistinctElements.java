/*
Hashing is very useful to keep track of the frequency of the elements in a list.

You are given an array arr of size n. You need to print the distinct elements as they appear in the array.

Input:
The first line of input contains T denoting the number of testcases. T testcases follow. Each testcase contains two lines of input. The first line contains n denoting the size of the array. The second line contains n elements of the array.

Output:
For each testcase, in a new line, print the distinct elements in the order they appear in the array.

Constraints:
1 <= T <= 100
1 <= n <= 103
0 <= arri <= 107

Examples:
Input:
1
10
1 1 2 2 3 3 4 5 6 7
Output:
4 5 6 7
#######################################################################Solution#####################################################################################
*/
class GFG {
	public static void main (String[] args) throws Exception {
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-->0){
		    int size = Integer.parseInt(br.readLine());
		    LinkedHashMap<Integer,Integer> hs = new LinkedHashMap<>();
		    int arr[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		    for(int i=0;i<size;i++){
		        hs.put(arr[i],null);
		    }
		    
		    for(int i=0;i<size;i++){
		        Integer c = hs.get(arr[i]);
		        if(c==null){
		            hs.put(arr[i],1);
		        }
		        else {
		            hs.put(arr[i],c+1);
		        }
		    }
		    
		    Iterator<Map.Entry<Integer,Integer>> itr = hs.entrySet().iterator();
		    while(itr.hasNext()){
		        Map.Entry<Integer,Integer> pair = itr.next();
		        int key = pair.getKey();
		        int value = pair.getValue();
		        if(value==1){
		            System.out.print(key+" ");
		        }
		    }
		    System.out.println();
		}
	}
}
