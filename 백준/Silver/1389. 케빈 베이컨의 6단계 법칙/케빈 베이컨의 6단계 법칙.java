import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(i == j){
                    map[i][j] = 0;
                }
                else{
                    map[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1, b = Integer.parseInt(st.nextToken()) - 1;
            map[a][b] = 1;
            map[b][a] = 1;
        }
        for(int k = 0 ; k < N ; k++){
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < N ; j++){
                    if(map[i][k] != Integer.MAX_VALUE && map[k][j] != Integer.MAX_VALUE) {
                        map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                    }
                }
            }
        }

        int result = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < N ; i++){
            int sum = 0;
            for(int j = 0 ; j < N ; j++) {
                sum += map[i][j];
            }
            if(sum < min){
                min = sum;
                result = i + 1;
            }
        }
        System.out.println(result);
    }
}
