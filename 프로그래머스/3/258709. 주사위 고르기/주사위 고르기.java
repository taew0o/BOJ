import java.util.*;
class Solution {
    static int N, maxSum;
    static int[][] dice;
    static HashSet<Integer> mine, opponent;
    static int maxWin;
    static int[] result;
    static int[] calCase(HashSet<Integer> selectedDice){
        int[] dp = new int[maxSum + 1];
        dp[0] = 1;
        for(int diceIdx : selectedDice){
            int[] nextDp = new int[maxSum + 1];
            for(int s = 0 ; s <= maxSum ; s++){
                if(dp[s] == 0) continue;
                for(int val : dice[diceIdx]){
                    if(s + val <= maxSum){
                        nextDp[s + val] += dp[s];
                    }
                }
            }
            dp = nextDp;
        }
        return dp;
    }
    static int battle(){
        int[] myCase = calCase(mine), oppositeCase = calCase(opponent);
        int[] prefixSum = new int[maxSum + 2];
        for(int i = 0 ; i <= maxSum ; i++){
            prefixSum[i + 1] = prefixSum[i] + oppositeCase[i];
        }
        int totalWins = 0;
        for(int s = 0 ; s <= maxSum ; s++){
            if(myCase[s] == 0) continue;
            totalWins += myCase[s] * prefixSum[s];
        }
        return totalWins;
    }
    static void dfs(int start, int count){
        //선택할 수 있는 남은 주사위 : N - start
        //선택한 주사위의 수 : count
        //선택해야 하는 주사위의 수 : N / 2
        if(N - start + count < N / 2) return;
        if(count == N / 2){
            int win = battle();
            if(win > maxWin){
                maxWin = win;
                int i = 0;
                for(int dice : mine){
                    result[i++] = dice + 1;
                }
            }
            return;
        }
        for(int i = start ; i < N ; i++){
            opponent.remove(i);
            mine.add(i);
            dfs(i + 1, count + 1);
            mine.remove(i);
            opponent.add(i);
        }
    }
    public int[] solution(int[][] dice) {
        N = dice.length;
        maxSum = N / 2 * 100;
        this.dice = dice;
        mine = new HashSet<>();
        opponent = new HashSet<>();
        for(int i = 0 ; i < N ; i++){
            opponent.add(i);
        }
        maxWin = 0;
        result = new int[N / 2];
        dfs(0, 0);
        Arrays.sort(result);
        return result;
    }
}