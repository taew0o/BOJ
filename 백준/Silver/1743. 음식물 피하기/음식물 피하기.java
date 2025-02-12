import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[N + 1][M + 1];
        for(int i = 0 ; i < K ; i++){
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
        }

        int[] dr = {1,0,-1,0}, dc = {0,1,0,-1};
        int max = 0;
        for(int n = 1 ; n <= N ; n++){
            for(int m = 1 ; m <= M ; m++){
                if(map[n][m]){
                    //bfs
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{n,m});
                    map[n][m] = false;
                    int count = 1;
                    while (!queue.isEmpty()){
                        int[] now = queue.poll();
                        for(int i = 0 ; i < 4 ; i++){
                            int nr = now[0] + dr[i], nc = now[1] + dc[i];
                            if(1 <= nr && nr <= N && 1 <= nc && nc <= M && map[nr][nc]){
                                queue.offer(new int[]{nr,nc});
                                map[nr][nc] = false;
                                count++;
                            }
                        }
                    }
                    max = Math.max(max, count);
                }
            }
        }
        System.out.println(max);

    }
}
