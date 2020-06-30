/*
Linear probing is a collision handling technique in hashing. Linear probing says that whenever a collision occurs, search for the immediate next position.

Given an array of integers and a hash table size. Fill the array elements into a hash table using Linear Probing to handle collisions.

Input:
The first line of input contains T denoting the number of testcases. T testcases follow. Each testcase contains 3 lines of input. The first line contains size of the hashtable. The second line contains size of the array. The third line contains elements of the array.

Output:
For each testcase, in a new line, print the hash table.

Your Task:
You don't need to read input or print anything. Your task is to complete the function linearProbing() which takes as input a empty hash table (hash), the hash table size (hashSize), an integers array arr[] and its size N and inserts all the elements of the array arr[] into the given hash table. The empty cells of the hash table are to be given a value of -1. Also, if there's no more space to insert a new element, just drop that element. 

Expected Time Complexity: O(N). 
Expected Auxiliary Space: O(1).

Constraints:
1 <= T <= 100
1 <= hashSize <= 100
1 <= sizeOfArray <= 100
0 <= Array[] <= 105

Examples:
Input:
2
10
4
4 14  24 44
10
4
9 99 999 9999
Output:
-1 -1 -1 -1 4 14 24 44 -1 -1
99 999 9999 -1 -1 -1 -1 -1 -1 9

Explanation:
Testcase1: 4%10=4. So put 4 in hashtable[4]. Now, 14%10=4, but hashtable[4] is already filled so put 14 in the next slot and so on.
Testcase2: 9%10=9. So put 9 in hashtable[9]. Now, 99%10=9, but hashtable[9] is already filled so put 99 in the (99+1)%10 =0 slot so 99 goes into hashtable[0] and so on.
#################################################################################Solution###########################################################################
*/
static int[] linearProbing( int hash_size, int arr[], int N)
{
    //Your code here
    int hash[] = new int[hash_size];
    for(int i=0;i<hash_size;i++){
        hash[i]=-1;
    }
    for(int i=0;i<N;i++){
        if(hash[arr[i]%hash_size]==-1){
           hash[arr[i]%hash_size] = arr[i]; 
        }
        else {
            int k=(arr[i]+1)%hash_size;
            int end = arr[i]%hash_size;
            while(k!=end){
                if(hash[k%hash_size]==-1){
                    hash[k] = arr[i];
                    break;
                }
                k++;
                k=k%hash_size;
            }
        }
    }
    return hash;
}
