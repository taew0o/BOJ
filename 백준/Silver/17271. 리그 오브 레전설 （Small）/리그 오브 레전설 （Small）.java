import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        final int MAX = 1_000_000_007;

        if(N < M){
            System.out.println(1);
            return;
        }

        int[] dp = new int[N + 1];
        for(int i = 0 ; i < M ; i++){
            dp[i] = 1;
        }

        for(int i = M ; i <= N ; i++){
            dp[i] = (dp[i - 1] + dp[i - M]) % MAX;
        }

        System.out.println(dp[N]);
    }
}
