import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine(), str2 = br.readLine();
        int N = str1.length(), M = str2.length();
        char[] arr1 = new char[N + 1], arr2 = new char[M + 1];
        for(int i = 1 ; i <= N ; i++){
            arr1[i] = str1.charAt(i - 1);
        }
        for(int i = 1 ; i <= M ; i++){
            arr2[i] = str2.charAt(i - 1);
        }
        int[][] dp = new int[N + 1][M + 1];
        int[][][] parent = new int[N + 1][M + 1][2];
        for(int i = 0 ; i <= N ; i++){
            parent[i][0][0] = -1;
            parent[i][0][1] = -1;
        }
        for(int i = 0 ; i <= M ; i++){
            parent[0][i][0] = -1;
            parent[0][i][1] = -1;
        }
        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= M ; j++){
                if(arr1[i] == arr2[j]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    parent[i][j][0] = i - 1;
                    parent[i][j][1] = j - 1;
                }
                else{
                    if(dp[i - 1][j] > dp[i][j - 1]){
                        dp[i][j] = dp[i - 1][j];
                        parent[i][j][0]= i - 1;
                        parent[i][j][1] = j;
                    }
                    else{
                        dp[i][j] = dp[i][j - 1];
                        parent[i][j][0] = i;
                        parent[i][j][1] = j - 1;
                    }
                }
            }
        }
        System.out.println(dp[N][M]);
        if(dp[N][M] != 0){
            int index1 = N, index2 = M;
            String result = "";
            while (index1 != 0 && index2!= 0){
                if(arr1[index1] == arr2[index2]){
                    result = arr1[index1] + result;
                }
                int[] next = parent[index1][index2];
                index1 = next[0];
                index2 = next[1];
            }
            System.out.println(result);
        }
    }
}
