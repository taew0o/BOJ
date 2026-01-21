import java.io.*;
import java.util.*;

public class Main {
    public static int N,M;
    public static boolean[][] map, visited;
    public static int[][] areaSize;
    public static int[][] parent;
    public static ArrayList<int[]> points;
    public static int[] dr = {1, -1, 0, 0};
    public static int[] dc = {0, 0, 1, -1};
    public static boolean isVaildCoord(int r, int c){
        return 0 <= r && r < N && 0 <= c && c < M;
    }
    public static void bfs(int r, int c){
        //BFS 준비
        Queue<int[]> queue= new LinkedList<>();
        queue.offer(new int[]{r, c});
        visited[r][c] = true;
        //땅 크기 기록 준비
        points.clear();
        points.add(new int[]{r, c});
        int count = 1;
        //BFS
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int i = 0; i < 4; i++){
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                if(isVaildCoord(nr, nc) && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    points.add(new int[]{nr, nc});
                    queue.offer(new int[]{nr, nc});
                    count++;
                }
            }
        }
        //땅 크기 기록
        for(int[] point : points){
            parent[point[0]][point[1]] = r * M + c;
            areaSize[point[0]][point[1]] = count;
        }
    }
    public static int calAreaSize(int r, int c){
        int result = 1;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < 4; i++){
            if(isVaildCoord(r + dr[i], c + dc[i]) && parent[r + dr[i]][c + dc[i]] != -1){
                set.add(parent[r + dr[i]][c + dc[i]]);
            }
        }
        for(int num : set){
            result += areaSize[num / M][num % M];
        }
        return result;
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        map = new boolean[N][M]; visited = new boolean[N][M];
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = str.charAt(j) == '1';
                visited[i][j] = map[i][j];
            }
        }

        areaSize = new int[N][M];
        parent = new int[N][M];
        for(int i = 0; i < N; i++){
            Arrays.fill(parent[i], -1);
        }
        points = new ArrayList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visited[i][j]){
                    bfs(i, j);
                }
            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                sb.append(map[i][j] ? calAreaSize(i, j) % 10 : "0");
            }
            sb.append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
