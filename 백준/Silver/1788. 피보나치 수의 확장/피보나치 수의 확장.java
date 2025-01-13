import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        final int MOD = 1_000_000_000, len = 1_000_000;

        int[] dp = new int[2 * len + 1];
        dp[len + 1] = 1;
        for(int i = len + 2 ; i <= 2 * len ; i++){
            dp[i] = (dp[i - 2] + dp[i - 1]) % MOD;
        }
        for(int i = len - 1 ; i >= 0 ; i--){
            dp[i] = (dp[i + 2] - dp[i + 1]) % MOD;
        }
        System.out.println(Integer.compare(dp[len + N], 0));
        System.out.println(Math.abs(dp[len + N]));
    }
}
