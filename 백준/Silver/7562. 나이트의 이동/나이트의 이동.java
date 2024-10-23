import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1,-2,-2,-1,1,2,2,1}, dc = {-2,-1,1,2,2,1,-1,-2};
    public static int bfs(int l, int sr, int sc, int er, int ec){

        int[][] visited = new int[l][l];
        visited[sr][sc] = 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});

        while (!queue.isEmpty()){
            int[] now = queue.poll();
            if(now[0] == er && now[1] == ec){
                return visited[er][ec] - 1;
            }
            for(int i = 0 ; i < 8 ; i++){
                int nr = now[0] + dr[i], nc = now[1] + dc[i];
                if(0 <= nr && nr < l && 0 <= nc && nc < l && visited[nr][nc] == 0){
                    visited[nr][nc] = visited[now[0]][now[1]] + 1;
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

        int T = Integer.parseInt(br.readLine());

        while (T --> 0){
            int l = Integer.parseInt(br.readLine());

            StringTokenizer st1 = new StringTokenizer(br.readLine()), st2 = new StringTokenizer(br.readLine());
            int sr = Integer.parseInt(st1.nextToken()), sc = Integer.parseInt(st1.nextToken());
            int er = Integer.parseInt(st2.nextToken()), ec = Integer.parseInt(st2.nextToken());

            sb.append(bfs(l,sr,sc,er,ec)).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
