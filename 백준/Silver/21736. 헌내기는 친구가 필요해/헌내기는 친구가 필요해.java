import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int meet, startR,startC;
    static char[][] map;
    static boolean[][] isVisited;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void bfs(){
        Queue<Integer[]> queue = new LinkedList<>();
        queue.offer(new Integer[]{startR,startC});
        isVisited[startR][startC] = true;
        while (!queue.isEmpty()){
            Integer[] dot = queue.poll();
            for(int i = 0 ; i < 4 ; i++){
                int r = dot[0] + dr[i];
                int c = dot[1] + dc[i];
                if(0 <= r && r < N && 0 <= c && c < M &&
                        map[r][c] != 'X' && !isVisited[r][c]){
                    queue.offer(new Integer[]{r,c});
                    isVisited[r][c] = true;
                    if(map[r][c] == 'P'){
                        meet++;
                    }
                }
            }
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        meet = 0;
        map = new char[N][M];
        isVisited = new boolean[N][M];
        for(int i = 0 ; i < N ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < M ; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'I'){
                    startR = i;
                    startC = j;
                }
            }
        }
        bfs();
        System.out.println(meet == 0 ? "TT" : meet);
    }
}
