import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[][] map; //-1은 공기, 0은 빈칸 , 1은 치즈
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};

    public static int bfs(){
        //초기 설정
        Queue<int[]> airs = new LinkedList<>() , cheezes = new LinkedList<>();
        for(int i = 0 ; i < N ; i++){
            airs.offer(new int[]{i, 0});
            airs.offer(new int[]{i, M - 1});
        }
        for(int c = 1 ; c < M - 1 ; c++){
            airs.offer(new int[]{0, c});
            airs.offer(new int[]{N - 1, c});
        }
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(map[i][j] == 1){
                    cheezes.offer(new int[]{i, j});
                }
            }
        }
        int t = 0;
        while (true) {
            //공기 확산
            for(int[] air : airs){
                map[air[0]][air[1]] = -1;
            }
            while (!airs.isEmpty()){
                int[] air = airs.poll();
                for(int i = 0 ; i < 4 ; i++){
                    int nr = air[0] + dr[i], nc = air[1] + dc[i];
                    if (0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] == 0) {
                        map[nr][nc] = -1;
                        airs.offer(new int[]{nr,nc});
                    }
                }
            }
            //치즈 녹음 판정
            Queue<int[]> tomorrow = new LinkedList<>();
            while (!cheezes.isEmpty()){
                int[] cheeze = cheezes.poll();
                int count = 0;
                for(int i = 0 ; i < 4 ; i++){
                    int nr = cheeze[0] + dr[i], nc = cheeze[1] + dc[i];
                    if(0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] == -1){
                        count++;
                    }
                }
                if(count >= 2){ //녹을 수 있는 경우
                    airs.offer(cheeze);
                }
                else{
                    tomorrow.offer(cheeze);
                }
            }
            if(tomorrow.isEmpty()) return t + 1;
            cheezes = tomorrow;
            t++;
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
            }
        }
        System.out.println(bfs());
    }
}
