import java.io.*;
import java.util.*;

public class Main {
    static int M,N,K;
    static boolean[][] map;
    static int count = 0;
    static ArrayList<Integer> result = new ArrayList<>();
    static int[] dr = {1,0,-1,0}, dc = {0,1,0,-1};
    public static int bfs(int r, int c){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        map[r][c] = true;
        int size = 1;
        while (!queue.isEmpty()){
            int[] now = queue.poll();
            for(int i = 0 ; i < 4 ; i++){
                int nr = now[0] + dr[i], nc = now[1] + dc[i];
                if(0 <= nr && nr < M && 0 <= nc && nc < N && !map[nr][nc]){
                    queue.offer(new int[]{nr, nc});
                    map[nr][nc] = true;
                    size++;
                }
            }
        }
        return size;
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); N = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());

        map = new boolean[M][N];
        for(int i = 0 ; i < K ; i++){
            int[] rect = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int r = rect[1] ; r < rect[3] ; r++){
                for(int c = rect[0] ; c < rect[2] ; c++){
                    map[r][c] = true;
                }
            }
        }

        for(int r = 0 ; r < M ; r++){
            for(int c = 0 ; c < N ; c++){
                if(!map[r][c]){
                    result.add(bfs(r, c));
                    count++;
                }
            }
        }

        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        sb.append(count).append('\n');
        for(int size : result){
            sb.append(size).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
