import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer st1,st2;
        int[] a = new int[N];
        int[] b = new int[N];
        st1 = new StringTokenizer(bufferedReader.readLine());
        st2 = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0 ; i < N;  i++){
            a[i] = Integer.parseInt(st1.nextToken());
            b[i] = Integer.parseInt(st2.nextToken());
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int sum = 0;
        for(int i = 0 ; i < N ; i++){
            sum += a[i] * b[N - i - 1];
        }
        System.out.println(sum);
    }
}
