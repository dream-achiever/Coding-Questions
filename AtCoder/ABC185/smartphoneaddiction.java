import java.util.*;
import java.io.*;

class Main{

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().trim().split("\\s+");
		int cap = Integer.parseInt(s[0]);
		int test = Integer.parseInt(s[1]);
		int finishtime = Integer.parseInt(s[2]);
		int prevcafe = 0;
		boolean impossible=false;
		int chargestatus = cap;
		for(int i=0;i<test;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int diff = a-prevcafe;
			chargestatus-=diff;
			if(chargestatus<=0){
				impossible = true;
			}
			chargestatus+=b-a;
			chargestatus = Math.min(cap,chargestatus);
			prevcafe = b;
		}
		chargestatus-=finishtime-prevcafe;
		if(chargestatus<=0){
				impossible = true;
			}
		if(impossible==true){
			System.out.println("No");
		}
		else {
			System.out.println("Yes");
		}
	}
}
