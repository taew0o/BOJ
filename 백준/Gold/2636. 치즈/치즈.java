import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N,M;
    public static boolean[][] map, visited;
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};
    public static boolean isValidCoord(int r, int c){
        return 0 <= r && r < N && 0 <= c && c < M;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = st.nextToken().equals("1");
            }
        }

        Queue<int[]> airs = new LinkedList<>();
        visited = new boolean[N][M];
        for(int i = 0 ; i < N ; i++){
            visited[i][0] = true;
            airs.add(new int[]{i,0});
            visited[i][M-1] = true;
            airs.add(new int[]{i,M - 1});
        }
        for(int i = 1 ; i < M - 1 ; i++){
            visited[0][i] = true;
            airs.add(new int[]{0,i});
            visited[N-1][i] = true;
            airs.add(new int[]{N-1,i});
        }

        Queue<int[]> cheezes = new LinkedList<>();
        while(!airs.isEmpty()){
            int[] cur = airs.poll();
            for(int i = 0 ; i < 4 ; i++){
                int nr = cur[0] + dr[i], nc = cur[1] + dc[i];
                if(isValidCoord(nr, nc) && !visited[nr][nc]){
                    if(map[nr][nc]){
                        cheezes.add(new int[]{nr, nc});
                    } else{
                        airs.add(new int[]{nr, nc});
                    }
                    visited[nr][nc] = true;
                }
            }
        }
        int time = 0, count = 0;
        while(!cheezes.isEmpty()){
            Queue<int[]> next = new LinkedList<>();
            count = cheezes.size();
            while(!cheezes.isEmpty()){
                int[] cur = cheezes.poll();
                map[cur[0]][cur[1]] = false;
                for(int i = 0 ; i < 4 ; i++){
                    int nr = cur[0] + dr[i], nc = cur[1] + dc[i];
                    if(isValidCoord(nr, nc) && !visited[nr][nc]){
                        if(map[nr][nc]){
                            next.add(new int[]{nr, nc});
                        } else{
                            cheezes.add(new int[]{nr, nc});
                        }
                        visited[nr][nc] = true;
                    }
                }
            }
            time++;
            cheezes = next;
        }
        System.out.println(time);
        System.out.println(count);
    }
}
