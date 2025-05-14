import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), S = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        boolean[][] dp = new boolean[N + 1][M + 1];
        dp[0][S] = true;
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N ; i++){
            int volume = Integer.parseInt(st.nextToken());
            boolean flag = false; //가능한 경우가 있는지 확인
            for(int j = 0 ; j <= M ; j++){
                if((j + volume <= M && dp[i - 1][j + volume]) || (j - volume >= 0 && dp[i - 1][j - volume])){
                    dp[i][j] = true;
                    flag = true;
                }
            }
            if(!flag){
                System.out.println(-1);
                return;
            }
        }

        for(int i = M ; i >= 0 ; i--){
            if(dp[N][i]){
                System.out.println(i);
                return;
            }
        }
    }
}
