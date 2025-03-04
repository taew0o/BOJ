import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] L = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] J = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] dp = new int[100 + 1];

        for(int i = 0 ; i < N ; i++){
            int cost = L[i];
            int pleasure = J[i];
            for(int j = 1 ; j <= 100 - cost ; j++){
                dp[j] = Math.max(dp[j] , dp[j + cost] + pleasure);
            }
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
