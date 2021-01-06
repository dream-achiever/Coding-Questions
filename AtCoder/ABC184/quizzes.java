// Problem: B - Quizzes
// Contest: AtCoder - AtCoder Beginner Contest 184
// URL: https://atcoder.jp/contests/abc184/tasks/abc184_b
// Memory Limit: 1024 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)

import java.io.*;
import java.util.*;

class Main{
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		String s = br.readLine();
		for(int i=0;i<n;i++){
			if(s.charAt(i)=='o'){
				x+=1;
			}
			else{
				if(x!=0){
					x-=1;
				}
			}
		}
		System.out.println(x);
	}
}
