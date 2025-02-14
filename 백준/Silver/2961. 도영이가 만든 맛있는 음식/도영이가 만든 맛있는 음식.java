import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int[][] taste;
    public static int min_diff = Integer.MAX_VALUE;
    public static void dfs(int depth, int sour, int sweet){
        if(depth == N){
            if(sour != 1) {
                min_diff = Math.min(min_diff, Math.abs(sour - sweet));
            }
            return;
        }
        //해당 재료를 사용한 경오
        dfs(depth + 1, sour * taste[depth][0] , sweet + taste[depth][1]);
        //해당 재료를 사용하지 않은 경우
        dfs(depth + 1, sour , sweet);
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        taste = new int[N][2];
        for(int i = 0 ; i < N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            taste[i][0] = Integer.parseInt(st.nextToken());
            taste[i][1] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 1, 0);
        System.out.println(min_diff);
    }
}

