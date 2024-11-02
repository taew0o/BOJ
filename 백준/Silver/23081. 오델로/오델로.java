import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        
        for(int i = 0 ; i < N ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < N ; j++){
                char c = str.charAt(j);
                map[i][j] = c == '.' ? 0 : c == 'W' ? 1 : 2; //0이면 빈칸 1이면 백돌 2이면 흑돌
            }
        }
        
        int result = 0;
        int x = - 1 , y = -1;
        int[] dr = {-1,1,0,0,-1,1,-1,1}, dc = {0,0,-1,1,-1,-1,1,1};//왼,오,상,하,좌상,우상,좌하,우하
        
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(map[i][j] == 0){
                    int count = 0;
                    for(int dir = 0 ; dir < 8 ; dir++){
                        int temp = 0;
                        int r = i + dr[dir], c = j + dc[dir];
                        while (0 <= r && r < N && 0 <= c && c < N && map[r][c] == 1){
                            temp++;
                            r += dr[dir]; c += dc[dir];
                        }
                        if(0 <= r && r < N && 0 <= c && c < N && map[r][c] == 2){
                            count += temp;
                        }
                    }
                    if(count > result){
                        result = count;
                        x = j; y = i;
                    }
                }
            }
        }
        if(x == -1){
            sb.append("PASS");
        }
        else{
            sb.append(x).append(" ").append(y).append('\n').append(result);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
