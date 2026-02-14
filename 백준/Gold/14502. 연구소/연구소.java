import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[][] map, now;
    static ArrayList<int[]> blankList = new ArrayList<>(), virusList = new ArrayList<>();
    static int blankCount,remain;
    static int max = -1;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    public static void bfs(int r, int c){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r,c});
        while (!queue.isEmpty()){
            int[] node = queue.poll();
            for(int i = 0 ; i < 4 ; i++){
                int nr = node[0] + dr[i];
                int nc = node[1] + dc[i];
                if(0 <= nr && nr < N && 0 <= nc && nc < M && now[nr][nc] == 0){
                    now[nr][nc] = 2;
                    queue.offer(new int[]{nr,nc});
                    remain--;
                }
            }
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0){
                    blankList.add(new int[]{i,j});
                }
                else if(map[i][j] == 2){
                    virusList.add(new int[]{i,j});
                }
            }
        }
        blankCount = blankList.size();
        //벽을 세울 세개의 점 정하기
        for(int i = 0 ; i < blankCount ; i++){
            int[] p1 = blankList.get(i);
            map[p1[0]][p1[1]] = 1;
            for(int j = i + 1 ; j < blankCount ; j++){
                int[] p2 = blankList.get(j);
                map[p2[0]][p2[1]] = 1;
                for(int k = j + 1 ; k < blankCount ; k++){
                    int[] p3 = blankList.get(k);
                    map[p3[0]][p3[1]] = 1;
                    remain = blankCount - 3;
                    now = new int[N][M];
                    for(int t = 0 ; t < N ; t++) {
                        now[t] = map[t].clone();
                    }
                    for(int[] virus : virusList){
                        bfs(virus[0], virus[1]);
                    }
                    max = Math.max(max, remain);
                    map[p3[0]][p3[1]] = 0;
                }
                map[p2[0]][p2[1]] = 0;
            }
            map[p1[0]][p1[1]] = 0;
        }
        System.out.println(max);
    }
}
