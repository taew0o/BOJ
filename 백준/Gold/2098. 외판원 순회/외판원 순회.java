import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int INF = 20_000_000;
    static int[][] W, dp;
    public static int tsp(int current, int visited){
        if(visited == (1 << N) - 1){
            if(W[current][0] == 0) return INF;
            return W[current][0];
        }
        if(dp[current][visited] != -1) return dp[current][visited];
        dp[current][visited] = INF;
        for(int next = 0 ; next < N ; next++){
            if((visited & (1 << next)) != 0 || W[current][next] == 0) continue;
            dp[current][visited] = Math.min(dp[current][visited],
                    tsp(next, visited | (1 << next)) + W[current][next]);
        }
        return dp[current][visited];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[N][1 << N];
        for(int i = 0 ; i < N ; i++){
            Arrays.fill(dp[i], -1);
        }
        System.out.println(tsp(0, 1));
    }
}
