import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int MOD = 1_000_000_007;

        boolean[][] isAvailable = new boolean[N + 1][M + 2];
        int[][] dp = new int[N + 1][M + 2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                isAvailable[i][j] = st.nextToken().equals("1");
            }
        }

        for(int i = 1 ; i <= M ; i++){
            dp[1][i] = isAvailable[1][i] ? 1 : 0;
        }

        for(int i = 2 ; i <= N ; i++){
            for(int j = 1 ; j <= M ; j++){
                if(isAvailable[i][j]){
                    dp[i][j] = ((dp[i - 1][j - 1] + dp[i - 1][j]) % MOD + dp[i - 1][j + 1]) % MOD;
                }
            }
        }

        long result = 0;
        for(long num : dp[N]){
            result += num;
            result %= MOD;
        }
        System.out.println(result);
    }
}
