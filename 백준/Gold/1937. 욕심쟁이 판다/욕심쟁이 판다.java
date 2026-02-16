import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int[][] map;
    public static int[][] dp;
    public static int max = -1;
    static int[] dr = {1, 0, -1, 0}, dc = {0, 1, 0, -1};
    public static int DP(int r, int c){
        if(dp[r][c] != -1) return dp[r][c];
        int result = 1; //자기 자신
        for(int i = 0 ; i < 4 ; i++){
            int nr = r + dr[i], nc = c + dc[i];
            if(0 <= nr && nr < N && 0 <= nc && nc < N && map[r][c] < map[nr][nc]){
                result = Math.max(result, DP(nr, nc) + 1);
            }
        }
        return (dp[r][c] = result);
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new int[N][N];
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                max = Math.max(max, DP(i, j));
            }
        }
        System.out.println(max);
    }
}
