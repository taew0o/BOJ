import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int len = s.length();
        char[] str = new char[len + 1];
        for(int i = 1; i <= s.length(); i++){
            str[i] = s.charAt(i - 1);
        }
        boolean[][] isPalindrome = new boolean[len + 1][len + 1];
        for(int i = 1 ; i <= len ; i++){
            isPalindrome[i][i] = true;
            isPalindrome[i - 1][i] = str[i - 1] == str[i];
        }
        for(int size = 3 ; size <= len ; size++){
            for(int start = 1 ; start + size - 1 <= len ; start++){
                int end = start + size - 1;
                isPalindrome[start][end] = str[start] == str[end] && isPalindrome[start + 1][end - 1];
            }
        }
        int[] dp = new int[len + 1];
        Arrays.fill(dp, 100_000);
        dp[0] = 0;
        for(int i = 1 ; i <= len ; i++){
            for(int j = 1 ; j <= len ; j++){
                if(isPalindrome[j][i]){
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        System.out.println(dp[len]);
    }
}
