import java.util.*;
class Solution {
    static int N,M,count;
    static char[][] map;
    static boolean[][] isEdge;
    //외부 영역 전개하는 bfs
    static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
    static boolean isVaildCoord(int r, int c){
        return 0 <= r && r < N && 0 <= c && c < M;
    }
    static void bfs(int r, int c){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i = 0 ; i < 4 ; i++){
                int nr = now[0] + dr[i], nc = now[1] + dc[i];
                if(isVaildCoord(nr, nc)){
                    if(map[nr][nc] == ' ' && !isEdge[nr][nc]){
                        isEdge[nr][nc] = true;
                        q.add(new int[]{nr, nc});
                    } else if(map[nr][nc] != ' ' && !isEdge[nr][nc]){
                        isEdge[nr][nc] = true;
                    }
                }
            }
        }
    }
    static boolean isRemovable(int r, int c, String request){
        char target = request.charAt(0);
        if(map[r][c] != target) return false;
        return request.length() == 1 ? isEdge[r][c] : true;
    }
    static void remove(String request){
        Queue<int[]> removed = new LinkedList<>();
        for(int r = 0 ; r < N ; r++){
            for(int c = 0 ; c < M ; c++){
                if(isRemovable(r, c, request)){
                    map[r][c] = ' ';
                    count--;
                    if(isEdge[r][c]) removed.add(new int[]{r, c});
                }
            }
        }
        while(!removed.isEmpty()){
            int[] now = removed.poll();
            bfs(now[0], now[1]);
        }
    }
    public int solution(String[] storage, String[] requests) {
        N = storage.length; M = storage[0].length();
        map = new char[N][M];
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                map[i][j] = storage[i].charAt(j);
            }
        }
        isEdge = new boolean[N][M];
        for(int i = 0 ; i < N ; i++){
            isEdge[i][0] = true;
            isEdge[i][M - 1] = true;
        }
        for(int i = 0 ; i < M ; i++){
            isEdge[0][i] = true;
            isEdge[N - 1][i] = true;
        }
        count = N * M;
        for(String request : requests){
            remove(request);
        }
        return count;
    }
}