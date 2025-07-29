import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1], dp = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;
        for(int i = 1 ; i <= N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            int max = arr[i], min = arr[i];
            for(int j = i ; j > 0 ; j--){
                max = Math.max(max, arr[j]);
                min = Math.min(min, arr[j]);
                dp[i] = Math.max(dp[i], dp[j - 1] + (max - min));
            }
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
    }
}
