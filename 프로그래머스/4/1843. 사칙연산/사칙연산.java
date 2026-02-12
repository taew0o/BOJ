import java.util.*;

class Solution {
    public int solution(String arr[]) {
        int n = arr.length / 2 + 1;
        int[][] maxDp = new int[n][n];
        int[][] minDp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(maxDp[i], Integer.MIN_VALUE);
            Arrays.fill(minDp[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            maxDp[i][i] = minDp[i][i] = Integer.parseInt(arr[i * 2]);
        }

        for (int step = 1; step < n; step++) {
            for (int i = 0; i < n - step; i++) {
                int j = i + step;
                for (int k = i; k < j; k++) {
                    String op = arr[k * 2 + 1];
                    
                    if (op.equals("+")) {
                        maxDp[i][j] = Math.max(maxDp[i][j], maxDp[i][k] + maxDp[k + 1][j]);
                        minDp[i][j] = Math.min(minDp[i][j], minDp[i][k] + minDp[k + 1][j]);
                    } else {
                        maxDp[i][j] = Math.max(maxDp[i][j], maxDp[i][k] - minDp[k + 1][j]);
                        minDp[i][j] = Math.min(minDp[i][j], minDp[i][k] - maxDp[k + 1][j]);
                    }
                }
            }
        }

        return maxDp[0][n - 1];
    }
}