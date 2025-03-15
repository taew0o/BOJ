import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong).sorted().toArray();

        if(N == 1){
            System.out.println(arr[0]);
            return;
        }

        long[] sum = new long[N];
        sum[0] = arr[0];
        for(int i = 1 ; i < N ; i++){
            sum[i] = sum[i - 1] + arr[i];
        }

        long min = Long.MAX_VALUE;
        long index = -1;
        for(int i = 0 ; i < N ; i++){
            long left = i == 0 ? 0 : i * arr[i] - sum[i - 1];
            long right = i == N - 1 ? 0 : sum[N - 1] - sum[i] - (N - 1 - i) * arr[i];
            if(left + right < min){
                min = left + right;
                index = arr[i];
            }
        }
        System.out.println(index);
    }
}
