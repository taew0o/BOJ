class Solution {
    public int solution(int m, int n, int[][] puddles) {
        boolean[][] isSinked = new boolean[n + 1][m + 1];
        for(int[] puddle : puddles){
            isSinked[puddle[1]][puddle[0]] = true;
        }
        int[][] dp = new int[n + 1][m + 1];
        dp[1][1] = 1;
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                if(i == 1 && j == 1) continue;
                dp[i][j] = isSinked[i][j] ? 0 : (dp[i - 1][j] + dp[i][j - 1]) % 1_000_000_007;
            }
        }
        return dp[n][m];
    }
}