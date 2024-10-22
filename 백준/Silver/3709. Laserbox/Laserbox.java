import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        final int LEFT = 0 , UP = 1 , RIGHT = 2 , DOWN = 3;

        int[] dr = {0,-1,0,1}, dc = {-1,0,1,0};

        while (T --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken());

            boolean[][] map = new boolean[n + 2][n + 2]; //0은 빈칸, 1은 켜지지 않은 방향 전환기, 2는 켜진 방향 전환기
            boolean[][][] visited = new boolean[n + 2][n + 2][4];//순환 여부를 판단하기 위해 특정 방향으로부터 해당 지점에 들어왔는지 확인
            for(int i = 0 ; i < r ; i++){
                st = new StringTokenizer(br.readLine());
                map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
            }

            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken()), col = Integer.parseInt(st.nextToken());
            //0 : 좌 , 1 : 상 , 2 : 우 , 3 : 하
            int dir = (row == n + 1) ? UP : (row == 0) ? DOWN :
                    (col == n + 1) ? LEFT : RIGHT;
            while (true){
                row += dr[dir]; col += dc[dir];
                boolean flag = false;
                while (0 < row && row <= n && 0 < col && col <= n){
                    if(map[row][col]){
                        if(visited[row][col][dir]){
                            row = 0; col = 0;
                            break;
                        }
                        visited[row][col][dir] = true;
                        dir = (dir + 1) % 4;
                        flag = true;
                        break;
                    }
                    row += dr[dir]; col += dc[dir];
                }
                if(!flag){
                    sb.append(row).append(" ").append(col).append('\n');
                    break;
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
