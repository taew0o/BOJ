import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] count = new int[1000 + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            count[Integer.parseInt(st.nextToken())]++;
        }
        int sum = 0;
        for(int i = 0 ; i <= 1000 ; i++){
            sum += Math.min(2, count[i]);
        }
        System.out.println(sum);
    }
}
