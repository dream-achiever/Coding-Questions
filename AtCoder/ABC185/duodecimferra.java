// Problem: C - Duodecim Ferra
// Contest: AtCoder - AtCoder Beginner Contest 185
// URL: https://atcoder.jp/contests/abc185/tasks/abc185_c
// Memory Limit: 1024 MB
// Time Limit: 2000 ms
// Powered by CP Editor (https://github.com/cpeditor/cpeditor)
import java.io.*;
import java.util.*;
class Main{
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long l = Integer.parseInt(br.readLine());
		long t = l-1;
		long ans = 1;
		for(long i=0;i<11;i++){
			ans *=(t-i);
			ans/=(i+1);
		}
		System.out.println(ans);
	}
}
