import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        final int MAX = 1_000_000, MOD = 1_000_000_009;

        int[] dp = new int[MAX + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3 ; i <= MAX ; i ++){
            dp[i] = ((dp[i - 3] + dp[i - 2]) % MOD + dp[i - 1]) % MOD;
        }

        int T = Integer.parseInt(br.readLine());
        while (T --> 0){
            sb.append(dp[Integer.parseInt(br.readLine())]).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
