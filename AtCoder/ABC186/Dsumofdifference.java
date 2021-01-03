import java.io.*;
import java.util.*;

class Main{

public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int arr[] = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    Arrays.sort(arr);
    long sum=0;
    for(int i=0;i<n-1;i++){
        sum+=(long)(arr[i+1]-arr[i])*(n-1-i)*(i+1);
    }
    System.out.println(sum);
}

}
