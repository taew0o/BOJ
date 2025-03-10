import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        final int MAX = 1_000_000_000;

        int[][] dp = new int[K][N + 1];

        Arrays.fill(dp[0], 1);
        for(int i = 0 ; i < K ; i++){
            dp[i][0] = 1;
        }

        for(int i = 1 ; i < K ; i++){
            for(int j = 1 ; j <= N ; j++){
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MAX;
            }
        }

        System.out.println(dp[K - 1][N]);
    }
}
