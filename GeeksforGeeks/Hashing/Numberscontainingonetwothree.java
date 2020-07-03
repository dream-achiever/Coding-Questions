/*
Given an array arr[] of N numbers. The task is to print only those numbers whose digits are from set {1,2,3}.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. First line of each test case contains an integer N and the second line contains N space separated array elements.

Output:
For each test case, In new line print the required elements in increasing order. if there is no such element present in the array print "-1".

Constraints:
1 <= T <= 100
1 <= N <= 106
1 <= A[i] <= 106

Example:
Input:
3
3
4 6 7
4
1 2 3 4
5
12 111 34 13 55
Output:
-1
1 2 3
12 13 111

Explanation:
Testcase 1: No elements are there in the array which contains digits 1, 2 or 3.
Testcase 2: 1, 2 and 3 are the only elements in the array which conatins digits as 1, 2 or 3.
Testcase 3: 12 , 13 and111 are the three elements in the array which contains digit as 1 , 2 or 3.
#################################################################################Solution###########################################################################
*/
class GFG {
	public static void main (String[] args) throws Exception {
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-->0){
		    int size = Integer.parseInt(br.readLine());
		    int arr[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		    
		    HashSet<Integer> hs = new HashSet<>();
		    hs.add(1);
		    hs.add(2);
		    hs.add(3);
		    ArrayList<Integer> ts = new ArrayList<>();
		    int flag=0;
		    for(int i=0;i<size;i++){
		        int temp = arr[i];
		        int num = arr[i];
		        int rem=0;
		        while(num>0){
		            rem = num%10;
		            if(hs.contains(rem)==true){
		                flag=1;
		            }
		            else {
		                flag=0;
		               break;
		            }
		            num=num/10;
		        }
		        if(flag==1){
		            ts.add(temp);
		        }
		    }
		    Collections.sort(ts);
		    Iterator<Integer> itr = ts.iterator();
		    if(ts.size()>0){
		        while(itr.hasNext()){
		            System.out.print(itr.next()+" ");
		        }
		        System.out.println();
		    }
		    else {
		        System.out.println("-1");
		    }
		}
	}
}
