import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int M,N;
    static int[][] map,dp;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static int dfs(int r, int c){
        if(r == M - 1 && c == N - 1){
            return 1;
        }
        if(dp[r][c] != -1) {
            return dp[r][c];
        }
        dp[r][c] = 0;
        for(int i = 0 ; i < 4 ; i++){
            int r_ = r + dr[i];
            int c_ = c + dc[i];
            if(r_ < 0 || r_ >= M || c_ < 0 || c_ >= N){
                continue;
            }
            if(map[r][c] > map[r_][c_]){
                dp[r][c] += dfs(r_,c_);
            }
        }
        return dp[r][c];
    }
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        dp = new int[M][N];
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0 ; j < N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        System.out.println(dfs(0, 0));
    }
}
