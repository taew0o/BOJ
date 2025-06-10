import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

            int[][] dp = new int[M + 1][M + 1];
            for(int i = 0 ; i <= M ; i++){
                dp[i][0] = 1;
            }
            dp[1][1] = 1;
            for(int i = 2 ; i <= M ; i++){
                for(int j = 1 ; j <= i ; j++){
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
            sb.append(dp[M][N]).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
