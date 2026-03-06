import java.util.*;
class Solution {
    public String solution(int n, int m, int r, int c, int rDst, int cDst, int k) {
        int dist = Math.abs(r - rDst) + Math.abs(c - cDst);
        if(dist > k || (dist - k) % 2 != 0) {
            return "impossible";
        }
        StringBuilder sb = new StringBuilder();
        int[] dr = {1,0,0,-1}, dc = {0,-1,1,0};
        char[] dirCode = {'d','l','r','u'};
        for(int i = 0 ; i < k ; i++){
            for(int j = 0 ; j < 4 ; j++){
                int nr = r + dr[j], nc = c + dc[j];
                if(nr < 1 || nr > n || nc < 1 || nc > m) continue;
                int nextDist = Math.abs(nr - rDst) + Math.abs(nc - cDst);
                int remK = k - i - 1;
                if(remK >= nextDist && (remK - nextDist) % 2 == 0){
                    r = nr;
                    c = nc;
                    sb.append(dirCode[j]);
                    break;
                }
            }
        }
        return sb.toString();
    }
}