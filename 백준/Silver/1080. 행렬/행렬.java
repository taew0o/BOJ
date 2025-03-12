import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        boolean[][] arr1 = new boolean[N][M], arr2 = new boolean[N][M] , isSame = new boolean[N][M];
        for(int i = 0 ; i < N ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < M ; j++){
                arr1[i][j] = str.charAt(j) == '1';
            }
        }
        for(int i = 0 ; i < N ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < M ; j++){
                arr2[i][j] = str.charAt(j) == '1';
                isSame[i][j] = arr1[i][j] == arr2[i][j];
            }
        }

        int count = 0;
        for(int i = 0 ; i < N - 2 ; i++){
            for(int j = 0 ; j < M - 2 ; j++){
                if(!isSame[i][j]){
                    count++;
                    for(int ni = i ; ni <= i + 2 ; ni++){
                        for(int nj = j ; nj <= j + 2 ; nj++){
                            isSame[ni][nj] = !isSame[ni][nj];
                        }
                    }
                }
            }
        }

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(!isSame[i][j]){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(count);
    }
}
