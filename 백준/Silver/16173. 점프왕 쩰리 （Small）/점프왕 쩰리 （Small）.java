import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //BFS
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] isVisited = new boolean[N][N];
        queue.offer(new int[]{0,0});
        isVisited[0][0] = true;
        while (!queue.isEmpty()){
            int[] now = queue.poll();
            int r = now[0], c = now[1];
            int nr = r + map[r][c], nc = c + map[r][c];
            if(nr < N && !isVisited[nr][c]){
                if(nr == N - 1 && c == N - 1){
                    System.out.println("HaruHaru");
                    return;
                }
                isVisited[nr][c] = true;
                queue.offer(new int[]{nr,c});
            }
            if(nc < N && !isVisited[r][nc]){
                if(r == N - 1 && nc == N - 1){
                    System.out.println("HaruHaru");
                    return;
                }
                isVisited[r][nc] = true;
                queue.offer(new int[]{r,nc});
            }
        }
        System.out.println("Hing");
    }
}
