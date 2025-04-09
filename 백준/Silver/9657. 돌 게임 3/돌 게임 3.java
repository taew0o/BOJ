import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean[] base = {false, true, false, true, true};
        if(N <= 4){
            System.out.println(base[N] ? "SK" : "CY");
            return;
        }
        boolean[] dp = new boolean[N + 1]; //상근이가 이기면 true, 창영이가 이기면 false
        dp[1] = true;
        dp[3] = true;
        dp[4] = true;

        for(int i = 5; i <= N ; i++){
            //i - 1, i - 3, i - 4 중 하나라도 창영이가 이기는 경우가 있으면 상근이의 승리
            dp[i] = !(dp[i - 1] && dp[i - 3] && dp[i - 4]);
        }

        System.out.println(dp[N] ? "SK" : "CY");
    }
}
