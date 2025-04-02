import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int w, h;
    static boolean[][] map;
    static int count;
    static int[] dr = {1,0,-1,0, 1,1,-1,-1}, dc = {0,1,0,-1,1,-1,1,-1};
    static void bfs(int r, int c){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        map[r][c] = true;
        while (!queue.isEmpty()){
            int[] now = queue.poll();
            for(int i = 0 ; i < 8 ; i++){
                int nr = now[0] + dr[i], nc = now[1] + dc[i];
                if(0 <= nr && nr < h &&  0 <= nc && nc < w && !map[nr][nc]){
                    map[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken()); h = Integer.parseInt(st.nextToken());
            if(w == 0 && h == 0) break;

            map = new boolean[h][w];
            for(int i = 0 ; i < h ; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0 ; j < w ; j++){
                    map[i][j] = Integer.parseInt(st.nextToken()) == 0; //바다일 때 true(방문 처리)
                }
            }

            count = 0;
            for(int i = 0 ; i < h ; i++){
                for(int j = 0 ; j < w ; j++){
                    if(!map[i][j]){
                        count++; // 섬 1개 추가
                        bfs(i, j); // 이어진 땅들 탐색
                    }
                }
            }

            sb.append(count).append('\n');

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
