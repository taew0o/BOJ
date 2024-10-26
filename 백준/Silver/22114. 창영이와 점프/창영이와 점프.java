import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N][2];
        dp[0][0] = 1;

        int result = 1;

        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i < N ; i++){
            int dist = Integer.parseInt(st.nextToken());
            if(dist <= K){
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = dp[i - 1][1] + 1;
            } else{
                dp[i][0] = 1;
                dp[i][1] = dp[i - 1][0] + 1;
            }
            result = Math.max(result, Math.max(dp[i][0], dp[i][1]));
        }
        System.out.println(result);
    }
}
