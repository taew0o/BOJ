import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = 1;
        while (true){
            int N = Integer.parseInt(br.readLine());
            if(N == 0) break;

            int[][] dp = new int[N][3];
            for(int i = 0 ; i < N ; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0 ; j < 3 ; j++){
                    dp[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dp[1][0] += dp[0][1];
            dp[1][1] += Math.min(Math.min(dp[0][1], dp[1][0]), dp[0][1] + dp[0][2]);
            dp[1][2] += Math.min(Math.min(dp[0][1], dp[1][1]), dp[0][1] + dp[0][2]);
            for(int i = 2 ; i < N ; i++){
                dp[i][0] += Math.min(dp[i - 1][0] , dp[i - 1][1]);
                dp[i][1] += Math.min(Math.min(dp[i - 1][0], dp[i - 1][1]), Math.min(dp[i - 1][2], dp[i][0]));
                dp[i][2] += Math.min(Math.min(dp[i - 1][1] , dp[i - 1][2]), dp[i][1]);
            }
            sb.append(String.format("%d. %d", t, dp[N - 1][1])).append('\n');
            t++;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
