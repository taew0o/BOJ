import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K =  Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int prev = Integer.parseInt(st.nextToken());
        int[] diff = new int[N - 1];
        for(int i = 0 ; i < N - 1 ; i++){
            int now = Integer.parseInt(st.nextToken());
            diff[i] = now - prev;
            prev = now;
        }
        Arrays.sort(diff);
        long result = 0;
        for(int i = 0 ; i < N - K ; i++){
            result += diff[i];
        }
        System.out.println(result);
    }
}
