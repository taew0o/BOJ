import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        final int R = 0, G = 1, B = 2;
        int[][] price = new int[N][3];
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                price[i][j] = Integer.parseInt(temp[j]);
            }
        }
        int[][] orders = {{R,G},{R,B},{G,B},{G,R},{B,R},{B,G}}; //첫집과 마지막 집의 칠할 색깔
        int result = Integer.MAX_VALUE;
        for(int[] order : orders){
            int[][] dp =  new int[N][3];
            Arrays.fill(dp[0], 10_000_000);
            dp[0][order[0]] = price[0][order[0]];
            for(int i = 1; i < N - 1; i++){
                dp[i][R] = price[i][R] + Math.min(dp[i - 1][G], dp[i - 1][B]);
                dp[i][G] = price[i][G] + Math.min(dp[i - 1][B], dp[i - 1][R]);
                dp[i][B] = price[i][B] + Math.min(dp[i - 1][R], dp[i - 1][G]);
            }
            int current = 10_000_000;
            switch (order[1]){
                case R:
                    current = price[N - 1][R] + Math.min(dp[N - 2][G], dp[N - 2][B]);
                    break;
                case G:
                    current = price[N - 1][G] + Math.min(dp[N - 2][B], dp[N - 2][R]);
                    break;
                case B:
                    current = price[N - 1][B] + Math.min(dp[N - 2][R], dp[N - 2][G]);
                    break;
            }
            result = Math.min(result, current);
        }
        System.out.println(result);
    }
}
