import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dr = {-1,0,1,0}, dc = {0, 1, 0, -1};
        int count = 0;
        while (true){
            if (map[r][c] == 0){
                map[r][c] = -1; //청소 완료
                count++;
            }
            boolean flag = false;
            for(int i = 0 ; i < 4 ; i++){
                int nr = r + dr[i], nc = c + dc[i];
                if(0 <= nr && nr < N && 0 <= nc && nc < M && map[nr][nc] == 0){
                    flag = true;
                    break;
                }
            }

            if (flag){
                //0 -> 3, 1 -> 0 , 2 -> 1, 3 -> 2
                d = (d + 3) % 4;
                if (map[r + dr[d]][c + dc[d]] == 0){
                    r += dr[d];
                    c += dc[d];
                }
            }
            else{
                //0 -> 2, 1 -> 3, 2 -> 0, 3 -> 1
                int dir_back = (d + 2) % 4;
                if (map[r + dr[dir_back]][c + dc[dir_back]] == 1) break;
                r += dr[dir_back];
                c += dc[dir_back];
            }
        }
        System.out.println(count);
    }
}
