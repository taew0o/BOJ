import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static boolean[][] map;
    static int[][] dist;
    static int[] dr = {1,0,0} , dc = {0,1,-1};
    static int bfs(){
        Queue<int[]> queue = new LinkedList<>();
        dist = new int[N][M];
        for(int i = 0 ; i < M ; i++){
            if(map[0][i]){
                dist[0][i] = 1;
                queue.offer(new int[]{0,i});
            }
        }

        while (!queue.isEmpty()){
            int[] now = queue.poll();
            if(now[0] == N - 1){
                return dist[now[0]][now[1]];
            }
            for(int i = 0 ; i < 3 ; i++){
                int nr = now[0] + dr[i], nc = now[1] + dc[i];
                if(0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] && dist[nr][nc] == 0){
                    dist[nr][nc] = dist[now[0]][now[1]] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        return -1;
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());

            if(N == 0 && M == 0) break;

            map = new boolean[N][M];
            for(int i = 0 ; i < N ; i++){
                String str = br.readLine();
                for(int j = 0 ; j < M ; j++){
                    map[i][j] = str.charAt(j) == 'S';
                }
            }

            //강 행의 가장 왼쪽의 B 정점을 분리자 영역으로 포함
            for(int i = 0 ; i < N ; i++){
                for(int j = M - 1 ; j > 0 ; j--){
                    if(!map[i][j] && map[i][j - 1]){
                        map[i][j] = true;
                        break;
                    }
                }
            }

            sb.append(bfs()).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
