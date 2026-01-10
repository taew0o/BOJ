import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] cost = new int[5][5];
        final int MAX = 400_000;
        for(int i = 0 ; i < 5 ; i++) cost[i][i] = 1;
        for(int i = 1 ; i < 5 ; i++) {
            cost[0][i] = 2;
            cost[i][0] = 2;
        }
        for(int i = 0 ; i < 4 ; i++){
            cost[i + 1][(i + 1) % 4 + 1] = 3;
            cost[i + 1][(i + 3) % 4 + 1] = 3;
            cost[i + 1][(i + 2) % 4 + 1] = 4;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = st.countTokens();
        int[] dirs = new int[N];
        for(int i = 1 ; i < N ; i++){
            dirs[i] = Integer.parseInt(st.nextToken());
        }
        int[][][] dp = new int[5][5][N];
        for(int i = 0 ; i < 5 ; i++){
            for(int j = 0 ; j < 5 ; j++){
                Arrays.fill(dp[i][j], MAX);
            }
        }

        dp[0][0][0] = 0;
        for(int i = 1 ; i < N ; i++){
            for(int left = 0 ; left < 5 ; left++){
                int next = dirs[i];
                for(int right = 0 ; right < 5 ; right++){
                    dp[left][next][i] = Math.min(dp[left][next][i], dp[left][right][i - 1] + cost[right][next]);
                    dp[next][right][i] = Math.min(dp[next][right][i], dp[left][right][i - 1] + cost[left][next]);
                }
            }
        }
        int answer = MAX;
        int last = dirs[N - 1];
        for(int i = 0 ; i < 5 ; i++){
            answer = Math.min(answer, dp[last][i][N - 1]);
            answer = Math.min(answer, dp[i][last][N - 1]);
        }
        System.out.println(answer);
    }
}
