import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        final int MAX = 1_000_000_000;

        int[][] dp = new int[N + 1][10];
        for(int i = 1 ; i < 10 ; i++){
            dp[1][i] = 1;
        }

        for(int i = 2 ; i <= N ; i++){
            dp[i][0] = dp[i - 1][1];
            for(int j = 1 ; j < 9 ; j++){
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MAX;
            }
            dp[i][9] = dp[i - 1][8];
        }

        int result = 0;
        for(int i = 0 ; i < 10 ; i++){
            result = (result + dp[N][i]) % MAX;
        }
        System.out.println(result);
    }
}
