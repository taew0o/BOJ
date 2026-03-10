import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        int answer = 1;
        int left = targets[0][0], right = targets[0][1];
        for(int i = 1 ; i < targets.length ; i++){
            if(targets[i][0] < right){
                left = targets[i][0];
                right = Math.min(right, targets[i][1]);
                continue;
            }
            answer ++;
            left = targets[i][0]; right = targets[i][1];
        }
        return answer;
    }
}