import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        int[] dp = new int[K + 1];
        Arrays.fill(dp, 100_000);
        dp[0] = 0;

        int[] coin = new int[N];
        for(int i = 0 ; i < N ; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coin);

        for(int i = 1 ; i <= K ; i++){
            for(int j = 0 ; j < N ; j++){
                if(coin[j] > i) break;
                dp[i] = Math.min(dp[i], dp[i - coin[j]] + 1);
            }
        }

        System.out.println(dp[K] == 100_000 ? -1 : dp[K]);
    }
}
