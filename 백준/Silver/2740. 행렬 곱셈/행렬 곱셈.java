import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N,M,K;

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());

        int[][] A = new int[N][M];
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); K = Integer.parseInt(st.nextToken());

        int[][] B = new int[M][K];
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < K ; j++){
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = new int[N][K];
        for(int r = 0 ; r < N ; r++){
            for(int c = 0 ; c < K ; c++){
                for(int i = 0 ; i < M ; i++){
                    result[r][c] += A[r][i] * B[i][c];
                }
                sb.append(result[r][c]).append(" ");
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
