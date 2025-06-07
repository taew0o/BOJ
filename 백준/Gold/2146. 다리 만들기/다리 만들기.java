import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[][] isLand, visited;
    static int[][] map;
    static int result = Integer.MAX_VALUE;
    static int[] dr = {1,-1,0,0}, dc = {0,0,1,-1};
    public static void bfsLand(int r, int c, int landNum){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        map[r][c] = landNum;
        while (!queue.isEmpty()){
            int[] now = queue.poll();
            for(int i = 0 ; i < 4 ; i++){
                int nr = now[0] + dr[i], nc = now[1] + dc[i];
                if(0 <= nr && nr < N && 0 <= nc && nc < N && isLand[nr][nc] && map[nr][nc] == 0){
                    map[nr][nc] = landNum;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }
    public static void bfsDist(int r, int c, int landNum){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c, 0});
        visited[r][c] = true;
        while (!queue.isEmpty()){
            int[] now = queue.poll();
            for(int i = 0 ; i < 4 ; i++){
                int nr = now[0] + dr[i], nc = now[1] + dc[i];
                if(0 <= nr && nr < N && 0 <= nc && nc < N && !visited[nr][nc]){
                    if(map[nr][nc] == 0){
                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc, now[2] + 1});
                    }
                    else if(map[nr][nc] != landNum){
                        result = Math.min(result, now[2]);
                        return;
                    }
                }
            }
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        isLand = new boolean[N][N];
        map = new int[N][N];
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                isLand[i][j] = st.nextToken().equals("1");
            }
        }

        int landNum = 1;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                //땅인데 아직 방문 처리가 안된 부분이 있다면
                if(isLand[i][j] && map[i][j] == 0){
                    bfsLand(i, j, landNum);
                    landNum++;
                }
            }
        }

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(map[i][j] != 0){
                    visited = new boolean[N][N];
                    bfsDist(i, j, map[i][j]);
                }
            }
        }
        System.out.println(result);
    }
}
