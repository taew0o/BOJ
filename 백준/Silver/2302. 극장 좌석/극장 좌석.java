import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()) , M = Integer.parseInt(br.readLine());
        boolean[] isVip = new boolean[N + 1];
        while (M --> 0){
            isVip[Integer.parseInt(br.readLine())] = true;
        }
        int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2 ; i <= N ; i++){
            dp[i] = dp[i - 1];
            if(!isVip[i - 1] && !isVip[i]){ //옆자석과 교환이 가능한경우
                dp[i] += dp[i - 2];
            }
        }
        System.out.println(dp[N]);
    }
}
