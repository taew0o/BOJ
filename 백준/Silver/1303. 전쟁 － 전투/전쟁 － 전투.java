import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static final int BLUE = 0, WHITE = 1, NONE = -1;
    static int[][] map; // -1 : None , 0 : Blue, 1 : White
    static int blue = 0 , white = 0;
    static int[] dr = {1,0,-1,0}, dc = {0,1,0,-1};
    static int bfs(int r, int c, int color){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        map[r][c] = -1; //방문 처리

        int result = 1;
        while (!queue.isEmpty()){
            int[] now = queue.poll();
            for(int i = 0 ; i < 4 ; i++){
                int nr = now[0] + dr[i], nc = now[1] + dc[i];
                if(0 <= nr && nr < M && 0 <= nc && nc < N && map[nr][nc] == color){
                    queue.offer(new int[]{nr, nc});
                    map[nr][nc] = -1;
                    result++;
                }
            }
        }
        return result * result;
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        for(int i = 0 ; i < M ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < N ; j++){
                map[i][j] = str.charAt(j) == 'W' ? 1 : 0;
            }
        }

        for(int i = 0 ; i < M ; i++){
            for(int j = 0 ; j < N ; j++){
                if(map[i][j] == BLUE){
                    blue += bfs(i, j, BLUE);
                }
                else if(map[i][j] == WHITE){
                    white += bfs(i, j, WHITE);
                }
            }
        }

        System.out.println(white + " " + blue);
    }
}
