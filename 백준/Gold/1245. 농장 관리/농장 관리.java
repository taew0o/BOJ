import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[][] map;
    static boolean[][] isVisited;
    static Queue<int[]> points;
    static int[] dr = {1,0,-1,0,1,-1,1,-1}, dc = {0,1,0,-1,1,1,-1,-1};
    static int bfs(){
        int count = 0;
        while (!points.isEmpty()){
            int[] p = points.poll();
            if(isVisited[p[0]][p[1]]) continue;
            count++;
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{p[0],p[1]});
            isVisited[p[0]][p[1]] = true;
            while (!queue.isEmpty()){
                int[] now = queue.poll();
                for(int i = 0 ; i < 8 ; i++){
                    int nr = now[0] + dr[i], nc = now[1] + dc[i];
                    if(0 <= nr && nr < N && 0 <= nc && nc < M && !isVisited[nr][nc]
                            && map[now[0]][now[1]] >= map[nr][nc]){
                        isVisited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }
        return count;
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        points = new PriorityQueue<>((o1, o2) -> o2[2] - o1[2]);
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                points.offer(new int[]{i,j,map[i][j]});
            }
        }

        isVisited = new boolean[N][M];

        System.out.println(bfs());
    }
}
