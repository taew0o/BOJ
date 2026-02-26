import java.util.*;
class Solution {
    public int solution(int[][] info, int n, int m) {
        int INF = 1_000_000;
        int[] dp = new int[m];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for(int[] track : info){
            int a = track[0], b = track[1];
            for(int i = m - 1 ; i >= 0 ; i--){
                int nextB = i + b;
                int currentA = dp[i];
                dp[i] += a;
                if(nextB < m){
                    dp[nextB] = Math.min(dp[nextB], currentA);
                }
            }
        }
        int answer = INF;
        for(int i = 0 ; i < m ; i++){
            if(dp[i] < n){
                answer = Math.min(answer, dp[i]);
            }
        }
        return answer == INF ? -1 : answer;
    }
}