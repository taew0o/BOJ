import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int R,C;
    public static boolean[][] map;
    public static int count = 0;
    public static boolean dfs(int r, int c){
        map[r][c] = true;
        if(c == C - 1){
            count ++;
            return true;
        }

        for(int i = -1 ; i <= 1 ; i++){
            int nr = r + i;
            int nc = c + 1;
            if(0 <= nr && nr < R && 0 <= nc && nc < C && !map[nr][nc]){
                if(dfs(nr, nc)) return true;
            }
        }
        return false;
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); C = Integer.parseInt(st.nextToken());
        map = new boolean[R][C];
        for(int i = 0 ; i < R ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < C ; j++){
                map[i][j] = str.charAt(j) == 'x';
            }
        }
        for(int r = 0 ; r < R ; r++){
            dfs(r, 0);
        }
        System.out.println(count);
    }
}
