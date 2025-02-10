import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N][M];
        for(int i = 0 ; i < N ; i++){
            dp[i][0] = 1;
        }
        for(int j = 0 ; j < M ; j++){
            dp[0][j] = 1;
        }
        for(int i = 1 ; i < N ; i++){
            for(int j = 1 ; j < M ; j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        if(K == 0){
            System.out.println(dp[N - 1][M - 1]);
        }
        else{
            int n = (K - 1) / M, m = (K - 1) % M;
            System.out.println(dp[n][m] * dp[N - n - 1][M - m - 1]);
        }

    }
}
