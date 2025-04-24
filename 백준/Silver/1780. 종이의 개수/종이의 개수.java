import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static int[] count = new int[3]; //count[0] : -1의 개수, count[1] = 0의 개수, count[2] = 1의 개수
    static int divideAndConquer(int r, int c, int size){
        if(size == 1) return map[r][c];
        int newSize = size / 3;
        int[] now = new int[4];
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                now[divideAndConquer(r + i * newSize, c + j * newSize, newSize)]++;
            }
        }
        if(now[0] == 9){
            return 0;
        } else if(now[1] == 9){
            return 1;
        }
        else if(now[2] == 9){
            return 2;
        } else{
            for(int i = 0 ; i < 3 ; i++){
                count[i] += now[i];
            }
            return 3;
        }
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i = 0 ; i < N ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken()) + 1;
            }
        }

        int result = divideAndConquer(0,0,N);
        if(result != 3){
            sb.append(result == 0 ? 1 : 0).append('\n').append(result == 1 ? 1 : 0).append('\n').append(result == 2 ? 1 : 0);
        } else{
            sb.append(count[0]).append('\n').append(count[1]).append('\n').append(count[2]);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
