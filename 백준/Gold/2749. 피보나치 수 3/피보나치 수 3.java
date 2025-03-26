import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int pisano = 1500000;
        long n = Long.parseLong(br.readLine());
        int len = (int) (n % pisano);

        int[] dp = new int[len + 1];
        dp[1] = 1;
        for(int i = 2 ; i <= len ; i++){
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1000000;
        }

        System.out.println(dp[len]);
    }
}
