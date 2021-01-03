import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ip[]= Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int h = ip[0];
        int w = ip[1];
        
        int arr[][] = new int[h][w];
        for(int i=0;i<h;i++){
            arr[i]=Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                min = Math.min(min,arr[i][j]);
            }
        }

        int count=0;

        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                int diff = arr[i][j] - min;
                if(diff>0){
                    count+=diff;
                }
            }
        }
        System.out.println(count);

    }
}
