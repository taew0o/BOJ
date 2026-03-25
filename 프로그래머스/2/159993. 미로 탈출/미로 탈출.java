import java.util.*;
class Solution {
    static int N, M;
    static boolean[][] visited, visitedWithKey;
    static int[] dr = {-1,1,0,0}, dc = {0,0,-1,1};
    public static int bfs(int[] start, int[] target, boolean[][] visited){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i = 0 ; i < 4 ; i++){
                int nr = now[0] + dr[i], nc = now[1] + dc[i];
                if(0 <= nr && nr < N && 0 <= nc && nc < M && !visited[nr][nc]){
                    if(nr == target[0] && nc == target[1]) return now[2] + 1;
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc, now[2] + 1});
                }
            }
        }
        return -1;
    }
    public int solution(String[] maps) {
        int answer = 0;
        N = maps.length; M = maps[0].length();
        visited = new boolean[N][M];
        visitedWithKey = new boolean[N][M];
        int[] start = new int[2], lever = new int[2], end = new int[2];
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                switch(maps[i].charAt(j)){
                    case 'S':
                        start[0] = i; start[1] = j;
                        break;
                    case 'E':
                        end[0] = i; end[1] = j;
                        break;
                    case 'L':
                        lever[0] = i; lever[1] = j;
                        break;
                    case 'X':
                        visited[i][j] = visitedWithKey[i][j] = true;
                        break;
                }
            }
        }
        int startToLever = bfs(start, lever, visited);
        if(startToLever == -1) return -1;
        int leverToEnd = bfs(lever, end, visitedWithKey);
        return leverToEnd == -1 ? -1 : startToLever + leverToEnd;
    }
}