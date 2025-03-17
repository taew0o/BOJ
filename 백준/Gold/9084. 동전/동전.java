import java.io.*;
import java.util.Arrays;

public class Main {
    static int N,M;
    static int[] arr;
    public static int solution(){
        int[] dp = new int[M + 1];
        dp[0] = 1;
        for(int coin : arr){
            for(int cost = coin ; cost <= M ; cost++){
                dp[cost] += dp[cost - coin];
            }
        }
        return dp[M];
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T --> 0){
            N = Integer.parseInt(br.readLine());
            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            M = Integer.parseInt(br.readLine());
            sb.append(solution()).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
