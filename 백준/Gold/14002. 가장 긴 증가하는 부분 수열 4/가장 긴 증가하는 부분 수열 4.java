import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] dp = new int[N];
        int[] parent = new int[N];
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);
        int max = 1, start = 0;
        for(int i = 1 ; i < N ; i++){
            for(int j = 0 ; j < i ; j++){
                if(arr[j] < arr[i] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if(max < dp[i]){
                max = dp[i];
                start = i;
            }
        }

        int now = start;
        while (now != -1){
            sb.insert(0, arr[now] + " ");
            now = parent[now];
        }
        sb.insert(0, max + "\n");
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
