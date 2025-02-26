import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Integer.parseInt(st.nextToken());
        long K = Integer.parseInt(st.nextToken());

        long[] A = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        //a , a + K , a + 2K ....
        long a = Integer.MIN_VALUE; //최소항
        for(int i = 0 ; i < N ; i++){
            a = Math.max(a, Math.max(A[i] - i * K,0));
        }
        System.out.println(N * (2 * a + (N - 1) * K) / 2 - Arrays.stream(A).sum());
    }
}
