import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R,C;
    final static int WALL = -2, EMPTY = -1;
    static int[] dr = {1,0,-1,0}, dc = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());

        int[][] map = new int[R][C], fireMap = new int[R][C];
        Queue<int[]> queue = new LinkedList<>(),fireQueue = new LinkedList<>();
        for(int i = 0 ; i < R ; i++){
            String str = br.readLine();
            Arrays.fill(map[i], EMPTY);
            Arrays.fill(fireMap[i], EMPTY);
            for(int j = 0 ; j < C ; j++){
                char c = str.charAt(j);
                switch(c){
                    case '#': map[i][j] = WALL; fireMap[i][j] = WALL; break;
                    case 'J': map[i][j] = 0; queue.add(new int[]{i, j}); break;
                    case 'F': fireMap[i][j] = 0; fireQueue.add(new int[]{i, j}); break;
                }
            }
        }
        //FIRE BFS
        while(!fireQueue.isEmpty()){
            int[] now = fireQueue.poll();
            for(int i = 0 ; i < 4 ; i++){
                int nr = now[0] + dr[i], nc = now[1] + dc[i];
                if(0 <= nr && nr < R && 0 <= nc && nc < C && fireMap[nr][nc] == EMPTY){
                    fireMap[nr][nc] = fireMap[now[0]][now[1]] + 1;
                    fireQueue.add(new int[]{nr, nc});
                }
            }
        }

        //Distance BFS
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            if(now[0] == 0 || now[0] == R - 1 || now[1] == 0 || now[1] == C - 1){
                System.out.println(map[now[0]][now[1]] + 1);
                return;
            }
            for(int i = 0 ; i < 4 ; i++){
                int nr = now[0] + dr[i], nc = now[1] + dc[i];
                if (0 <= nr && nr < R && 0 <= nc && nc < C && map[nr][nc] == EMPTY && (map[now[0]][now[1]] + 1 < fireMap[nr][nc] || fireMap[nr][nc] == EMPTY)){
                    map[nr][nc] = map[now[0]][now[1]] + 1;
                    queue.add(new int[]{nr, nc});
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}
