import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    public static int draw(int r, int c, int size){
        if(size == 1){
            return arr[r][c];
        }
        int[] result = new int[4];
        for(int i = 0 ; i < 4 ; i++){
            result[i] = draw(r + (i / 2) * size / 2 , c + (i % 2) * size / 2 , size / 2);
        }
        Arrays.sort(result);
        return result[1];
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(draw(0,0, N));
    }
}
