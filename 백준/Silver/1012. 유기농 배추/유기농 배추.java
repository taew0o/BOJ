import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M,N,K;
    static boolean[][] isExist;
    static boolean[][] isVisited;

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int num;
    public static void bfs(int r, int c){
        Queue<Integer[]> queue = new LinkedList<>();
        queue.offer(new Integer[]{r,c});
        isVisited[r][c] = true;
        while (!queue.isEmpty()){
            Integer[] p = queue.poll();
            for(int i = 0 ; i < 4 ; i++){
                int r_ = p[0] + dr[i];
                int c_ = p[1] + dc[i];
                if(0 <= r_ && r_ < N && 0 <= c_ && c_ < M &&
                        isExist[r_][c_] && !isVisited[r_][c_]){
                    queue.offer(new Integer[]{r_,c_});
                    isVisited[r_][c_] = true;
                }
            }
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int i = 0 ; i < T ; i++){
            num = 0;
            int count = 0;
            st = new StringTokenizer(bufferedReader.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            isExist = new boolean[N][M];
            isVisited = new boolean[N][M];
            for(int j = 0; j < K ; j++){
                st = new StringTokenizer(bufferedReader.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                isExist[y][x] = true;
            }
            for(int j = 0 ; j < N ; j++){
                for(int k = 0 ; k < M ; k++){
                    if(isExist[j][k] && !isVisited[j][k]){
                        bfs(j,k);
                        count++;
                    }
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }
}