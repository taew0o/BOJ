import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if(N == 0) break;
            int S = Integer.parseInt(st.nextToken()), T = Integer.parseInt(st.nextToken());

            int[] arr = new int[S * T + 1];
            int index = 1;
            while (index <= N){
                st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()){
                    arr[index] = Integer.parseInt(st.nextToken());
                    index++;
                }
            }

            int[][] dp = new int[T + 1][S * T + 1];
            for(int i = 1 ; i <= T ; i++){
                Arrays.fill(dp[i], Integer.MIN_VALUE);
            }

            for(int i = 1 ; i <= S ; i++){
                dp[1][i] = arr[i];
            }

            for(int i = 2 ; i <= T ; i++){
                for(int j = i ; j <= S * i ; j++){
                    for(int k = 1 ; k <= S ; k++){
                        if(j - k <= 0) break;
                        if(dp[i - 1][j - k] != Integer.MIN_VALUE) {
                            dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k] + arr[j]);
                        }
                    }
                }
            }

            int result = Integer.MIN_VALUE;
            for(int i = N + 1 ; i <= S * T ; i++){
                result = Math.max(result, dp[T][i]);
            }
            sb.append(result).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
