/*
Given an integer array. The task is to find the first repeating element in the array i.e., an element that occurs more than once and whose index of first occurrence is smallest.

Input :
The first line contains an integer T denoting the total number of test cases. In each test cases, First line is number of elements in array N and second line contains N space separated integer values of the array.

Output:
In each separate line print the index of first repeating element, if there is not any repeating element then print “-1” (without quotes). Use 1 Based Indexing. 

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= T <= 500
1 <= N <= 106
0 <= Ai <= 106

Example:
Input:
3
7
1 5 3 4 3 5 6
4
1 2 3 4
5
1 2 2 1 3
Output:
2
-1
1

Explanation: 
Testcase 1: 5 is appearing twice and its first appearence is at index 2 which is less than 3 whose first occuring index is 3.
Testcase 2: None of the elements are occuring twice . So, the answer is -1.
Testcase 3: 1 is appearing twice and its first appearence is at index 1 which is less than 2 whose first occuring is at index 2.
##########################################################################Solution##################################################################################
*/
class GFG {
    
    public static int firstRepeated(int arr[], int n){
        LinkedHashMap<Integer, Integer> hm = new LinkedHashMap<>();
        
        for(int i=0;i<n;i++){
            hm.put(arr[i],null);
        }
        
        for(int i=0;i<n;i++){
            Integer c = hm.get(arr[i]);
            if(c==null){
                hm.put(arr[i],1);
            }
            else {
                hm.put(arr[i],c+1);
            }
        }
        Iterator<Map.Entry<Integer,Integer>> itr = hm.entrySet().iterator();
        int i=0;
        while(itr.hasNext()){
            Map.Entry<Integer,Integer> pair = itr.next();
            if(pair.getValue()>1){
                return i+1;
            }
            i++;
        }
        return 0;
    }
    
	public static void main (String[] args) throws IOException {
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-->0){
		    int size = Integer.parseInt(br.readLine());
		    int arr[] = new int[size];
		    String line = br.readLine();
		    String elements[] = line.trim().split("\\s+");
		    for(int i=0;i<size;i++){
		        arr[i]=Integer.parseInt(elements[i]);
		    }
		    int value = GFG.firstRepeated(arr,size);
		    if(value!=0){
		        System.out.println(value);
		    }
		    else {
		        System.out.println("-1");
		    }
		}
	}
}
