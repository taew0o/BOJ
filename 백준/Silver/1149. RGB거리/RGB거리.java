import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[][] price = new int[N + 1][3];
        StringTokenizer st;
        for(int i = 1 ; i <= N ; i++){
            st = new StringTokenizer(bufferedReader.readLine());
            price[i][0] = Integer.parseInt(st.nextToken());
            price[i][1] = Integer.parseInt(st.nextToken());
            price[i][2] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[N + 1][3];
        for(int i = 0 ; i < 3;  i++){
            dp[1][i] = price[1][i];
        }
        for(int i = 2; i <= N ; i++){
            dp[i][0] = price[i][0] + Math.min(dp[i - 1][1],dp[i - 1][2]);
            dp[i][1] = price[i][1] + Math.min(dp[i - 1][0],dp[i - 1][2]);
            dp[i][2] = price[i][2] + Math.min(dp[i - 1][0],dp[i - 1][1]);
        }
        int result = Math.min(Math.min(dp[N][0],dp[N][1]),dp[N][2]);
        System.out.println(result);
    }
}
