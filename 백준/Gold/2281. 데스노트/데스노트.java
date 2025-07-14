import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] dp;
    static int dp(int index){
        if(dp[index] != Integer.MAX_VALUE){
            return dp[index];
        }
        int remain = M - arr[index];
        for(int i = index + 1 ; i <= N && remain >= 0 ; i++){
            if(i == N){
                dp[index] = 0;
                break;
            }
            dp[index] = Math.min(dp[index] , remain * remain + dp(i));
            remain -= arr[i] + 1;
        }
        return dp[index];
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[N - 1] = 0;
        System.out.println(dp(0));
    }
}
