import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int N, M;
    static int[][] map;
    static int[] result;//각 행별 시추 가능한 석유의 양
    static boolean[][] visited;
    static int[] dr = {1,-1,0,0}, dc = {0,0,1,-1};
    public static void bfs(int r, int c){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        boolean[] isVisitedCol = new boolean[M];
        visited[r][c] = true;
        isVisitedCol[c] = true;
        int count = 1;
        while (!queue.isEmpty()){
            int[] now = queue.poll();
            for(int i = 0 ; i < 4 ; i++){
                int nr = now[0] + dr[i], nc = now[1] + dc[i];
                if(0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] == 1 && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    if(!isVisitedCol[nc]) isVisitedCol[nc] = true;
                    queue.offer(new int[]{nr, nc});
                    count++;
                }
            }
        }
        for(int i = 0 ; i < M ; i++){
            if(isVisitedCol[i]){
                result[i] += count;
            }
        }
    }
    public static int solution(int[][] land) {
        N = land.length; M = land[0].length;
        map = land;
        visited = new boolean[N][M];
        result = new int[M];
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    bfs(i, j);
                }
            }
        }
        return Arrays.stream(result).max().getAsInt();
    }
}