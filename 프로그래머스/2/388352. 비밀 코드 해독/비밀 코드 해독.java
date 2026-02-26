import java.util.*;
class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        HashSet<Integer>[] sets = new HashSet[ans.length];
        for(int i = 0 ; i < ans.length ; i++){
            sets[i] = new HashSet<>();
            for(int j = 0 ; j < 5 ; j++){
                sets[i].add(q[i][j]);
            }
        }
        int result = 0;
        for(int n1 = 1 ; n1 <= n - 4; n1++){
            for(int n2 = n1 + 1 ; n2 <= n - 3 ; n2++){
                for(int n3 = n2 + 1 ; n3 <= n - 2 ; n3++){
                    for(int n4 = n3 + 1 ; n4 <= n - 1 ; n4++){
                        for(int n5 = n4 + 1 ; n5 <= n ; n5++){
                            boolean flag = true;
                            for(int i = 0 ; i < sets.length ; i++){
                                int count = 0;
                                if(sets[i].contains(n1)) count++;
                                if(sets[i].contains(n2)) count++;
                                if(sets[i].contains(n3)) count++;
                                if(sets[i].contains(n4)) count++;
                                if(sets[i].contains(n5)) count++;
                                if(count != ans[i]) {
                                    flag = false;
                                    break;
                                }
                            }
                            if(flag) result++;
                        }
                    }
                }
            }
        }
        return result;
    }
}