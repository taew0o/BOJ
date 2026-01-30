import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N,M;
    public static int[][] map; //-1 : 벽, 0 : 빈칸 or 구슬, 1 : target
    public static int[] target, red, blue;
    public static boolean[][][][] visited; //red r, red c, blue r, blue c
    public static int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public static int[] move(int r, int c, int dir){
        int nr = r + dirs[dir][0], nc = c + dirs[dir][1];
        while (map[nr][nc] != -1){
            if(nr == target[0] && nc == target[1]){
                return new int[]{nr, nc, 1};
            }
            r = nr; c = nc;
            nr = r + dirs[dir][0];
            nc = c + dirs[dir][1];
        }
        //먼저 움직인 공이 target에 들어가서 -1인 경우
        if(nr == target[0] && nc == target[1]){
            return new int[]{nr, nc, 1};
        }
        return new int[]{r, c, 0};
    }
    public static int[] moveAll(int redR, int redC, int blueR, int blueC, int dir){
        boolean redFirst = true;
        switch (dir){
            case 0:
                redFirst = redR <= blueR;
                break;
            case 1:
                redFirst = redR >= blueR;
                break;
            case 2:
                redFirst = redC <= blueC;
                break;
            case 3:
                redFirst = redC >= blueC;
                break;
        }
        int[] redNext, blueNext;
        if(redFirst){
            map[blueR][blueC] = -1;
            redNext = move(redR, redC, dir);
            map[blueR][blueC] = 0;
            map[redNext[0]][redNext[1]] = -1;
            blueNext = move(blueR, blueC, dir);
            map[redNext[0]][redNext[1]] = 0;
        } else{
            map[redR][redC] = -1;
            blueNext = move(blueR, blueC, dir);
            map[redR][redC] = 0;
            map[blueNext[0]][blueNext[1]] = -1;
            redNext = move(redR, redC, dir);
            map[blueNext[0]][blueNext[1]] = 0;
        }
        return new int[]{redNext[0], redNext[1], blueNext[0], blueNext[1]};
    }
    public static int bfs(){
        visited = new boolean[N][M][N][M];
        visited[red[0]][red[1]][blue[0]][blue[1]] = true;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{red[0], red[1], blue[0], blue[1], 0});
        while (!queue.isEmpty()){
            int[] now =  queue.poll();
            if(now[4] >= 10) continue;
            for(int i = 0 ; i < 4 ; i++){
                int[] next = moveAll(now[0],now[1], now[2], now[3], i);
                if(!visited[next[0]][next[1]][next[2]][next[3]]){
                    if(next[2] == target[0] && next[3] == target[1]) continue;
                    if(next[0] == target[0] && next[1] == target[1]) {
                        return now[4] + 1;
                    }
                    visited[next[0]][next[1]][next[2]][next[3]] = true;
                    queue.offer(new int[]{next[0], next[1], next[2], next[3], now[4] + 1});
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        target = new int[2]; red = new int[2]; blue = new int[2];
        for(int i = 0 ; i < N ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < M ; j++){
                switch (str.charAt(j)){
                    case '#':
                        map[i][j] = -1;
                        break;
                    case 'R':
                        red[0] = i; red[1] = j;
                        break;
                    case 'B':
                        blue[0] = i; blue[1] = j;
                        break;
                    case 'O':
                        target[0] = i; target[1] = j;
                        break;
                }
            }
        }
        System.out.println(bfs());
    }
}
