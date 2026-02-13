import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static long[][] adj;
    public static int D;
    public static long[][] multiply(long[][] m1, long[][] m2){
        long[][] result = new long[8][8];
        long MOD = 1_000_000_007;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                for(int k = 0; k < 8; k++){
                    long val = (m1[i][k] * m2[k][j]) % MOD;
                    result[i][j] = (result[i][j] + val) % MOD;
                }
            }
        }
        return result;
    }
    public static long[][] divideAndConquer(int d){
        if(d == 1){
            return adj;
        }
        long[][] half = divideAndConquer(d / 2);
        return d % 2 == 0 ? multiply(half, half) : multiply(multiply(half, half), adj);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        D = Integer.parseInt(br.readLine());
        adj = new long[][]{
                // 0:정보, 1:전산, 2:미래, 3:신양, 4:한경직, 5:진리, 6:학생, 7:형남
                {0, 1, 1, 0, 0, 0, 0, 0}, // 0:정보과학관
                {1, 0, 1, 1, 0, 0, 0, 0}, // 1:전산관
                {1, 1, 0, 1, 1, 0, 0, 0}, // 2:미래관
                {0, 1, 1, 0, 1, 1, 0, 0}, // 3:신양관
                {0, 0, 1, 1, 0, 1, 0, 1}, // 4:한경직기념관
                {0, 0, 0, 1, 1, 0, 1, 0}, // 5:진리관
                {0, 0, 0, 0, 0, 1, 0, 1}, // 6:학생회관
                {0, 0, 0, 0, 1, 0, 1, 0}  // 7:형남공학관
        };
        System.out.println(divideAndConquer(D)[0][0]);
    }
}
