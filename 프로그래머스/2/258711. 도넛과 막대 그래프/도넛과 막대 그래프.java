import java.util.*;
class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        int maxNode = 0;
        for(int[] edge : edges){
            maxNode = Math.max(maxNode, Math.max(edge[0], edge[1]));
        }
        int[] inDegree = new int[maxNode + 1];
        int[] outDegree = new int[maxNode + 1];
        for(int[] edge : edges){
            outDegree[edge[0]]++;
            inDegree[edge[1]]++;
        }
        for(int i = 1 ; i <= maxNode ; i++){
            if(outDegree[i] >= 2 && inDegree[i] == 0){
                answer[0] = i;
            } else if(outDegree[i] == 0 && inDegree[i] > 0){
                answer[2]++;
            } else if(outDegree[i] == 2 && inDegree[i] >= 2){
                answer[3]++;
            }
        }
        answer[1] = outDegree[answer[0]] - answer[2] - answer[3];
        return answer;
    }
}