import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int len = str.length();
        int[] arr = new int[len + 1];
        for(int i = 1 ; i <= len ; i++){
            arr[i] = str.charAt(i - 1) - '0';
        }

        int[] dp = new int[len + 1];
        dp[0] = 1;
        for(int i = 1 ; i <= len ; i++){
            if(arr[i] == 0){
                if(arr[i - 1] == 0 || arr[i - 1] >= 3){
                    System.out.println(0);
                    return;
                }
                dp[i] = dp[i - 2];
            }
            else{
                dp[i] = dp[i - 1];
                if(arr[i - 1] != 0 && arr[i - 1] * 10 + arr[i] <= 26){
                    dp[i] += dp[i - 2];
                    dp[i] = dp[i] % 1_000_000;
                }
            }
        }
        System.out.println(dp[len]);
    }
}
