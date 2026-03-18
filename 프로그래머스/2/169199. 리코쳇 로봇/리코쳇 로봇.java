import java.util.*;
import java.util.*;
class Solution {
    public static int N,M;
    public static int[][] map; //-1 : 벽, 0 : 미방문, > 0 : 거리
    public static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
    public static int[] move(int r, int c, int dir){
        while(map[r + dr[dir]][c + dc[dir]] != -1){
            r += dr[dir];
            c += dc[dir];
        }
        return new int[]{r, c};
    }
    public static int bfs(int sR, int sC, int eR, int eC){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sR, sC});
        map[sR][sC] = 1;
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i = 0 ; i < 4 ; i++){
                int[] next = move(now[0], now[1], i);
                if(next[0] == eR && next[1] == eC){
                    return map[now[0]][now[1]];
                }
                if(map[next[0]][next[1]] == 0){
                    map[next[0]][next[1]] = map[now[0]][now[1]] + 1;
                    q.offer(new int[]{next[0], next[1]});
                }
            }
        }
        return -1;
    }
    
    public int solution(String[] board) {
        int answer = 0;
        N = board.length; M = board[0].length();
        map = new int[N + 2][M + 2];
        for(int i = 0 ; i < N + 2 ; i++){
            map[i][0] = -1;
            map[i][M + 1] = -1;
        }
        for(int i = 0 ; i < M + 2 ; i++){
            map[0][i] = -1;
            map[N + 1][i] = -1;
        }
        int sR = -1, sC = -1, dR = -1, dC = -1;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                char c = board[i].charAt(j);
                switch(c){
                    case 'D':
                        map[i + 1][j + 1] = -1;
                        break;
                    case 'R':
                        sR = i + 1;
                        sC = j + 1;
                        break;
                    case 'G':
                        dR = i + 1;
                        dC = j + 1;
                        break;
                }
            }
        }
        return bfs(sR, sC, dR, dC);
    }
}