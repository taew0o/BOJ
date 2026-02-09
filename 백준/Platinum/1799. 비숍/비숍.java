import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[][] canPut;
    static boolean[] dia1, dia2; //왼위 대각, 오아 대각
    static int black = 0, white = 0;
    public static void dfs(int index, int count, boolean isBlack){
        if(index >= N * N){
            if(isBlack) black = Math.max(black, count);
            else white = Math.max(white, count);
            return;
        }
        int r = index / N, c = index % N;
        if(canPut[r][c] && !dia1[r + c] && !dia2[r - c + N - 1]){
            dia1[r + c] = dia2[r - c + N - 1] = true;
            dfs(getNextIndex(index), count + 1, isBlack);
            dia1[r + c] = dia2[r - c + N - 1] = false;
        }
        dfs(getNextIndex(index), count, isBlack);
    }
    public static int getNextIndex(int index){
        int next = index + 2;
        if(N % 2 == 0){
            if(next % N == 0) next ++;
            else if(next % N == 1) next --;
        }
        return next;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        canPut = new boolean[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                canPut[i][j] = st.nextToken().equals("1");
            }
        }

        dia1 = new boolean[2 * N - 1]; dia2 = new boolean[2 * N - 1];
        dfs(0, 0, true);
        dfs(1, 0, false);
        System.out.println(black + white);
    }
}
