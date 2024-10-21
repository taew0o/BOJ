import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N + 1][M + 1];
        int max = 0;
        for(int i = 1 ; i <= N ; i++){
            String str = br.readLine();
            for(int j = 1 ; j <= M ; j++){
                if(str.charAt(j - 1) == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    max = Math.max(max, dp[i][j] * dp[i][j]);
                }
            }
        }
        System.out.println(max);
    }
}
