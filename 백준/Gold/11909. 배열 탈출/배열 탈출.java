import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][N];
        dp[0][0] = 0;
        //0행
        for(int i = 1 ; i < N ; i++){
            dp[0][i] = dp[0][i - 1] + Math.max(0, arr[0][i] - arr[0][i - 1] + 1);
        }

        //0열
        for(int i = 1 ; i < N ; i++){
            dp[i][0] = dp[i - 1][0] + Math.max(0, arr[i][0] - arr[i - 1][0] + 1);
        }

        for(int i = 1 ; i < N ; i++){
            for(int j = 1 ; j < N ; j++){
                //위에서 오는 경우와 왼쪽에서 오는 경우 중 더 작은 값을 선택
                dp[i][j] = Math.min(dp[i - 1][j] + Math.max(arr[i][j] - arr[i - 1][j] + 1, 0),
                        dp[i][j - 1] + Math.max(arr[i][j] - arr[i][j - 1] + 1, 0));
            }
        }

        System.out.println(dp[N - 1][N - 1]);
    }
}
