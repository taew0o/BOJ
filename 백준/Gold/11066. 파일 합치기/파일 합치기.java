import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    public static int[][] dp;
    public static int[] sum;
    public static int DP(int left, int right){
        if(left == right){
            return (dp[left][right] = 0);
        }
        if(dp[left][right] != 0) return dp[left][right];
        dp[left][right] = Integer.MAX_VALUE;
        for(int i = left + 1 ; i <= right ; i++){
            dp[left][right] = Math.min(dp[left][right], DP(left, i - 1) + DP(i, right) + sum[right] - sum[left - 1]);
        }
        return dp[left][right];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T =  Integer.parseInt(br.readLine());
        while(T --> 0){
            N = Integer.parseInt(br.readLine());
            arr = new int[N + 1]; sum = new int[N + 1];
            dp = new int[N + 1][N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 1 ; i <= N ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i - 1] + arr[i];
            }
            sb.append(DP(1, N)).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
