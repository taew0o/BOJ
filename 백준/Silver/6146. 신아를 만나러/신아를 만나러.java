import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X =  Integer.parseInt(st.nextToken()) + 500;
        int Y = Integer.parseInt(st.nextToken()) + 500;
        int N =  Integer.parseInt(st.nextToken());
        int[] dx = {1,0,-1,0}, dy = {0,1,0,-1};
        map = new int[1000 + 1][1000 + 1];
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) + 500;
            int b = Integer.parseInt(st.nextToken()) + 500;
            map[a][b] = -1;
        }
        map[500][500] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{500, 500});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if(cur[0] == X && cur[1] == Y) {
                System.out.println(map[cur[0]][cur[1]] - 1);
                return;
            }
            for(int i = 0; i < 4; i++) {
                int nx =  cur[0] + dx[i], ny =  cur[1] + dy[i];
                if(0 <= nx && nx <= 1000 && 0 <= ny && ny <= 1000 && map[nx][ny] == 0) {
                    map[nx][ny] = map[cur[0]][cur[1]] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
