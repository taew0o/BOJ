import java.util.*;
class Solution {
    static int N;
    static int[] picks;
    static int[][] fatigue;
    static int[] mineralOrder;
    static int pickCount, result;
    public static void dfs(int index, int curFatigue){
        if(pickCount == 0 || index == N){
            result = Math.min(result, curFatigue);
        }
        for(int i = 0 ; i < 3 ; i++){
            if(picks[i] == 0) continue;
            int nextFatigue = curFatigue;
            int nextIndex = Math.min(N, index + 5);
            for(int j = index ; j < nextIndex ; j++){
                nextFatigue += fatigue[i][mineralOrder[j]];
            }
            picks[i]--;
            pickCount--;
            dfs(nextIndex, nextFatigue);
            picks[i]++;
            pickCount++;
        }
    }
    public int solution(int[] picks, String[] minerals) {
        this.N = minerals.length;
        this.picks = picks;
        this.fatigue = new int[][]{{1,1,1},{5,1,1},{25,5,1}};
        HashMap<String, Integer> mineralMap = new HashMap<>();
        mineralMap.put("diamond", 0);
        mineralMap.put("iron", 1);
        mineralMap.put("stone", 2);
        this.mineralOrder = new int[N];
        for(int i = 0 ; i < N ; i++){
            this.mineralOrder[i] = mineralMap.get(minerals[i]);
        }
        this.pickCount = picks[0] + picks[1] + picks[2];
        this.result = Integer.MAX_VALUE;
        dfs(0, 0);
        return result;
    }
}