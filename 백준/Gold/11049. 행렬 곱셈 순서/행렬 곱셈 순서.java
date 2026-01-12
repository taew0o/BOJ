import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] matrix;
    static int[][] dp;
    static int DP(int left, int right){
        if(dp[left][right] != Integer.MAX_VALUE) return dp[left][right];
        if(left == right) return dp[left][right] = 0;
        for(int i = left + 1 ; i <= right ; i++){
            dp[left][right] = Math.min(dp[left][right], DP(left, i - 1) + DP(i, right) + matrix[left][0] * matrix[i - 1][1] * matrix[right][1]);
        }
        return dp[left][right];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][2];
        dp = new int[N][N];
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0 ; i < N ; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        System.out.println(DP(0, N - 1));
    }
}
