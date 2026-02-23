import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M =  Integer.parseInt(st.nextToken());
        int[] memory = new int[N], cost = new int[N];
        StringTokenizer st1 = new StringTokenizer(br.readLine()), st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            memory[i] = Integer.parseInt(st1.nextToken());
            cost[i] = Integer.parseInt(st2.nextToken());
        }
        int len = Arrays.stream(cost).sum();
        long[] dp = new long[len + 1];
        Arrays.fill(dp, -1); //아직 미계산된 값
        dp[0] = 0;
        for(int i = 0 ; i < N ; i++){
            for(int j = len ; j >= cost[i] ; j--){
                if(dp[j - cost[i]] != -1){
                    dp[j] = Math.max(dp[j], dp[j - cost[i]] + memory[i]);
                }
            }
        }
        for(int i = 0 ; i <= len ; i++){
            if(dp[i] >= M) {
                System.out.println(i);
                return;
            }
        }
    }
}
