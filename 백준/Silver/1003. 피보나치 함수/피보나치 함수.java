import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] num = new int[N];
        for(int i = 0 ; i < N ; i++){
            num[i] = Integer.parseInt(bufferedReader.readLine());
        }
        int[][] dp = new int[41][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        for(int i = 2; i <= 40 ; i++){
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N ; i++){
            sb.append(dp[num[i]][0]).append(" ").append(dp[num[i]][1]).append('\n');
        }
        System.out.println(sb);
    }
}
