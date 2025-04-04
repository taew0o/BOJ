import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N,M;
    public static int[][] map;
    public static Queue<int[]> sharks;
    public static int result = 0;
    static int[] dr = {1,0,-1,0,1,1,-1,-1}, dc = {0,1,0,-1,1,-1,1,-1};
    public static void bfs(int r, int c){
        map[r][c] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        while (!queue.isEmpty()){
            int[] now = queue.poll();
            for(int i = 0 ; i < 8 ; i++){
                int nr = now[0] + dr[i], nc = now[1] + dc[i];
                if(0 <= nr && nr < N && 0 <= nc && nc < M && map[now[0]][now[1]] < map[nr][nc] - 1){
                    map[nr][nc] = map[now[0]][now[1]] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0 ; i < N ; i++){
            Arrays.fill(map[i], 10000);
        }

        sharks = new LinkedList<>();
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++){
                if(Integer.parseInt(st.nextToken()) == 1){
                    sharks.offer(new int[]{i, j});
                }
            }
        }

        while (!sharks.isEmpty()){
            int[] shark = sharks.poll();
            bfs(shark[0], shark[1]);
        }

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++) {
                result = Math.max(result, map[i][j]);
            }
        }

        System.out.println(result);
    }
}
