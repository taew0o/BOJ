import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        boolean[] isLost = new boolean[n + 2], haveReserve = new boolean[n + 2];
        for(int num : lost){
            isLost[num] = true;
        }
        for(int num : reserve){
            if(!isLost[num]){
                haveReserve[num] = true;
            }
            else{
                isLost[num] = false;
                answer++;
            }
        }
        
        for(int i = 1 ; i <= n ; i++){
            if(isLost[i]){
                if(haveReserve[i - 1]){
                    haveReserve[i - 1] = false;
                    answer++;
                }
                else if(haveReserve[i + 1]){
                    haveReserve[i + 1] = false;
                    answer++;
                }
            }
        }
        return answer;
    }
}