/*
Given a string S such that it may contain repeated lowercase alphabets. Rearrange the characters in the string such that no two adjacent characters are same.
 

Example 1:

Input:
S = geeksforgeeks
Output: 1
Explanation: egeskerskegof can be one way of
rearranging the letters.

Example 2:

Input:
S = bbbabaaacd
Output: 1
Explanation: abababdcab can be one way of 
rearranging the letters.

Your Task:
You do not need to read input or print anything. Complete the function rearrangeString() which takes string S as input parameter and returns the string after rearrangement.
If the characters are successfully rearranged then the generated output will be 1 else 0.


Expected Time Complexity : O(n log n)
Expected Auxilliary Space : O(n)


Constraints:
1 <= length of string <= 104
String has only lowercase English alphabets.
######################################################################Solution######################################################################################
*/
class Pair implements Comparable<Pair> {
    char k;
    int v;
    Pair(char key, int value) {
        k=key;
        v=value;
    }
    public int compareTo(Pair p){
        if(this.v <= p.v){
            return -1;
        }
        else{
            return 1;   
        }
    }
}


class Solution
{
    //Function to rearrange the characters in a string such that 
    //no two adjacent characters are same.
    static boolean rearrangeCharacters(String str)
    {
		// Your code here
		PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		
		TreeMap<Character,Integer> tm = new TreeMap<>(Collections.reverseOrder());
		int slen = str.length();
		for(int i=0;i<slen;i++){
		    if(tm.containsKey(str.charAt(i))){
		        tm.put(str.charAt(i),tm.get(str.charAt(i))+1);
		    }
		    else {
		        tm.put(str.charAt(i),1);
		    }
		}
		for(Map.Entry<Character,Integer> entry: tm.entrySet()){
		    maxHeap.add(new Pair((char)entry.getKey(),(int)entry.getValue()));
		}
		Pair temp = new Pair('#',-1);
		StringBuffer sb = new StringBuffer();
		while(!maxHeap.isEmpty()){
		    Pair m = maxHeap.poll();
		    Pair curr = new Pair(m.k,m.v);
		    sb.append(curr.k);
		    curr.v--;
		    if(temp.v>0){
		        maxHeap.add(temp);
		    }
		    temp=curr;
		    
		}
		String s = sb.toString();
		
		if(str.length()==s.length()){
		    return true;
		}
		return false ;
	}
}
