/*
Given two sorted arrays arr[] and brr[] of sizes N and M respectively. The task is to find the median of the two arrays when they get merged.

Input:
First line of input contains number of testcases T. First line of input contains number of elements in both arrays N and M respectively. Next two lines contains the array elements.

Output:
For each testcase, print the median of two sorted arrays. If there are total even elements, we need to print floor of average of middle two elements.

Expected Time Complexity: O(Log (min (N, M))).
Expected Auxiliary Space: O(1).

Constraints:
1 <= T <= 100
1 <= N, M <= 106
1 <= arr[i], brr[i] <= 107

Example:
Input:
4
5 6
1 2 3 4 5
3 4 5 6 7 8
2 3
1 2
2 3 4
4 4
1 2 3 4
11 12 13 14
4 3
1 2 3 4
2 3 4

Output:
4
2
7
3

Explanation:
Testcase 1: After merging two arrays, elements will be as 1 2 3 3 4 4 5 5 6 7 8. So, median is 4.
Testcase 2: After merging two arrays , elements will be 1 2 2 3 4. So, the median is 2.
Testcase 3: After merging two arrays , elemenst will be 1 2 3 4 11 12 13 14 . So the median will be floor of average of middle terms i.e, 7.
Testcase 4: After merging two arrays, elements will be 1 2 2 3 3 4 4. So, the median will be 3.
###############################################################################Solution#############################################################################
*/
class GFG {
    
    public static void median(int arr[],int asize,int brr[],int bsize){
        int size = asize+bsize;
        int[] temp = new int[size];
        
        int low = 0;
        int high = size-1;
        
        int i=0,j=0,k=low;
        
        while(i<asize && j<bsize){
            if(arr[i]<brr[j]){
                temp[k]=arr[i];
                i++;
            }
            else{
                temp[k]=brr[j];
                j++;
            }
            k++;
        }
        while(i<asize){
            temp[k]=arr[i];
            i++;
            k++;
        }
        while(j<bsize){
            temp[k]=brr[j];
            j++;
            k++;
        }
        // for(i=0;i<size;i++){
        //     System.out.print(temp[i]+" ");
        // }
        low=0;
        high=size-1;
        int mid = (low+high)/2;
        if(size%2==0){
            System.out.print((temp[mid]+temp[mid+1])/2);
        }
        else {
            System.out.print(temp[mid]);
        }
    }
    
	public static void main (String[] args) throws IOException {
		//code
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine().trim());
		while(test-->0){
		    String inputLine1[] = br.readLine().trim().split(" ");
		    int asize = Integer.parseInt(inputLine1[0]);
		    int bsize = Integer.parseInt(inputLine1[1]);
		    
		    int[] arr = new int[asize];
		    int [] brr = new int[bsize];
		    String inputLine2[] = br.readLine().trim().split(" ");
		    String inputLine3[] = br.readLine().trim().split(" ");
		    for(int i=0;i<asize;i++){
		        arr[i] = Integer.parseInt(inputLine2[i]);
		    }
		    for(int i=0;i<bsize;i++){
		        brr[i] = Integer.parseInt(inputLine3[i]);
		    }
		    
		    GFG.median(arr,asize,brr,bsize);
		    System.out.println();
		}
	}
}
