import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N,M;
    public static int[][] map;
    public static int[] dr = {1,0,-1,0}, dc = {0,1,0,-1};
    public static void bfs(int r, int c){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c, 0});
        map[r][c] = 1;
        while (!queue.isEmpty()){
            int[] now = queue.poll();
            for (int i = 0 ; i < 4 ; i++){
                int nr = now[0] + dr[i], nc = now[1] + dc[i];
                if(0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] != 1){
                    if(map[nr][nc] == 0){
                        queue.offer(new int[]{nr, nc, now[2] + 1});
                        map[nr][nc] = 1;
                    }
                    else{
                        System.out.println("TAK");
                        System.out.println(now[2] + 1);
                        return;
                    }
                }
            }
        }
        System.out.println("NIE");
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        int r = -1, c = -1;
        map = new int[N][M];
        for(int i = 0 ; i < N ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < M ; j++){
                map[i][j] = str.charAt(j) - '0';
                if(map[i][j] == 2){
                    r = i; c = j;
                }
            }
        }
        bfs(r, c);
    }
}
