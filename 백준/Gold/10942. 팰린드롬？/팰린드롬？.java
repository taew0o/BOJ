import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        boolean[][] dp = new boolean[N + 1][N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i][i] = true;
        }
        for(int i = 1 ; i < N ; i++){
            dp[i][i + 1] = arr[i] == arr[i + 1];
        }
        for(int len = 3 ; len <= N ; len++){
            for(int left = 1 ; left + len - 1 <= N ; left++){
                int right = left + len - 1;
                dp[left][right] = arr[left] == arr[right] && dp[left + 1][right - 1];
            }
        }
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken()), E = Integer.parseInt(st.nextToken());
            sb.append(dp[S][E] ? "1" : "0").append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
