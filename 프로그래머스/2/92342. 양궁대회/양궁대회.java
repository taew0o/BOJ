import java.util.*;
class Solution {
    static int N;
    static int[] apeach, lion;
    static int maxDiff = 0;
    static int[] result = {-1};
    static void calResult(){
        int aScore = 0, lScore = 0;;
        for(int i = 0 ; i <= 10 ; i++){
            if(apeach[i] != 0 && apeach[i] >= lion[i]){
                aScore += 10 - i;
            } else if(lion[i] > apeach[i]){
                lScore += 10 - i;
            }
        }
        if(lScore > aScore){
            int diff = lScore - aScore;
            boolean changeFlag = false;
            if(diff > maxDiff){
                maxDiff = diff;
                changeFlag = true;
            } else if(diff == maxDiff){
                for(int i = 10 ; i >= 0 ; i--){
                    if(lion[i] > result[i]){
                        changeFlag = true;
                        break;
                    } else if(lion[i] < result[i]) break;
                }
            }
            if(changeFlag){
                result = Arrays.copyOf(lion, lion.length);
            }
        }
    }
    public static void dfs(int number, int count){
        if(number > 10){
            lion[10] = N - count;
            calResult();
            return;
        }
        //한발 더 쏘거나
        if(count + apeach[number] + 1 <= N){
            lion[number] = apeach[number] + 1;
            dfs(number + 1, count + apeach[number] + 1);
        }
        //안쏘거나
        lion[number] = 0;
        dfs(number + 1, count);
    }
    public int[] solution(int n, int[] info) {
        N = n;
        apeach = info;
        lion = new int[]{0,0,0,0,0,0,0,0,0,0,0};
        dfs(0, 0);
        return result;
    }
}