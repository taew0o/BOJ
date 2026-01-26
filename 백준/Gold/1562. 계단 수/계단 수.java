import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][][] dp = new int[N + 1][10][1024];
        int MOD = 1_000_000_000;
        for(int i = 1 ; i <= 9 ; i++){
            dp[1][i][1 << i] = 1;
        }
        for(int len = 2 ; len <= N ; len++){
            for(int i = 0 ; i <= 9 ; i++){
                for(int mask = 0 ; mask < 1024 ; mask++){
                    if(dp[len - 1][i][mask] == 0) continue;
                    if(i > 0){
                        int nextNumber = i - 1;
                        int nextMask = mask | (1 << nextNumber);
                        dp[len][nextNumber][nextMask] = (dp[len][nextNumber][nextMask] + dp[len - 1][i][mask]) % MOD;
                    }
                    if(i < 9){
                        int nextNumber = i + 1;
                        int nextMask = mask | (1 << nextNumber);
                        dp[len][nextNumber][nextMask] = (dp[len][nextNumber][nextMask] + dp[len - 1][i][mask]) % MOD;
                    }
                }
            }
        }
        int result = 0;
        for(int i = 0 ; i <= 9 ; i++){
            result = (result + dp[N][i][1023]) % MOD;
        }
        System.out.println(result);
    }
}
