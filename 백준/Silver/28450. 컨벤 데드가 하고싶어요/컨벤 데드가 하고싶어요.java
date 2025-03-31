import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        long[][] dp = new long[N][M];
        //1행
        st = new StringTokenizer(br.readLine());
        dp[0][0] = Long.parseLong(st.nextToken());
        for(int j = 1 ; j < M ; j++){
            dp[0][j] = dp[0][j - 1] + Integer.parseInt(st.nextToken());
        }
        for(int i = 1 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            dp[i][0] = dp[i - 1][0] + Integer.parseInt(st.nextToken());
            for(int j = 1 ; j < M ; j++){
                dp[i][j] = Math.min(dp[i - 1][j] , dp[i][j - 1]) + Long.parseLong(st.nextToken());
            }
        }

        int H = Integer.parseInt(br.readLine());
        if(H < dp[N - 1][M - 1]){
            System.out.println("NO");
        }
        else{
            System.out.println("YES");
            System.out.println(dp[N - 1][M - 1]);
        }
    }
}
