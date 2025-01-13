import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static int N,M;
    static boolean[][] visited;
    public static int count = 0, max = 0;
    static int[] dr = {1,0,-1,0}, dc = {0,1,0,-1};
    public static int bfs(int r, int c){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r,c});
        visited[r][c] = true;

        int area = 1;
        while (!queue.isEmpty()){
            int[] now = queue.poll();
            for(int i = 0 ; i < 4 ; i++){
                int nr = now[0] + dr[i], nc = now[1] + dc[i];
                if(0 <= nr && nr < N && 0 <= nc && nc < M && !visited[nr][nc]){
                    area++;
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr,nc});
                }
            }
        }
        return  area;
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++){
                visited[i][j] = st.nextToken().equals("0"); //0이면 방문 처리
            }
        }

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(!visited[i][j]){
                    max = Math.max(max, bfs(i,j));
                    count++;
                }
            }
        }
        System.out.println(count);
        System.out.println(max);

    }
}
