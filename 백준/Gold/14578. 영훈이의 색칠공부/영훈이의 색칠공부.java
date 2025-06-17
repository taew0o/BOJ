import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        final int MAX = 1_000_000_007;

        long[] dp = new long[N + 1]; //derangement
        long f = 1; //factorial value
        dp[0] = 1; dp[1] = 0;
        for(int i = 2 ; i <= N ; i++){
            f *= i; f %= MAX;
            dp[i] = (i - 1) * (dp[i - 1] + dp[i - 2]) % MAX;
        }

        System.out.println(f * dp[N] % MAX);
    }
}
